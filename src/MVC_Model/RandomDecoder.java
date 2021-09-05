package MVC_Model;

import Strategies.RandomStrategy;
import interfaces.CodeContract;

/**
 * <b>Responsabilità :</b> Rappresenta un decodificatore che usa la {@link RandomStrategy} per generare codice.
 **/
public class RandomDecoder extends VirtualDecoder implements RandomStrategy {
	
	/**
	 * Crea un decodificatore che usa la strategia randomica.
	 * */
	public RandomDecoder() {super();}
	
	@Override
	public CodeContract createCode() {
		return randomCode(level.getCodeLength(), level.getAlphabet(),level.getRepetitions());
	}
}