/**
 * 
 */
package MVC_Model;

import interfaces.DecoderContract;

/**
 * ResponsabilitÓ: rappresenta il decodificatore virtuale. 
 */
public abstract class VirtualDecoder extends VirtualPlayer implements DecoderContract {

	/**
	 * Crea un decodificatore virtuale.
	 **/
	public VirtualDecoder(){super();}

}
