package interfaces;
/**
 * Responsabilità: definisce il contratto di un codificatore.
 */
public interface EncoderContract extends PlayerContract{

	/**
	 * Crea gli indizi in base ai codici <code>secretCode</code> e <code>decoderCode</code>. 
	 * @param secretCode: il codice segreto del codificatore.
	 * @param decoderCode: l'ultimo codice del decodificatore.
	 * @return gli indizi generati.
	 **/
	CluesContract createClues(CodeContract secretCode, CodeContract decoderCode);
}