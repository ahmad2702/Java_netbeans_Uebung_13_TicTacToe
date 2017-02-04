/**
 * Akhmad Sadullaev 
 * s0556420 
 * Uebung 13
 */
package GameKernel;

import javax.swing.*;
import GameController.*;
import java.awt.*;

public class Spielfeld extends JFrame {
	//--- Variablen
	public static JButton b[][];
	private JButton reset;
	// Alle Click's
	public static ClickerControllerMulti click[][];
	
	/**
	 * Konstruktor der Klasse Spielfeld
	 * @param s als String mit der Name fuer Game
	 * @param game Gameauswahl: singleplayer oder multiplayer
	 */
	public Spielfeld(String s, String game){
		super(s);
		setLayout(new FlowLayout());	
		createGUI(game);
	}
	
	/**
	 * GUI Erzeugung
	 * @param game mit Typ des Spiel
	 */
	public void createGUI(String game){
		b = new JButton[5][5];
		click = new ClickerControllerMulti[5][5];
		
		//Button-Erzeugung
		for(int i=0; i < b.length; i++){
			for(int j = 0; j < b.length; j++){
				b[i][j] = new JButton("");
				b[i][j].setPreferredSize(new Dimension(100,100));
				b[i][j].setFont(new Font("Arial", Font.PLAIN, 55));
				b[i][j].setContentAreaFilled(false);
				//b[i][j].setBorderPainted(false);
				b[i][j].setOpaque(false);
				add(b[i][j]);
				
				//Index von Button
				b[i][j].setActionCommand(""+i+j);
				
				//Kontrollerauswahl
				if(("multi").equals(game))
					b[i][j].addActionListener(new ClickerController(b[i][j]));
				else
					click[i][j] = new ClickerControllerMulti(b[i][j]);
					b[i][j].addActionListener(click[i][j]);
			}
		}
		
		reset = new JButton("reset");
		reset.setPreferredSize(new Dimension(500,20));
		
		//Kontrollerauswahl
		if(("multi").equals(game))
			reset.addActionListener(new ClickerController(this));
		else
			reset.addActionListener(new ClickerControllerMulti(this));
		
		reset.setActionCommand("reset");
		add(reset);

	}
	
}
