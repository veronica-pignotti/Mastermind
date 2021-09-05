package MVC_Model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import exceptions.IncorrectFormatException;
import interfaces.CluesContract;

/**
 * <b>Responsabilità:</b> Definisce gli indizi.
 */

public class Clues implements CluesContract{
	/**
	 * La lista degli indizi.
	 **/
	protected List<Clue> clues;
	
	/**
	 * Il comparatore che permette il sorting della lista, in modo lessicografico.
	 **/
	private Comparator<Clue> comparator = (c1,c2)-> c1.name().compareTo(c2.name());
	
	/**
	 * Crea la lista di indizi vuota
	 **/
	public Clues() {
		this.clues = new ArrayList<Clue>();
	}
	
	/**
	 * Crea la lista degli indizi, specificando la sequenza di {@link Clue} che deve contenere.
	 * @param clues: la sequenza di {@link Clue} che deve contenere.
	 **/
	public Clues(Clue ...clues) {
		this();
		Objects.requireNonNull(clues);
		this.clues = Arrays.asList(clues);
		this.clues.sort(comparator);
	}
	
	
	@Override
	public void addClue(Clue clue){
		Objects.requireNonNull(clue);
		this.clues.add(clue);
		this.clues.sort(comparator);
	}
	
	
	public List<Clue> getClues(){return clues;}
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof Clues)) return false;
		List<Clue> objClues=((Clues)obj).getClues();
		return (
				objClues.size() == this.clues.size() && 
				objClues.get(0).equals(this.clues.get(0)) &&
				objClues.lastIndexOf(objClues.get(0)) == this.clues.lastIndexOf(this.clues.get(0))? true:false
				);
	}
	
	@Override
	public String toString() {
		return clues.toString();
	}
	
	public boolean onlyBlackClues(int lengthCode) {
		return this.clues.lastIndexOf(Clue.Black) == lengthCode-1? true: false;
	}
	
	/**
	 * Converte la striga <code>clueString</code> del codice corrispondente. 
	 * La conversione necessita della correttezza del formato: la stringa <code>clueString</code> deve 
	 * contenere solo caratteri B/b e W/w separati da virgola.
	 * @param clueString: la stringa formata dai caratteri B e W.
	 * @throws {@link IncorrectFormatException} se la stringa non rispetta il formato.
	 **/
	public Clues converteInClues(String cluesString) throws IncorrectFormatException{
		Objects.requireNonNull(cluesString);
		Clues clues = new Clues();
		for (int i = 0; i < cluesString.length(); i++) clues.addClue(Clue.converteInClue(Character.toUpperCase(cluesString.charAt(i))));
		return clues;
	}
}