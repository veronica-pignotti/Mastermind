package MVC_Model;

import java.util.HashSet;
import java.util.Set;

import Strategies.SetAndSwapStrategy;
import interfaces.CodeContract;
/**
 * <b>Responsabilità:</b> rappresenta il decodificatore che usa la strategia {@link SetAndSwapStrategy} per generare codice.
**/
public class SetAndSwapDecoder extends RandomDecoder implements SetAndSwapStrategy {
    protected Set<CodeContract> attempts;
	
	public SetAndSwapDecoder() {
		super();
		this.attempts = new HashSet<CodeContract>();
	}
	
	@Override
	public CodeContract createCode() {
		int position = manager.getCurrentTurn();
		CodeContract code;
		do {
			code = position == 0 ? super.createCode() : 
			(position == 1 ? setOrSwap(level.getAlphabet(), level.getRepetitions(), manager.getCode(position-1), manager.getClues(0)) :
				setOrSwap(level.getAlphabet(), level.getRepetitions(), manager.getCode(position-1),manager.getClues(position-1),manager.getCode(position-2),manager.getClues(position-2)));
		}while(attempts.contains(code));
		attempts.add(code);
		return code;
	}	

}