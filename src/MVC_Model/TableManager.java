package MVC_Model;
import java.util.Objects;

import interfaces.CluesContract;
import interfaces.CodeContract;
import interfaces.TableContract;
/**
 * <b>Responsabilità:</b> rappresenta il gestore del tavolo. 
 * Oltre ad occuparsi della creazione del tavolo da gioco, inserisce e comunica elementi al suo interno.
 **/

public class TableManager{
	
	/**
	 * Il tavolo da gioco
	 **/
	protected TableContract table;
	
	/**
	 * Il settore corrente
	 **/
	protected int currentSector;
	
	/**
	 * La lunghezza del codice.
	 **/
	protected int codeLength;
	
	/**
	 * Crea un gestore del tavolo secondo il <code>level</code> passato.
	 **/
	public TableManager(Level level) {
		Objects.requireNonNull(level);
		this.table = new Table(level.getAttempts());
		this.codeLength = level.getCodeLength();
		this.currentSector = -1;
	}

	/**
	 * Ritorna il tavolo da gioco.
	 * @return il tavolo da gioco
	 */
	public TableContract getTable() {
		return table;
	}

	/**
	 * Aggiunge al tavolo il codice specificato.
	 * @param code: il codice da aggiungere.
	 **/
	public void add(CodeContract code){
		Objects.requireNonNull(code);
		if(currentSector==-1) {
			
			table.setSecretCode(code);
			nextSector();
		}
		else table.setCode(currentSector, code); 
	}
	
	/**
	 * Aggiunge al tavolo gli indizi specificati.
	 * @param clues: gli indizi da aggiungere.
	 **/
	public void add(CluesContract clues){
		Objects.requireNonNull(clues);
		table.setClues(currentSector, clues);
		nextSector();
	}
	
	/**
	 * Determina se il tavolo contiene il codice specificato
	 * @param code: il codice da trovare.
	 * @return true se il codice è già presente nel tavolo, false altrimenti.
	 **/
	public boolean contains(CodeContract code) {
		Objects.requireNonNull(code);
		for(CodeContract c : table.getCodes()) if (c.equals(code)) return true;
		return false;
	}
	
	/**
	 * Ritorna il codice alla posizione del tavolo specificata.
	 * @param position: la posizione del codice da ritornare.
	 * @return il codice alla posizione <code>position</code>.
	 * @return null se <code>position</code> è fuori dal range del tavolo.
	 **/
	public CodeContract getCode(int position){
		return position < 0 | position >= table.getCodes().length? null : this.table.getCodes()[position];
	}
	
	/**
	 * Ritorna gli indizi alla posizione del tavolo specificata.
	 * @param position: la posizione del codice da ritornare.
	 * @return gli indizi alla posizione <code>position</code>.
	 * @return null se <code>position</code> è fuori dal range del tavolo.
	 **/
	public CluesContract getClues(int position){
		if (position ==-1) table.getSecretCode();
		return position < -1 | position >= table.getClues().length? null :this.table.getClues()[position];
	}
	
	/**
	 * Restituisce il numero del settore corrente.
	 * @return il numero del settore corrente.
	 **/
	public int getCurrentTurn() {
		return currentSector;
	}
	
	/**
	 * Cambia il settore corrente, incrementandolo di una posizione.
	 **/
	public void nextSector() {currentSector++;}
	
	/**
	 * Restituisce la lunghezza del codice ammessa per quel tavolo.
	 * @return la lunghezza del codice.
	 **/
	public int getCodeLength() {return this.codeLength;}
}