package exceptions;

/**
 * <b>Responsabilità: </b> rappresenta l'eccezione che viene lanciata quando è presente un codice avente lunghezza errata.
 **/
public class IncorrectCodeLengthException extends MastermindExceptions {

	private static final long serialVersionUID = 1L;

	public IncorrectCodeLengthException(int incorrectLength, int correctLength) {
		super("Il codice inserito è composto da " + incorrectLength + " colori! Invece deve essere composto da " + correctLength+" colori.");
	}
}
