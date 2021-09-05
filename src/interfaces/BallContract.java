package interfaces;
/**
 * <b>Responsabilità:</b> rappresenta il contratto che deve essere rispettato da ogni pallina del gioco.
**/
public interface BallContract {
	
	/*
	 * Confronta una pallina con un oggetto <code>obj</code>. 
	 * @param obj: l'oggetto da confrontare
	 * @return true: se <code>obj</code> è un'istanza di {@link Ball} e entrambe sono caratterizzate  dallo stesso simbolo.
	 * @return false: se <code>obj</code> non è un'istanza di {@Ball} oppure se entrambe sono caratterizzate da simboli diversi.
	 **/
	boolean equals(Object obj);
	
	/**
	 * Ritorna il simbolo associato alla pallina.
	 * @return il simbolo associato alla pallina.
	 **/
	Character getSymbol();
	
	/**
	 * Ritorna una rappresentazione in stringa della pallina.
	 * @return una rappresentazione in stringa della pallina.
	 **/
	String toString();
}
