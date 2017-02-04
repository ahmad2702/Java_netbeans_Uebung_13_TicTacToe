/**
 * Akhmad Sadullaev 
 * s0556420 
 * Uebung 13
 */
package GameController;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import GameKernel.Spielfeld;
import Model.ModelKlasse;

public class ClickerController implements ActionListener {
	
	//---Instanzvariablen
	private Spielfeld spielfeld;
	private JButton clicker;
	private static int symbol = 1; //1 fuer x, 0 fuer o
	private boolean gedrueckt = false;
	private static boolean spielEnde = false;

	/**
	 * Konstruktor der Klasse ClickerController
	 * @param clicker als JButton object
	 */
	public ClickerController(JButton clicker) {
		this.clicker = clicker;
	}

	/**
	 * Konstruktor der Klasse ClickerController
	 * @param clicker als Spielfeld object
	 */
	public ClickerController(Spielfeld spielfeld) {
		this.spielfeld = spielfeld;
	}
	
	/**
	 * Kontrolle der JButton
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(symbol==1 && this.gedrueckt==false && spielEnde==false && ae.getActionCommand() != "reset"){
			clicker.setText("x");
			clicker.setForeground(Color.BLUE);
			symbol=0;
			this.gedrueckt=true;
			//Preufung, ob man gewinnt hat
			spielEnde=ModelKlasse.checkWin(1, clicker.getActionCommand());
			
		}else if(symbol==0 && this.gedrueckt==false && spielEnde==false && ae.getActionCommand() != "reset"){
			clicker.setText("o");
			symbol=1;
			this.gedrueckt=true;
			//Preufung, ob man gewinnt hat
			spielEnde=ModelKlasse.checkWin(0, clicker.getActionCommand());
		}
		//Restart
		if(ae.getActionCommand() == "reset"){
			symbol = 1;
			ModelKlasse.reset(spielfeld, "multi");
			spielEnde=false;
		}
		
	}
	
}
