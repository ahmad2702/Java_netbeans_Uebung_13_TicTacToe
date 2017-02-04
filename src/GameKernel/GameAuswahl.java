/**
 * Akhmad Sadullaev 
 * s0556420 
 * Uebung 13
 */
package GameKernel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;

import GameController.ClickerStart;

public class GameAuswahl extends JFrame{
	
	//---Instanzvariablen
	private JButton single, multi;
	
	/**
	 * Kostruktor der Klasse GameAuswahl
	 * @param s als String
	 */
	public GameAuswahl(String s){
		super(s);
		setLayout(new FlowLayout());	
		createGUI();
	}

	/**
	 * GUI Erzeugung
	 */
	public void createGUI(){
		single = new JButton("Singleplayer (gegen Computer)");
		multi = new JButton("Multiplayer (mit den Freunden)");
		
		single.setPreferredSize(new Dimension(500,250));
		single.setFont(new Font("Arial", Font.PLAIN, 30));
		single.setContentAreaFilled(false);
		single.setOpaque(false);
		single.addActionListener(new ClickerStart(this));
		single.setActionCommand("single");
		add(single);
		
		
		multi.setPreferredSize(new Dimension(500,250));
		multi.setFont(new Font("Arial", Font.PLAIN, 30));
		multi.setContentAreaFilled(false);
		multi.setOpaque(false);
		multi.addActionListener(new ClickerStart(this));
		multi.setActionCommand("multi");
		add(multi);
		
		
	}
}
