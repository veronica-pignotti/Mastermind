package MVC_Model;

import java.util.Objects;

import interfaces.CluesContract;
import interfaces.CodeContract;
import interfaces.TableContract;

/**
 * Responsabilità: rappresenta il tavolo da gioco. 
 **/
public class Table implements TableContract{
	
	/**
	 * L'array dei codici
	 **/
	protected CodeContract[] codes;
	
	/**
	 * L'array degli indizi
	 **/
	protected CluesContract[] clues;
	
	/**
	 * Il codice segreto
	 **/
	protected CodeContract secretCode;
	
	/**
	 * Costruisce un tavolo con <code>n</code> settori, corrispondenti ai tentativi a disposizione.
	 * @param n: il numero dei settori.
	 **/
	public Table(int n) {
		this.codes = (CodeContract[])new Code[n];
		this.clues = (CluesContract[]) new Clues[n];
	}
	
	/**
	 * Restituisce l'array dei tentativi.
	 * @return l'array dei tentativi.
	 **/
	public CodeContract[] getCodes() {
		return this.codes;
	}
	
	/**
	 * Restituisce l'array degli indizi.
	 * @return l'array degli indizi. 
	 **/
	public CluesContract[] getClues() {
		return this.clues;
	}
	
	/**
	 * Restituisce il codice segreto.
	 * @return il codice segreto.
	 **/
	public CodeContract getSecretCode() {
		return this.secretCode;
	}
	
	/**
	 * Imposta il codice segreto.
	 * @param code: il codice da impostare.
	 **/
	public void setSecretCode(CodeContract code) {
		this.secretCode = Objects.requireNonNull(code);
	}
	
	/**
	 * Imposta il codice <code>code</code> alla posizione <code>index</code>.
	 * @param la posizione dove inserire il codice <code>code</code>.
	 * @param code: il codice da impostare.
	 **/
	public void setCode(int index, CodeContract code) {
		if(index > -1) this.codes[index] = Objects.requireNonNull(code);
	}
	
	/**
	 * Imposta gli indizi <code>clues</code> alla posizione <code>index</code>.
	 * @param la posizione dove inserire gli indizi <code>clues</code>.
	 * @param clues: gli indizi da impostare.
	 **/
	public void setClues(int index, CluesContract clues) {
		if(index > -1) this.clues[index]=Objects.requireNonNull(clues);
	}	
}