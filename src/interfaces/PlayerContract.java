package interfaces;

/**
 * <b>Responsabilit�: </b> Definisce le responsabilit� di qualsiasi giocatore.
 **/
public interface PlayerContract {
	
	/**
	 * Crea un codice.
	 * @return il codice creato.
	 **/
	CodeContract createCode();
}