package MVC_Model;

import java.util.Objects;
/**
 * <b>Responsabilità:</b> rappresenta il giocatore virtuale.
**/

public abstract class VirtualPlayer extends AbstractPlayer {

	/**
	 * Il gestore del tavolo.
	 * */
	protected TableManager manager;
	
	/**
	 * Crea un giocatore virtuale senza manager.
	 */
	public VirtualPlayer() {
		super();
	}
	
	/**
	 * Imposta il manager.
	 * @param manager: il manager da impostare.
	 * */
	public void setManager(TableManager manager) {this.manager = Objects.requireNonNull(manager);}

	/**
	 * Crea un codice e lo aggiunge al tavolo da gioco.
	 **/
	public void addCode() {
		manager.add(createCode());
		manager.getCode(-1);
	}
}