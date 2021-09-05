package exceptions;

/**
 * <b>Responsabilità: </b> rappresenta l'eccezione lanciata quando si rivela una pallina ripetuta in un codice che non lo permetteva..
 **/
public class RepetitiveBallException extends MastermindExceptions {

	private static final long serialVersionUID = 1L;

	public RepetitiveBallException() {
		super("Il codice deve essere composto da palline diverse fra loro.");
	}
	
}
