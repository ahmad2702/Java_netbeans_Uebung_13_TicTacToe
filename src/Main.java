/**
 * Akhmad Sadullaev 
 * s0556420 
 * Uebung 13
 */
import GameKernel.GameAuswahl;
import Model.ModelKlasse;

public class Main {

	public static void main(String[] args) {
		
		GameAuswahl play = new GameAuswahl("Tic Tac Toe");
		ModelKlasse.auswahl(play);
		
	}

}
