package interfaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Responsabilità: si occupa di prendere l'input dall'utente.
 */

public interface InputInterface {

	/**
	 * Prende l'input dall'utente.
	 * @return l'input in formato stringa dell'utente.
	 * @throws {@link IOException} se si verifica un errore di I/O.
	 **/
	public default String insertInput() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		return input.readLine();
	}
	
}
