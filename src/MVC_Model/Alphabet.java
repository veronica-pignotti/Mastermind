package MVC_Model;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import exceptions.IncorrectFormatException;
import interfaces.CodeContract;

/**
 * <b>Responsabilità: </b> rappresenta l'alfabeto ammesso nei codici.
 **/
public class Alphabet{
	/**
	 * La sequenza di caratteri ammessi
	 **/
	protected List<Character> sequence;

	public Alphabet() {
			this.sequence = new ArrayList<>();
	
	}
	
	/**
	 * Crea un alfabeto collezionando <code>nWords</code> caratteri scorrendo il codice ASCII. 
	 * <code>uppercase == true</code> : vengono collezionate le lettere in maiuscolo.
	 * <code>uppercase == false</code> : vengono collezionate le lettere in minuscolo.
	 * @param nWords: il numero di caratteri da collezionare.
	 **/
	public Alphabet(int nWords, boolean uppercase){
		if(nWords > 25 | nWords < 1) throw new IllegalArgumentException();
		this.sequence = new ArrayList<>();
		int from = uppercase? 65:97;
		for(int i = from; i < from+nWords; i++) sequence.add((char)i);
	}


	/** Ritorna la lista dei caratteri che compongono l'alfabeto.
	 * @return la lista dei caratteri che compongono l'alfabeto.
	 **/
	public List<Character> getSequence(){
		return this.sequence;
	}
	
	/** Ritorna l'array dei caratteri che compongono l'alfabeto.
	 * @return l'array dei caratteri che compongono l'alfabeto.
	 **/
	public char[] toArray() {
		char[] arr = new char[sequence.size()];
		sequence.forEach(c->arr[sequence.indexOf(c)]=c);
		return arr;
	}
	
	/**
	 * Determina se l'alfabeto contiene il carattere passato <code>symbol</code>.
	 * @param symbol: il carattere da controllare.
	 * @return true: se l'alfabeto contiene la stringa passata, false altrimenti.
	 **/
	public boolean contains(char symbol) {
		return sequence.contains(symbol);
	}
	
	/**
	 * Ritorna il numero dei caratteri che compongono l'alfabeto.
	 * @return il numero dei caratteri che compongono l'alfabeto.
	 **/
	public int getSize() {
		return sequence.size();
	}
	
	/**
	 * Fornisce una rappresentazione in stringa della sequenza dell'alfabeto.
	 * @return una rappresentazione in stringa della sequenza dell'alfabeto.
	 **/
	public String toString() {
		String str= "";
		for(Character c:sequence) str+= "(" + c.charValue() + ") ";
		return str;
	}
	
	/** 
	 * Converte la stringa nel codice corrispondente.
	 * @param input: la stringa da convertire.
	 * @return il codice corrispondente alla stringa.
	 * @throws {@link IncorrectFormatException} se la stringa non è formata da numeri interi.
	 **/
	public CodeContract convertInCode(String input) throws IncorrectFormatException{
		Objects.requireNonNull(input);
		Code code = new Code();
		String[] str= input.split(",");
		for(int i = 0; i<str.length; i++) {
			if(str[i].length()!=1) throw new IncorrectFormatException();
			code.add(converteInBall(str[i].charAt(0))); 
		};
		return code;
	}
	
	/** 
	 * Converte il carattere nella pallina corrispondente.
	 * @param c: il carattere da convertire.
	 * @return la pallina corrispondente al carattere
	 * @throws {@link IncorrectFormatException} se l'alfabeto non contiene c.
	 **/
	private Ball converteInBall(Character c) throws IncorrectFormatException{
		if(!sequence.contains(c)) throw new IncorrectFormatException();
		return new Ball(c);
	}
}