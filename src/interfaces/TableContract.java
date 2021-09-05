package interfaces;

/**
 * Responsabilità: rappresenta il contratto che il tavolo da gioco deve rispettare.
 */
public interface TableContract {
	
	/**
	 * Imposta il codice segreto.
	 * @param code: il codice segreto.
	 */
	void setSecretCode(CodeContract code);
	
	/**
	 * Imposta il codice <code>code</code> alla posizione <code>index</code> del tavolo.
	 * @param code: il codice da impostare.
	 * @param index: la posizione del tavolo in cui andrà inserito <code>code</code>.
	 */
	void setCode(int index, CodeContract code);
	
	/**
	 * Imposta gli indizi <code>clues</code> alla posizione <code>index</code> del tavolo.
	 * @param clues: gli indizi da impostare.
	 * @param index: la posizione del tavolo in cui andrà inserito <code>clues</code>.
	 */
	void setClues(int index, CluesContract clues);
	
	/**
	 * Restituisce l'array dei codici.
	 * @return l'array dei codici.
	 */
	abstract CodeContract[] getCodes();
	
	/**
	 * Restituisce l'array degli indizi.
	 * @return l'array degli indizi.
	 */
	abstract CluesContract[] getClues();
	
	/**
	 * Restituisce il codice segreto.
	 * @return il codice segreto.
	 */
	CodeContract getSecretCode();
}
