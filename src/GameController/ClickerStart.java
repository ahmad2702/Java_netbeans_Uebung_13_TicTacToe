/**
 * Akhmad Sadullaev 
 * s0556420 
 * Uebung 13
 */
package GameController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import GameKernel.GameAuswahl;
import GameKernel.Spielfeld;

public class ClickerStart implements ActionListener{
	
	//---Instanzvariablen
	GameAuswahl auswahlFenster;
	Spielfeld game;
	
	public ClickerStart(GameAuswahl auswahlFenster) {
		this.auswahlFenster = auswahlFenster;
	}
	
	
	/**
	 * Erzeugung des Spiels
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		auswahlFenster.setVisible(false);
		auswahlFenster = null;
		
		//Gameauswahl
		if(ae.getActionCommand() == "single"){
			Model.ModelKlasse.start(game, "single");
		}
		if(ae.getActionCommand() == "multi"){
			Model.ModelKlasse.start(game, "multi");
		}
		
	}
}
