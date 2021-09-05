package MVC_Model;

import factoryMethodPattern.PlayersFactory;
import interfaces.DecoderContract;
import interfaces.EncoderContract;

/**
 * Responsabilità: Si occupa dei parametri di gioco:
 * - <code>encoderType</code>: tipo di codificatore;
 * - <code>decoderType</code>: tipo di decodificatore;
 * - <code>level</code>: indica il livello di gioco scelto;
 * - <code>repetitions</code>: indica se sono ammesse ripetizioni di palline all'interno dei codici.
 * - <code>uppercase</code>: indica se il tipo di carattere scelto. Se impostato a <code>true</code> 
 * verrà creato un alfabeto con caratteri maiuscoli, altrimenti minuscoli.
 * @author Veronica
 **/
public class Settings{
	/**
	 * Il codificatore.
	 **/
	protected EncoderContract encoder;
	
	/**
	 * Il decodificatore.
	 **/
	protected DecoderContract decoder;
	
	/**
	 * Il livello della partita
	 * */
	protected int level;
	
	/**
	 * Il creatore di giocatori.
	 **/
	private PlayersFactory factory;

	/**
	 * Il flag per le ripetizioni.
	 **/
	private boolean repetitions;

	/**
	 * Il flag per i caratteri.
	 * */
	private boolean uppercase;
	
	/**
	 * Crea le opzioni vuote.
	 **/
	public Settings() {
		 factory = new PlayersFactory();
	}
	
	/**
	 * Crea le opzioni con i parametri specificati.
	 * @param encoderType: tipo di codificatore; se null si considera il giocatore interattivo.
	 * @param decoderType: tipo di decodificatore; se null si considera il giocatore interattivo.
	 * @param repetitions: indica se sono ammesse ripetizioni.
	 * @param uppercase: indica se si è stato scelto il tipo di caratteri maiuscoli.
	 **/
	public Settings(String encoderType, String decoderType, int level, boolean repetitions, boolean uppercase){
		this();
		this.encoder = encoderType == null? null : factory.getEncoder(encoderType);
		this.decoder = decoderType == null? null : factory.getDecoder(decoderType);
		this.level = level;
		this.repetitions = repetitions;
		this.uppercase = uppercase;
	}
	
	
	/**
	 * Restituisce il decodificatore.
	 * @return il decodificatore.
	 **/
	public DecoderContract getDecoder() {
		return decoder;
	}

	/**
	 * Restituisce il codificatore.
	 * @return il codificatore.
	 **/
	public EncoderContract getEncoder() {
		return this.encoder;
	}
	
	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * Imposta il codificatore.
	 * @param encoder: il codificatore da impostare.
	 */
	public void setEncoder(EncoderContract encoder) {
		this.encoder = encoder;
	}

	/**
	 * Imposta il decodificatore.
	 * @param decoder: il decodificatore da impostare.
	 */
	public void setDecoder(DecoderContract decoder) {
		this.decoder = decoder;
	}

	public boolean getRepetitions() {
		return this.repetitions;
	}

	public boolean getUppercase() {
		return this.uppercase;
	}
}