package MVC_Controller;
import exceptions.AttemptsTerminatedException;
import exceptions.CheatException;

import java.util.Objects;

import MVC_Model.AbstractPlayer;
import MVC_Model.Level;
import MVC_Model.Settings;
import MVC_Model.TableManager;
import MVC_Model.VirtualDecoder;
import MVC_Model.VirtualEncoder;
import MVC_Model.RandomEncoder;
import MVC_Model.VirtualPlayer;
import MVC_Model.Winner;
import MVC_View.Display;
import interfaces.CluesContract;
import interfaces.DecoderContract;
import interfaces.DisplayContract;
import interfaces.EncoderContract;
import interfaces.PlayerContract;

/**
 * <b>Responsabilità:</b> Si occupa di coordinare la partita.
 * Un coordinatore deve conoscere:
 * - i due giocatori: <code>encoder</code> e <code>decoder</code>;
 * - il livello corrente: <code>level</code>;
 * - il settore corrente del tavolo dove verranno inseriti gli elementi: <code>currentTableSector</code>;
 * - il tavolo da gioco: <code>table</code>;
 * - se sono ammesse ripetizioni nel codice: <code>repetitions</code>;
 * - se deve coordinare una singola partita o più livelli consecutivi: tramite l'attributo <code>singleMatch</code>.
 * Inoltre fa uso di:
 * - un {@link Display} per comunicare con l'utente;
 * - un {@link TableManager} per interagire con il tavolo.
 **/

public class Coordinator {
	
	/**
	 * Le impostazioni di gioco attuali. 
	 **/
	protected Settings settings;
	
	/**
	 * Il codificatore attuale.
	 * */
	protected EncoderContract encoder;
	
	/**
	 * Il decodificatore attuale.
	 * */
	protected DecoderContract decoder;
	
	/**
	 * Il livello attuale.
	 * */
	protected Level level;
	
	/**
	 * Il settore del tavolo attuale.
	 * */
	private int currentTableSector;
	
	/**
	 * La vista attuale.
	 * */
	protected DisplayContract display;
	
	/**
	 * Il gestore del tavolo attuale.
	 * */
	protected TableManager manager;
	
	/**
	 * Il flag per le ripetizioni.
	 * */
	protected boolean repetitions;
	
	/**
	 * Il flag per la singola partita.
	 * */
	protected boolean singleMatch;
	
	/**
	 * Crea un coordinatore con le opzioni di gioco scelte. Se <code>settings.getLevel()<code> è 0, 
	 * coordinerà più livelli
	 * @param settings: le opzioni di gioco scelte.
	 **/
	public Coordinator(Settings settings) {
		Objects.requireNonNull(settings);
		this.settings = settings;
		this.singleMatch = settings.getLevel() == 0 ? false:true;
		this.level = singleMatch? new Level(settings.getLevel(), settings.getRepetitions(), settings.getUppercase()): new Level();
		this.level.setLevel();
		this.repetitions = settings.getRepetitions();
		this.decoder = settings.getDecoder();
		this.encoder = settings.getEncoder();
	}
	
	/**
	 * Fa partire una partita in base al <code>singleMatch</code>. 
	 * <code>singleMatch == true</code> : si effettua una partita del livello preimpostato.
	 * <code>singleMatch == false</code> : si effettuano più partite consecutive, incrementando di livello, solo se il vincitore dell'attuale partita è il decodificatore. 
	 * I livelli vanno dall'1 al limite imposto nella classe {@link Level}.
	 **/
	public final void start() {
		if (singleMatch) start(this.level);
		else{
			int limit = level.getLimit();
			for(int l=0; l<= limit; l++) {
				this.level = new Level(l, this.repetitions, this.settings.getUppercase());
				this.level.setLevel();
				if(!start(this.level)) break;
			} 
		}
	}
	
	/**
	 * Fa partire una partita del livello <code>level</code> specificato.
	 * @return true se il vincitore è stato il decodificatore.
	 * */
	private final boolean start(Level level){
		initialize(level);
		display.firstDisplay();
		askCode(encoder);
		Winner winner = newTurn();
		display.printMessage(winner.winnerIs());	
		display.printTable();
		return winner.getWinner() == "encoder"? false:true;
	}
	
	/**
	 * Inizializza i componenti della partita in base al <code>level</code>.
	 * Il <code>currentTableSector</code> viene settato a -1 per indicare che all'inizio di ogni partita, 
	 * il codice inserito è quello del codificatore.
	 * @param level: il livello scelto.
	 **/
	protected void initialize(Level level ) {
		this.level = level;
		this.manager = new TableManager(level);
		this.currentTableSector = -1;
		setDisplay();
		setPlayers();
	}
	
	/**
	 * Imposta la vista utilizzata.
	 **/
	protected void setDisplay() {
		this.display = new Display(manager.getTable(), this.level);			
	}
	
	/**
	 * Imposta il livello e il manager ai giocatori.
	 * */
	protected void setPlayers() {
		if(decoder!=null) {
			((AbstractPlayer)this.decoder).setLevel(this.level);
			((VirtualDecoder)this.decoder).setManager(manager);
		} 
		if(encoder!=null) {
			((AbstractPlayer)this.encoder).setLevel(this.level);
			((VirtualEncoder)this.encoder).setManager(manager);
		}
	}
	
	/**
	 * Coordina i due giocatori e comunica con il <code>display</code>.
	 * @return il vincitore della partita.
	 **/
	protected Winner newTurn(){
		try {
			nextTurn();
			askCode(decoder);
			display.firstDisplay();
			askClues();
			display.firstDisplay();
			return manager.getClues(currentTableSector).onlyBlackClues(level.getCodeLength())? new Winner(decoder): newTurn();
		} catch (AttemptsTerminatedException e) {
			return new Winner(encoder);
		}
	}
	
	/**
	 * Incrementa il settore corrente del tavolo.
	 * @throws {@link AttemptsTerminatedException} se terminano i tentativi.
	 **/
	private void nextTurn() throws AttemptsTerminatedException {
		this.currentTableSector++;
		if(currentTableSector == level.getAttempts()) throw new AttemptsTerminatedException();
	}

	/**
	 * Chiede al giocatore <code>player</code> il codice. Se il giocatore è l'utente (<code>null</code>) 
	 * fa uso del {@link TableManager} , che lo inserisce nella giusta parte.
	 * @param player: il giocatore a cui è rivolta la richiesta.
	 **/
	private void askCode(PlayerContract player) {
		if(player == null) manager.add(display.askCode());
		else ((VirtualPlayer)player).addCode();
	}

	/**
	 * Chiede al codificatore gli indizi. Se il giocatore è l'utente (<code>null</code>):
	 * - per evitare imbrogli ( {@link CheatException} ) fa uso del {@link RandomEncoder} per controllare la validità 
	 * del suo input;
	 * - fa uso del {@link TableManager}, che lo inserisce nella giusta parte. 
	 **/ 
	private void askClues(){
		CluesContract clues = null;
		while(clues == null) {
			try {	
				clues = new RandomEncoder().createClues(manager.getTable().getSecretCode(),manager.getCode(currentTableSector));	
				if(encoder != null || display.askClues().equals(clues)) manager.add(clues);
				else throw new CheatException();	
			}catch (CheatException e) {
				e.message(); 
				clues = null;
			}
		}	
	}
}