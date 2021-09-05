package MVC_Model;

import java.util.Objects;

import exceptions.IncorrectFormatException;

/**
 * <b>Responsabilità:</b> Definisce i tipi degli indizi.
 * L'indizio White indica una pallina presente nel codice in posizione sbagliata.
 * L'indizio Black indica una pallina presente nel codice in posizione esatta.
 **/
public enum Clue{
	White,
	Black; 
	
	/**
	 * Verifica la correttezza del formato dell'indizio <code>clue</code>.
	 * @param code: il codice da controllare.
	 * @throws {@link IncorrectFormatException} se <code>clue</code> non rispetta il formato richiesto per 
	 * gli indizi.
	 **/
	public static Clue converteInClue(Character clue) throws IncorrectFormatException {
		Objects.requireNonNull(clue);
		switch(Character.toUpperCase(clue)){
			case 'B': return Clue.Black;
			case 'W': return Clue.White;
		}
		throw new IncorrectFormatException();
	}
}