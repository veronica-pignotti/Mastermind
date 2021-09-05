package factoryMethodPattern;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import MVC_Model.SetAndSwapDecoder;
import MVC_Model.RandomDecoder;
import MVC_Model.RandomEncoder;
import interfaces.DecoderContract;
import interfaces.EncoderContract;
import interfaces.PlayerContract;


 /** 
  * <b>Responsabilità: </b> è un registratore di giocatori.
  **/
 
public class PlayersRegister {
	
	/**
	 * Lista di istanze dei codificatori
	 **/
	private List<EncoderContract> encoders;
	
	/**
	 * Lista di istanze dei decodificatori
	 **/
	private List<DecoderContract> decoders; 
	
	/**
	 * Crea un nuovo registro.
	 **/
	public PlayersRegister(){
		this.encoders = new ArrayList<>();
		this.decoders = new ArrayList<>();
		encoders.add(new RandomEncoder());
		decoders.add(new RandomDecoder());
		decoders.add(new SetAndSwapDecoder());
	}
	
	/** 
	 * Aggiunge un tipo di giocatore.
	 * @param instance: l'istanza del giocatore che si va ad inserire.
	 * @return false l'istanza è già presente nei registri encoders e decoders, true altrimenti.
	 **/ 
	public boolean add(PlayerContract instance) {
		Objects.requireNonNull(instance);
		String nameInstance = instance.getClass().getName();
		if(instance instanceof EncoderContract) {
			for(EncoderContract c: encoders) if (c.getClass().getName().equals(nameInstance)) return false;
			encoders.add((EncoderContract) instance);
		}else{
			for(DecoderContract c: decoders) if (c.getClass().getName().equals(nameInstance)) return false;
			decoders.add((DecoderContract) instance);	
		}
		return true;
	}
	
	/**
	 * Restituisce la lista di codificatori.
	 * @return la lista di codificatori.
	 **/
	public List<EncoderContract> getEncoders() {
		return encoders;
	}
	
	/**
	 * Restituisce la lista di decodificatori.
	 * @return la lista di decodificatori.
	 **/
	public List<DecoderContract> getDecoders() {
		return decoders;
	}	
}