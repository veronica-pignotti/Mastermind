package interfaces;

/**
 * <b>Responsabilità: </b> Definisce le responsabilità di qualsiasi giocatore.
 **/
public interface PlayerContract {
	
	/**
	 * Crea un codice.
	 * @return il codice creato.
	 **/
	CodeContract createCode();
}