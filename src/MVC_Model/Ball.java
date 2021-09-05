package MVC_Model;
import java.util.Objects;

import interfaces.BallContract;

/**
 * <b>Responsabilità:</b> rappresenta il tipo di pallina presente nei codici.
 * Ogni pallina è caratterizzata da un carattere <code>symbol</code>.
 **/
public class Ball implements BallContract{
	/**
	 * il carattere che caratterizza la pallina.
	 **/
	protected Character symbol;
	
	/**
	 * Crea una pallina caratterizzata dal carattere <code>symbol</code>.
	 * @param symbol: il carattere della pallina che si sta creando.
	 **/
	public Ball(Character symbol) {
		this.symbol = Objects.requireNonNull(symbol);
	}

	@Override
	public boolean equals(Object obj) {
		return obj!=null | obj instanceof Ball? ((Ball)obj).getSymbol() == this.symbol : false;
	}
	
	@Override
	public Character getSymbol(){
		return this.symbol;
	}

	@Override
	public String toString() {return "("+symbol+")";}
}