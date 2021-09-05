package MVC_Model;

/**
 * <b>Responsabilità:</b> rappresenta un livello.
 * La creazione di una sua istanza deve essere susseguita da una chiamata di @setLevel per impostare 
 * tutti i valori a seconda dei metodi forniti.
 **/
public class Level{
	/**
	 * Il numero che identifica il livello.
	**/
	protected int num;
	
	/**
	 * La lunghezza del codice ammessa,
	**/
	protected int codeLength;
	
	/**
	 * Il numero di tentativi.
	**/
	protected int attempts;
	
	/**
	 * L'alfabeto ammesso
	**/
	protected Alphabet alphabet;
	
	/**
	 * Il flag per le ripetizioni.
	**/
	protected boolean repetitions;
	
	/**
	 * Il limite imposto.
	**/
	protected int limit = 5;
	
	/**
	 * Il flag per il maiuscolo.
	**/
	protected boolean uppercase;
	
	
	/**
	 * Crea un livello con i parametri scelti.
	 * @param num : il numero che identifica il livello;
	 * @param repetitions: il flag per le ripetizioni.
	 * @param uppercase: il flag per il maiuscolo.
	**/
	public Level(int num, boolean repetitions, boolean uppercase) {
		this.num = num < 1 ? 1:(num > limit? limit: num);
		this.repetitions = repetitions;
		this.uppercase = uppercase;
	}

	/**
	 * Crea un livello senza parametri. 
	 **/
	public Level() {
	}

	/**
	 * Imposta i valori di <code>codeLength, attempts e alphabet</code> in base a <code>num</code>.
	 * */
	public void setLevel() {
		this.codeLength = calculateCodeLength();
		this.attempts = calculateAttempts();
		this.alphabet = new Alphabet(calculateWords(), uppercase);
	}
	/**
	 * Fornisce una formula per calcolare il numero di caratteri appartenenti all'alfabeto.
	 **/
	protected int calculateWords() {
		return num*2+4;
	}
	
	/**
	 * Fornisce una formula per calcolare la lunghezza del codice.
	 **/
	protected int calculateCodeLength() {
		return num+3;
	}
	
	/**
	 * Fornisce una formula per calcolare il numero di tentativi.
	 **/
	protected int calculateAttempts() {
		return (2*num+3)*2;
	}
	
	/**
	 * Ritorna il numero identificativo per il livello.
	 * @return il numero identificativo per il livello.
	 **/
	public int getNum() {
		return num;
	}

	/**
	 * Ritorna la lunghezza del codice.
	 * @return la lunghezza del codice.
	 **/
	public int getCodeLength() {
		return codeLength;
	}

	/**
	 * Ritorna il numero di tentativi.
	 * @return il numero di tentativi.
	 */
	public int getAttempts() {
		return attempts;
	}
	
	/**
	 * Ritorna l'alfabeto.
	 * @return l'alfabeto.
	 */
	public Alphabet getAlphabet() {
		return alphabet;
	}

	/**
	 * Ritorna il flag per le ripetizioni.
	 * @return il flag per le ripetizioni.
	 **/
	public boolean getRepetitions() {
		return repetitions;
	}

	/**
	 * Ritorna il limite imposto.
	 * @return il limite imposto.
	 **/
	public int getLimit() {
		return limit;
	}

	/**
	 * Ritorna il flag per il maiuscolo.
	 * @return il flag per il maiuscolo.
	 **/
	public boolean getUppercase() {
		return uppercase;
	}	
}