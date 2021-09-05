package interfaces;

import java.util.List;

import exceptions.IncorrectCodeLengthException;

/**
 * <b>Responsabilità:</b> rappresenta il contratto che deve essere rispettato dai codici del gioco.
**/
public interface CodeContract {
	
	/**
	 * Confronta questo oggetto con l'oggetto <code>obj</code>.
	 * @param obj: l'oggetto da confrontare.
	 * @return true: se <code>obj</code> è un'istanza di Code e ha la stessa sequenza (nello stesso ordine) di questo oggetto.
	 * @return false: se <code>obj</code> è null oppure non è un'istanza di Code oppure non ha la stessa sequenza di questo oggetto.
	 **/
	boolean equals(Object obj);
	
	/**
	 * Aggiunge la pallina specificata alla <code>sequence</code>.
	 * @param ball: la pallina da aggiungere.
	 **/
	void add(BallContract ball);
	
	/**
	 * Restituisce una rappresentazione in stringa del codice.
	 * @return la rappresentazione in stringa del codice.
	 **/
	String toString();

	/**
	 * Restituisce la lunghezza dl codice (numero di palline che compongono il codice).
	 * @return la lunghezza del codice
	 **/
	int getSize();
	
	/**
	 * Controlla la lunghezza del codice. 
	 * @param length: la lunghezza che <code>code</code> deve rispettare.
	 * @throws {@link IncorrectCodeLengthException} se <code>code</code> non rispetta la lunghezza specificata. 
	 * */
	public default void controlLength(int length) throws IncorrectCodeLengthException {
		if(this.getSize()!= length) throw new IncorrectCodeLengthException(this.getSize(), length);
	}	

	/**
	 * Ritorna la <code>sequence</code> di questo oggetto.
	 * @return la <code>sequence</code> di questo oggetto.
	 **/
	List<BallContract> getSequence();
}