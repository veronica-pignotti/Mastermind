package exceptions;

/**
 * <b>Responsabilità: </b> rappresenta un'eccezione che viene lanciata quando si riscontra un carattere non appartenente all'alfabeto.
 **/
public class IncorrectFormatException extends MastermindExceptions {

	private static final long serialVersionUID = 1L;

	public IncorrectFormatException() {
		super("Il carattere inserito non fa parte dell'alfabeto");
	}
}
