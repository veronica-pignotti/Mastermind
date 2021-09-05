
package MVC_Model;

import java.util.Objects;

import interfaces.PlayerContract;

/**
 * <b>Responsabilità: </b> rappresenta un giocatore generico.
 * Un giocatore generico deve conoscere il {@link Level} attuale.
 **/
public abstract class AbstractPlayer implements PlayerContract {
	
	/**
	 * Il livello attuale
	 **/
	protected Level level;

	/**
	 * Crea un giocatore generico.
	 **/
	public AbstractPlayer() {
		this.level = null;
	}

	/**
	 * Imposta il livello dell'attuale partita.
	 * @param level: il livello da impostare.
	 **/
	public void setLevel(Level level) {
		this.level = Objects.requireNonNull(level);
	}
}