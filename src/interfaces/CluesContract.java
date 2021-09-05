package interfaces;

import java.util.List;

import MVC_Model.Clue;

/**
 * <b>Responsabilità:</b> rappresenta il contratto che deve essere rispettato dagli indizi.
**/
public interface CluesContract {
	
	/**
	 * Aggiunge un indizio <code>clue</code> alla lista di indizi.
	 * @param clue: l'indizio da aggiungere.
	 **/
	void addClue(Clue clue);
	
	/**
	 * Confronta questo oggetto con l'oggetto <code>obj</code>.
	 * @param obj: l'oggetto da confrontare.
	 * @return true: se <code>obj</code> è un'istanza di {@link Clues} e entrambe hanno lo stesso numero di indizi (stesso numero di indizi Black e stesso numero di indizi White).
	 * @return false: se <code>obj</code> non è un'istanza di {@link Clues} o non ha lo stesso numero di indizi (stesso numero di indizi Black e stesso numero di indizi White).
	 **/
	boolean equals(Object obj);
	
	/**
	 * Fornisce una rappresentazione in stringa della lista <code>clues</code>.
	 * @return una rappresentazione in stringa della lista <code>clues</code>.
	 **/
	String toString();
	
	/**
	 * Determina se gli indizi passati <code>clues</code> sono composti da <code>length</code> indizi black.
	 * @param lengthCode: la lunghezza degli indizi.
	 * @return true: se gli indizi passati sono composti da <code>length</code> indizi black.
	 * @return false: se gli indizi passati non sono composti da <code>length</code> indizi black.
	 **/
	boolean onlyBlackClues(int lengthCode);
	
	/**
	 * Ritorna la lista di indizi <code>clues</code>.
	 * @return la lista di indizi <code>clues</code>.
	 **/
	List<Clue> getClues(); 
}
