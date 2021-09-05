package MVC_Controller;

import java.util.Objects;

import MVC_Model.Settings;
import MVC_View.Display;
import interfaces.DisplayContract;

/**
 * Responsabilità: si occupa di far partire il gioco.
 */
public class Game{
	
	/**
	 * La vista del gioco.
	 **/
	private static DisplayContract display;
	
	public static void main(String[] args) {
		setDisplay();
		do{
			try {
				new Game(display.askSettings());
			}catch(NumberFormatException e) {}
		}while(display.playAgain()); 
	}
	
	/**
	 * Crea una vista per la comunicazione iniziale con l'utente. 
	 **/
	public static void setDisplay() {
		display = new Display();		
	}

	/**
	 * Crea un nuovo gioco con i <code>settings</code> passati.
	 * @param settings: le impostazioni di gioco scelte.
	 * */
	public Game(Settings settings){
		Objects.requireNonNull(settings);
		new Coordinator(settings).start();
	}
	
	
}