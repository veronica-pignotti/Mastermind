package exceptions;

/**
 * <b>Responsabilità: </b> rappresenta l'eccezione che viene lanciata quando l'utente inserisce l'input errato.
 **/
public class IncorrectAnswerException extends MastermindExceptions {

	private static final long serialVersionUID = 1L;

	public IncorrectAnswerException() {
		super("Input non valido! Inserisci S o N.");
	}
}