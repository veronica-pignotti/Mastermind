package exceptions;
/**
 * <b>Responsabilità: </b> rappresenta l'eccezione lanciata quando si rivela un ibroglio.
 **/
public class CheatException extends MastermindExceptions {

	private static final long serialVersionUID = 1L;

	public CheatException() {
		super("Non imbrogliare! Inserisci gli indizi corretti.");
	}

}
