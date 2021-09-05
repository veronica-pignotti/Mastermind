package exceptions;

/**
 * <b>Responsabilità: </b> rappresenta l'eccezione lanciata quando sono terminati i tentataivi.
 **/
public class AttemptsTerminatedException extends MastermindExceptions {

	private static final long serialVersionUID = 1L;

	public AttemptsTerminatedException() {
		super("Tentativi terminati!");
	}
}