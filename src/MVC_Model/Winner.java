package MVC_Model;
/**
 * 
 */

import interfaces.DecoderContract;
import interfaces.EncoderContract;
/**
 * <b>Responsabilità:</b> rappresenta il vincitore attuale.
**/
public class Winner {
	/**
	 * Stringa che rappresenta il vincitore. 
	 **/
	String winner;
	
	/**
	 * Crea un vincitore di tipo codificatore.
	 * @param winner il codificatore vincitore. 
	 **/
	public Winner(EncoderContract winner) {
		this.winner = "encoder";
	}
	
	/**
	 * Crea un vincitore di tipo decodificatore.
	 * @param winner il decodificatore vincitore. 
	 **/
	public Winner(DecoderContract winner) {
		this.winner = "decoder";
	}
	
	/**
	 *Ritorna il messaggio di vincita/perdita da parte del decodificatore.
	 *@return il messaggio di vincita/perdita da parte del decodificatore. 
	 **/
	public String winnerIs() {
		return winner== "encoder"? "Tentativi esauriti! \n Mi dispiace, decodificatore, hai perso!": "Bravo decodificatore! Hai indovinato il codice segreto!";
	}
	
	/**
	 * Ritorna la stringa che rappresenta il vincitore.
	 * @return la stringa che rappresenta il vincitore. 
	 **/
	public String getWinner() {return this.winner;}
}
