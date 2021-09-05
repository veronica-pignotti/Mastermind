package MVC_Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import interfaces.BallContract;
import interfaces.CodeContract;

/**
 * <b>Responsabilità:</b> rappresenta il codice.
**/
public class Code implements CodeContract {

	/**
	 * la sequenza di palline che compongono il codice
	 **/
	protected List<BallContract> sequence;
	
	/**
	 * Crea un codice con la sequenza vuota.
	 * */
	public Code() {
		this.sequence = new ArrayList<BallContract>();
	}	

	
	@Override
	public boolean equals(Object obj) {
		return (obj!=null && obj instanceof CodeContract)? this.sequence.equals(((CodeContract)obj).getSequence()) : false;
	}

	@Override
	public void add(BallContract ball) {this.sequence.add((BallContract) Objects.requireNonNull(ball));}
	
	public List<BallContract> getSequence() {return this.sequence;}

	@Override
	public String toString(){
		String str="";
		for(BallContract b:sequence) str+=b.toString() + " ";
		return str;
	}
	
	@Override
	public int getSize() {return this.sequence.size();}
	
	/**
	 * Determina se nel codice <code>code</code> ci sono delle ripetizioni di palline.
	 * @return true se sono presenti palline ripetute, false altrimenti.
	 **/
	public boolean controlRepetitiveBalls(){
		for(BallContract b: sequence) if(sequence.indexOf(b)!=sequence.lastIndexOf(b)) return true;
		return false;
	}
}