package Strategies;

import java.util.List;
import java.util.Random;

import MVC_Model.Alphabet;
import MVC_Model.Ball;
import MVC_Model.Clue;
import MVC_Model.Code;
import interfaces.BallContract;
import interfaces.CluesContract;
import interfaces.CodeContract;

/**
 * <b>Responsabilità: </b> fornisce la strategia che usa scambi e sostituzioni per creare un codice, a seconda dei casi.
 */
public interface SetAndSwapStrategy {

	/**
	 * Crea un clone di <code>code</code>.
	 * @param code: il codice da clonare. 
	 **/
	public default CodeContract clone(CodeContract code) {
		CodeContract clone = new Code();
		for(BallContract b : code.getSequence()) clone.add(b);
		return clone;
	}
	
	/**
	 * Scambia le palline del <code>code</code> in posizione <code>ball1</code> e <code>ball2</code>.
	 * @param code: il codice da modificare.
	 * @param ball1, ball2 : gli indici delle palline da scambiare.
	 * @return il nuovo codice.
	 **/
	public default CodeContract swap(CodeContract code, int ball1, int ball2) {
		CodeContract c = clone(code);
		List<BallContract> sequence = c.getSequence();
		if(ball1!=ball2) {
			BallContract b = sequence.get(ball1);
			sequence.set(ball1, sequence.get(ball2));
			sequence.set(ball2, b);
		}
		return c;
	}
	
	/**
	 * Sostituisce la pallina del <code>code</code> nella posizione <code>where</code> con la pallina <code>what</code>.
	 * param code: il codice da modificare.
	 * @param where: l'indice della destinazione della pallina <code>what</code>.
	 * @param what: la pallina che andrà in posizione.
	 * @return il codice modificato.
	 **/
	public default CodeContract set(CodeContract code,int where, BallContract what) {
		CodeContract c = clone(code);
		List<BallContract> sequence = c.getSequence();
		sequence.set(where, what);
		return c;
	}
	
/**
 * Ritorna un codice costruito effettuando o una sostituzione o uno scambio.
 * @param alphabet: l'alfabeto considerato.
 * @param repetitions: il flag per le ripetizioni.
 * @param lastCode: il codice in posizione i-1.
 * @param lastClues: gli indizi in posizione i-1.
 * @return un codice costruito effettuando o una sostituzione o uno scambio.
 **/
	public default CodeContract setOrSwap(Alphabet alphabet, boolean repetitions, CodeContract lastCode, CluesContract lastClues) {		
		Random rnd = new Random();
		BallContract ball = findBall(alphabet, repetitions, lastCode); 
		return rnd.nextInt(2) == 1 ?
			   set(lastCode, rnd.nextInt(lastCode.getSize()),ball)
			   : swap(lastCode, rnd.nextInt(lastCode.getSize()), rnd.nextInt(lastCode.getSize()));	
	}
	
	/**
	 * Cerca in <code>alphabet</code> una pallina che non è presente in <code>code</code>.
	 * @param alphabet l'alfabeto considerato.
	 * @param repetitions: il flag per le ripetizioni.
	 * @param code: il codice considerato.
	 * @return la pallina che non è presente in <code>code</code>.
	 **/
	public default BallContract findBall(Alphabet alphabet, boolean repetitions, CodeContract code) {
		Random rnd = new Random();
		while(true) {
			BallContract ball = new Ball(alphabet.getSequence().get(rnd.nextInt(alphabet.getSize())));
			if(!code.getSequence().contains(ball) || repetitions) return ball;
		}
	}
	
	/**
	 * Restituisce un <code>code</code> per la nuova posizione i controllando codici e indizi delle posizioni i-1 e i-2.
	 * @param alphabet: l'alfabeto considerato.
	 * @param repetitions: il flag per le ripetizioni.
	 * @param code1: il codice in posizione i-1.
	 * @param clues1: gli indizi in posizione i-1.
	 * @param code2: il codice in posizione i-2.
	 * @param clues2: gli indizi in posizione i-2.
	 * @return il codice da inserire nella posizione i. 
	 **/
	public default CodeContract setOrSwap(Alphabet alphabet, boolean repetitions, CodeContract code1, CluesContract clues1, CodeContract code2, CluesContract clues2) {		
		Random rnd = new Random();
		int index1 = 0;
		int index2 = 0;
		while(index1==index2){
			index1 = rnd.nextInt(code1.getSize());
			index2 = rnd.nextInt(code1.getSize());
		}
		return clues1.getClues().size() == code1.getSize() ? swap(code1, index1, index2) : 
			(clues1.getClues().lastIndexOf(Clue.Black) > clues2.getClues().lastIndexOf(Clue.Black)? set(code1, index1, findBall(alphabet, repetitions, code1)):
				(clues1.getClues().lastIndexOf(Clue.Black) == clues2.getClues().lastIndexOf(Clue.Black)? 
					(clues1.getClues().lastIndexOf(Clue.White) > clues2.getClues().lastIndexOf(Clue.White)? set(code1, index1, findBall(alphabet, repetitions, code1)):
						set(code2, index1, findBall(alphabet, repetitions, code2))
					):set(code2, index1, findBall(alphabet, repetitions, code2))
				)
			);
	}		
}