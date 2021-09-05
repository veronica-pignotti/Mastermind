package interfaces;

import MVC_Model.Settings;

/**
 * <b>Responsabilità:</b> rappresenta il contratto che una vista deve rispettare.
**/
public interface DisplayContract {
	
	/**
	 * Stampa la schermata iniziale.
	 * */
	void firstDisplay();
	
	/**
	 * Stampa la parte visibile del tavolo, ovvero la parte in cui sono prensenti i codici immessi dal decodificatore e gli indizi corrispondenti.
	 * */
	void printVisibleTable();
	
	/**
	 *Stampa l'alfabeto della partita attuale. 
	 **/
	void printAlphabet();
	
	/**
	 * Stampa l'intero tavolo, codice segreto compreso. 
	 **/
	void printTable();
	
	/**
	 * Chiede all'utente se vuole effettuare una nuova partita.
	 * @return true se la risposta dell'utente è affermativa, false altrimenti.
	 **/
	boolean playAgain();

	/**
	 * Stampa il messaggio specificato <code>message</code>.
	 **/
	void printMessage(String message);
	
	/**
	 * Chiede all'utente le impostazioni di gioco.
	 * @return le impostazioni di gioco.
	 **/
	Settings askSettings();

	/**
	 * Chiede il codice all'utente e lo trasforma in un {@link CodeContract}.
	 * @return l'input dell'utente convertito in un {@link CodeContract}.
	 **/
	CodeContract askCode();
	
	/**
	 * Chiede gli indizi all'utente e li trasforma in un {@link CluesContract}.
	 * @return l'input dell'utente convertito in un {@link CluesContract}.
	 **/
	CluesContract askClues();
}