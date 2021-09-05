package MVC_Model;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import interfaces.BallContract;
import interfaces.CluesContract;
import interfaces.CodeContract;
import interfaces.EncoderContract;

/**
 * Responsabilità: rappresenta il codificatore virtuale.
 * E' in grado di:
 * - generare un codice segreto;
 * - generare gli indizi conoscendo il codice del decodificatore.
 */
public abstract class VirtualEncoder extends VirtualPlayer implements EncoderContract{
	/**
	 * Il codice segreto generato.
	 **/
	protected CodeContract secretCode;
	
	/**
	 * Crea un codificatore virtuale.
	 * */
	public VirtualEncoder() {
		super();
	}
	
	/**
	 * Crea gli indizi conoscendo il codice del decodificatore <code>decoderCode</code>.
	 * @param decoderCode: il codice del decodificatore su cui creare gli indizi.
	 * @return gli indizi relativi al <code>decoderCode</code>.
	 **/
	public CluesContract createClues(CodeContract decoderCode){
		return createClues(secretCode, decoderCode);
	}

	/**
	 * Crea gli indizi confrontando i due codici <code>secretCode</code> e <code>decoderCode</code>.
	 * @param secretCode: il codice segreto.
	 * @param decoderCode: il codice del decodificatore su cui creare gli indizi.
	 * @return gli indizi generati dai due codici.
	 **/
	@Override
	public CluesContract createClues(CodeContract secretCode, CodeContract decoderCode){
		Clues clues = new Clues();
		List<BallContract> see = new ArrayList<BallContract>();
		for (BallContract b : secretCode.getSequence()) {
			
			if(!see.contains(b) & decoderCode.getSequence().contains(b)) {
				
				TreeSet<Integer> Eset = extractIndexes(b, secretCode);
				TreeSet<Integer> Dset = extractIndexes(b, decoderCode);
				searchIndexes(Eset, Dset).forEach(c -> clues.addClue(c));
				see.add(b);
			}
		}
		return clues;
	}
	
	
	/**
	 * Ricava gli indici relativi alla pallina <code>ball</code> presenti nel codice <code>code</code>.
	 * @param ball: la pallina presa in considerazione.
	 * @param code: il codice da ispezionare.
	 * @return gli indici relativi a <code>ball</code>.
	 **/
	private TreeSet<Integer> extractIndexes(BallContract ball, CodeContract code){
		TreeSet<Integer> setIndex = new TreeSet<>();
		List<BallContract> sequence = code.getSequence();
		for(int i=0; i<sequence.size(); i++) if(sequence.get(i).equals(ball)) setIndex.add(i);
		return setIndex;
	}
	
	/**
	 * Determina gli indizi in base agli indici ricavati dalla stessa pallina su entrambe i set <code>Eset</code> 
	 * e <code>Dset</code>.
	 * @param Eset: l'insieme degli indici di una pallina ricavati dal codice del codificatore.
	 * @param Dset: l'insieme degli indici di una pallina ricavati dal codice del decodificatore.
	 * @return la lista di indizi relativi alla pallina presa in considerazione.
	 *  
	 **/
	private List<Clue> searchIndexes(Set<Integer> Eset, Set<Integer> Dset) {
		List<Clue> list = new ArrayList<Clue>();
		Set<Integer> firstSet = Eset.size() < Dset.size()? Eset:Dset;
		Set<Integer> secondSet = Eset.size() < Dset.size()? Dset:Eset;
		Iterator<Integer> itr = firstSet.iterator();
		while(itr.hasNext()) list.add(secondSet.contains(itr.next())? Clue.Black: Clue.White);
		return list;
	}
}