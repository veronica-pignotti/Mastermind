package exceptions;

/**
 * <b>Responsabilità: </b> rappresenta la classe padre delle eccezioni presenti in questo gioco.
 **/
public abstract class MastermindExceptions extends Exception{

	private static final long serialVersionUID = 1L;
	private String message;
	public MastermindExceptions(String message) {
		this.message = message;
		}
	
	/**
	 * Stampa un messaggio. 
	 **/
	public void message() {
		System.out.println("ATTENZIONE! " + message );
	}
}
