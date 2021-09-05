package MVC_View;
import java.io.IOException;
import java.util.Random;

import exceptions.IncorrectAnswerException;
import exceptions.IncorrectCodeLengthException;
import exceptions.IncorrectFormatException;
import MVC_Model.Clue;
import MVC_Model.Clues;
import MVC_Model.Level;
import MVC_Model.Settings;
import factoryMethodPattern.PlayersRegister;
import interfaces.CodeContract;
import interfaces.DisplayContract;
import interfaces.InputInterface;
import interfaces.TableContract;

/**
 * <b>Responsabilità:</b> rappresenta la vista su console.
**/
public class Display implements DisplayContract, InputInterface {
	/**
	 * Il tavolo da gioco.
	 **/
	private TableContract table;
	
	/**
	 * Il livello attuale
	 * */
	private Level level;
	
	/**
	 * Crea una nuova vista.
	 * @param table: il tavolo da gioco.
	 * @param level: il livello attuale.
	 * */
	public Display(TableContract table, Level level) {
		this.table = table;
		this.level = level;
	}
	
	/**
	 * Crea una nuova vista.
	 * */
	public Display() {
		this.level = new Level();
	}

	@Override
	public void firstDisplay() {
		printLevel();
		printVisibleTable();
		printAlphabet();
	}
	
	@Override
	public void printVisibleTable() {
		String str="";
		for(int i = 0; i < table.getCodes().length; i++) { 
			str += (i+1) + (table.getCodes()[i] == null? "" : " " + table.getCodes()[i].toString());
			str += (table.getClues()[i]==null ? "" : " " + table.getClues()[i].toString());
			str += "\n";
		}
		System.out.println(str);
	}
	
	@Override
	public void printAlphabet() {System.out.println(level.getAlphabet().toString());}
	
	/**
	 * Stampa gli indizi.
	 **/
	public void printClues() {System.out.println(Clue.values());}
	
	/**
	 * Stampa il livello.
	 **/
	public void printLevel() {
		System.out.println("Livello: " + level.getNum());
	}
	
	@Override
	public void printTable() {
		printVisibleTable();
		System.out.println("Secret code = " + table.getSecretCode().toString());
	}
	
	/**
	 * Ritorna il tavolo della partita corrente.
	 * @return il tavolo della partita corrente.
	 **/
	public TableContract getTable() {
		return this.table;
	}
	
	/**
	 * Ritorna il livello della partita corrente.
	 * @return il livello della partita corrente.
	 **/
	public Level getLevel() {
		return this.level;
	}
	
	public Settings askSettings() {
		return new Settings(ask(true), ask(false),askLevel(), askRepetitions(), askUppercase());
	}
	
	@Override
	public boolean playAgain(){ 
		System.out.println("Vuoi giocare ancora? S/N");
		return insertSN();
		
	}
	
	/**
	 * Traduce la risposta dell'utente in un booleano.
	 * @return true se la risposta è stata affermativa, false altrimenti.
	 * */
	private boolean insertSN(){
		String answer="";
		while(answer=="") {
			try {
				answer = insertInput();
				if(!answer.equals("S") & !answer.equals("N")) throw new IncorrectAnswerException();
			}catch(IncorrectAnswerException e) {
				e.message();
				answer="";
			}catch(IOException e) {
				answer="";
			}
		}
		return answer.equals("S")? true : false;
	}

	/**
	 * Chiede all'utente il tipo di giocatore (computer o un giocatore interattivo).
	 * @param cond = true: si chiede di inserire il codificatore.
	 * @param cond = false: si chiede di inserire il decodificatore.
	 * @return il nome della classe del tipo del giocatore scelto.
	 * @return null se si è scelto un giocatore di tipo interattivo.
	 **/
	private String ask(boolean cond) {
		System.out.println("Vuoi che il " + (cond? "codificatore?": "decodificatore?") + " sia il computer?");
		while(true) {
			System.out.println("Inserisci 'S' o 'N'");
			try{
				return insertSN()? insert(cond): null;
			}catch(IllegalArgumentException | IOException e) {};
		}	
	}

	/**
	 * Viene scelto in modo randomico il tipo di giocatore virtuale dal <code>register</code>.
	 * @param cond = true: viene scelto un codificatore casuale.
	 * @param cond = false: viene scelto un decodificatore casuale.
	 * @return il nome della classe del tipo del giocatore scelto.
	 **/
	private String insert(boolean cond) throws IOException, IllegalArgumentException {
		PlayersRegister register = new PlayersRegister();
		return cond? register.getEncoders().get(new Random().nextInt(register.getEncoders().size())).getClass().getName():
			register.getDecoders().get(new Random().nextInt(register.getDecoders().size())).getClass().getName();
	}

	/**
	 * Chiede all'utente se ammette ripetizioni nel codice.
	 * @return true in caso di risposta affermativa, false altrimenti. 
	 **/
	private boolean askRepetitions() {
		System.out.println("Permetti ripetizioni nel codice? S/N");
		return insertSN();
	}

	/**
	 * Chiede all'utente se vuole lettere maiuscole.
	 * @return true in caso di risposta affermativa, false altrimenti. 
	 **/
	private boolean askUppercase() {
		System.out.println("Vuoi lettere maiuscole? S/N");
		return insertSN();
	}
	
	/**
	 * Chiede all'utente se vuole lettere maiuscole.
	 * @return true in caso di risposta affermativa, false altrimenti. 
	 **/
	private Integer askLevel() {
		System.out.println("Vuoi giocare ad un livello specifico? S/N");
		return insertSN()? askNumLevel(): 0;
	}
	
	/**
	 * Chiede all'utente quale livello vuole giocare.
	 * @return 1 se il numero inserito dall'utente è minore a 1.
	 * @return level.getLimit() se il numero inserito dall'utente è maggiore al limite impostato sui livelli.
	 * @return il numero del livello scelto se il numero inserito dall'utente è valido.
	 **/
	private int askNumLevel() {
		while (true) {
			System.out.println("Quale? Inserisci un numero da 1 a " + level.getLimit());
			try {
				int n = Integer.parseInt(insertInput());
				return n > level.getLimit()? level.getLimit():(n<1? 1:n);
			} catch (NumberFormatException |IOException e) {} 
		}
	}

	public CodeContract askCode() {
		while(true) {
			try {
				System.out.println("Inserisci il codice di " + level.getCodeLength() + " lettere" );
				CodeContract code = level.getAlphabet().convertInCode(insertInput());
				code.controlLength(level.getCodeLength());
				return code;
			} catch (IncorrectFormatException | IncorrectCodeLengthException e) {
				e.message();
			}catch(IOException e) {
			}
		}
	}
	
	public Clues askClues() {
		while(true) {
			System.out.println("Inserisci gli indizi: ");
			try {
				return new Clues().converteInClues(insertInput());
			} catch (IncorrectFormatException | IOException  e) { 
				e.getMessage();
			}
		}
	}

	public void printMessage(String str) {
		System.out.println(str);		
	}
}