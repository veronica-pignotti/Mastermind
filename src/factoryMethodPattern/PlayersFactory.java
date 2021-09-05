package factoryMethodPattern;

import java.util.List;
import java.util.Objects;
import java.util.Random;

import interfaces.DecoderContract;
import interfaces.EncoderContract;

/**
 * <b>Responsabilità: </b> rappresenta un generatore di giocatori.
 **/
public class PlayersFactory{
	/** 
	 * Il registratore dei giocatori
	 **/
	private PlayersRegister register;
	
	/**
	 * Crea un generatore di giocatori
	 **/
	public PlayersFactory() {
		this.register = new PlayersRegister();
	}
	
	/**
	 * Restituisce il codificatore che ha la classe corrispondente alla stringa passata. Se non presente, viene restituito un {@link EncoderContract} casuale.
	 * @param type: la stringa associata al codificatore che si vuole restituire.
	 * @return il codificatore associato alla stringa <code>type</code> oppure un codificatore casuale.
	 * */
	public EncoderContract getEncoder(String type) {
		Objects.requireNonNull(type);
		List<EncoderContract> reg = register.getEncoders();
		for(EncoderContract enc: reg) {
			if (enc.getClass().getName().endsWith("." + type)) return enc;
		}
		return reg.get(new Random().nextInt(reg.size())) ;
	}

	/**
	 * Restituisce un decodificatore che ha la classe corrispondente alla stringa passata. Se non presente, viene restituito un {@link DecoderContract} casuale.
	 * @param type: la stringa associata al decodificatore che si vuole restituire.
	 * @return il decodificatore associato alla stringa <code>type</code> oppure un decodificatore casuale.
	 **/
	public DecoderContract getDecoder(String type) {
		Objects.requireNonNull(type);
		List<DecoderContract> reg = register.getDecoders();
		for(DecoderContract dec: register.getDecoders()) {
			if (dec.getClass().getName().endsWith("." + type)) return dec;
		}
		return reg.get(new Random().nextInt(reg.size())) ;
	}
}