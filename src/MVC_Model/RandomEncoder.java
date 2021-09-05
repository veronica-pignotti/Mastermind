package MVC_Model;

import Strategies.RandomStrategy;
import interfaces.CodeContract;
/**
 * <b>Responsabilità:</b> rappresenta il codificatore che usa la {@link RandomStrategy} per generare codice.
**/
public class RandomEncoder extends VirtualEncoder implements RandomStrategy {

	/**
	 * Crea un codificatore che usa la {@link RandomStrategy} per generare codice.
	 **/
	public RandomEncoder() {super();}

	@Override
	public CodeContract createCode() {
		secretCode = randomCode(level.getCodeLength(), level.getAlphabet(), level.getRepetitions());
		return secretCode;
	}
}
