package Strategies;
import java.util.Random;

import MVC_Model.Alphabet;
import MVC_Model.Ball;
import MVC_Model.Code;
import interfaces.CodeContract;

/**
 * <b>Responsabilità: </b> fornisce la capacità di creare un codice randomico.
 */

public interface RandomStrategy{
	/**
	 * Genera un codice randomico.
	 * @param codeLength: la lunghezza che il codice deve rispettare.
	 * @param alphabet: l'alfabeto su cui si basa il codice.
	 * @param repetitions: indica se sono ammesse ripetizioni.
	 * @return il codice generato in modo randomico.
	**/
	public default CodeContract randomCode(int codeLength, Alphabet alphabet, boolean repetitions) {
		Random rnd= new Random();
		char[] values = alphabet.toArray();
		CodeContract code = new Code();
		Ball ball;
		while(code.getSize()!=codeLength) {
			int x = rnd.nextInt(values.length);
			ball = new Ball(values[x]);
			if(!code.getSequence().contains(ball) || repetitions) code.add(ball);
		}
		return code;
	}
}