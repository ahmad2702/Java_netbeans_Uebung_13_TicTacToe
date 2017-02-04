/**
 * Akhmad Sadullaev 
 * s0556420 
 * Uebung 13
 */
package Model;

import javax.swing.JFrame;

import GameKernel.GameAuswahl;
import GameKernel.Spielfeld;

public class ModelKlasse {
	
	//---Instanzvariablen
	private static int[][] ggg = new int [5][5]; //Da sind alle Gaenge, die gemacht wurden
												// 1 fuer x, 0 fuer o, und 9 fuer Button ohne Zeichen
	/**
	 * Start eines Spieles
	 * @param play als Spielfeld object
	 * @param game mit der Typ des Spieles
	 */
	public static void start(Spielfeld play, String game){
		play = new Spielfeld("Tic Tac Toe", game);

		play.setVisible(true);
		play.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		play.setSize(600, 600);
		play.setResizable(false); //Static size von Fenster
		play.setLocationRelativeTo(null);

		for(int i = 0; i < ggg.length; i++){
			for(int j = 0; j < ggg.length; j++){
				ggg[i][j]=9;
			}
		}
	}
	
	/**
	 * Ende eines Spieles
	 * @param play
	 */
	public static void stop(Spielfeld play){
		play.setVisible(false);
		play = null;
	}
	
	/**
	 * Restart eines Spieles
	 * @param play als Spielfeld object
	 * @param game mit der Typ des Spieles
	 */
	public static void reset(Spielfeld play, String game){
		stop(play);
		start(play, game);
	}
	
	/**
	 * Erzeugung eines Fenster fuer Gameauswahl
	 * @param play als Spielfeld object
	 */
	public static void auswahl(GameAuswahl play){
		play = new GameAuswahl("Tic Tac Toe");

		play.setVisible(true);
		play.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		play.setSize(600, 600);
		play.setResizable(false);
		play.setLocationRelativeTo(null);
	}
	
	/**
	 * Preufung, ob der Mensch mit seinem naechsten Gang gewinnen kann
	 * @return als String: 99 falls der Mensch nicht gewinnt, ansonsten Koordinaten (Index) 
	 */
	public static String passt(){
		String index = "";
		int anzahl;
		boolean geloest = false;
		
		//Anzahl der Zeichen X - 'horizontal'
		for(int i = 0; i < ggg.length; i++){
			anzahl=0;
			geloest=false;
			for(int j = 0; j < ggg.length; j++){
				if(ggg[i][j]==1)
					anzahl++;
				if(ggg[i][j]==0)
					geloest=true;
			}
			if(anzahl==4 && geloest!=true)
				return index + i + 9;
		}
		
		//Anzahl der Zeichen X - 'vertikal'
		for(int i = 0; i < ggg.length; i++){
			anzahl=0;
			geloest=false;
			for(int j = 0; j < ggg.length; j++){
				if(ggg[j][i]==1){
					anzahl++;
				}
						
				if(ggg[j][i]==0)
					geloest=true;
						
				if(anzahl==4 && geloest!=true && j==4)
					return index + 9 + i;
			}		
		}
		
		//Anzahl der Zeichen X - 'diagonal (links-oben nach rechts-unten)'
		anzahl=0;
		for(int i = 0; i < ggg.length; i++){
			geloest=false;
			if(ggg[i][i]==1){
				anzahl++;
			}
			if(ggg[i][i]==0)
				geloest=true;
			if(anzahl==4 && geloest!=true){
				for(int j = 0; j < ggg.length;j++){
					if(ggg[j][j]==9){
						Spielfeld.b[j][j].setText("o");
						Spielfeld.b[j][j].removeActionListener(Spielfeld.click[j][j]);
						String element = "" + j + j + 5;
						return element;
					}
				}
			}			
		}
		
		//Anzahl der Zeichen X - 'diagonal (rechts-oben nach links-unten)'
		anzahl=0;
		int in = 4;
		for(int i = 0; i < ggg.length; i++){
			geloest=false;
			if(ggg[i][in]==1){
				anzahl++;
			}
			if(ggg[i][in]==0)
				geloest=true;
			
			if(anzahl==4 && geloest!=true){
				in = 4;
				for(int j = 0; j < ggg.length; j++){
					if(ggg[j][in]==9){
						Spielfeld.b[j][in].setText("o");
						Spielfeld.b[j][in].removeActionListener(Spielfeld.click[j][in]);
						String element = "" + j + in + 5;
						return element;
					}
					in--;
				}
			}
			
			in--;
		}
		

		//Falls der Mensch nicht gewinnt
		return index + 99;
	}
	
	/**
	 * Gang aus der Seiter des Computer
	 * @param spielfeld als Spielfeld object
	 * @return true falls man gewonnen hat
	 */
	public static boolean machtComputer(Spielfeld spielfeld){
		//Preufung, ob der Mensch mit seinem naechsten Gang gewinnen kann
		String koordinaten = passt();
		
		char[] charArray = koordinaten.toCharArray();
		int zeile = Character.getNumericValue(charArray[0]);
		int spalte = Character.getNumericValue(charArray[1]);
		int diagonal = 11;
		if(charArray.length>2)
			diagonal = Character.getNumericValue(charArray[2]);

		
		// Gang: damit der Mensch nicht gewinnt - 'horizontal'
		if(zeile != 9 && diagonal!=5){
			for(int i = zeile; i <= zeile; i++){
				for(int j = 0; j < ggg.length; j++){
					if(ggg[zeile][j]==9){
						Spielfeld.b[zeile][j].setText("o");
						Spielfeld.b[zeile][j].removeActionListener(Spielfeld.click[zeile][j]);
						String element = "" + zeile + j;
						return checkWin(0, element);
					}
				}
			}
		}
		
		// Gang: damit der Mensch nicht gewinnt - 'vertikal'
		if(spalte<=4 && diagonal!=5){
			for(int i = spalte; i <= spalte; i++){
				for(int j = 0; j < ggg.length; j++){
					if(ggg[j][spalte]==9){
						Spielfeld.b[j][spalte].setText("o");
						Spielfeld.b[j][spalte].removeActionListener(Spielfeld.click[j][spalte]);
						String element = "" + j + spalte;
						return checkWin(0, element);
					}
				}
			}
		}

		// Gang: damit der Mensch nicht gewinnt - 'diagonal'
		if(zeile<=4 && spalte<=4 && diagonal==5){
			return checkWin(0, koordinaten);
		}
		
		
		//Wenn der Mensch nicht gewinnt, macht der Computer einen Gang wo es kein Zeichen gibt
		boolean gefunden=false;
		//Suchen nach leeren Button
		for(int i = 4; i >= 0; i--){
			for(int j = 4; j >= 0; j--){
				if(ggg[i][j]==9){
					gefunden=true;
					zeile=i;
					spalte=j;
					i=j=-1;
				}
			}
		}
		//ein Zeichen reinschreiben
		if(gefunden==true){
			Spielfeld.b[zeile][spalte].setText("o");
			Spielfeld.b[zeile][spalte].removeActionListener(Spielfeld.click[zeile][spalte]);
			String element = "" + zeile + spalte;
			return checkWin(0, element);	
		}else{
			return true;
		}
		
	}
	
	
	
	/**
	 * Pruefung, ob man gewonnen hat
	 * @param zeichen 1 fuer x, 0 fuer o
	 * @param index Koordinate des JButton
	 * @return true wenn man gewonnen hat
	 */
	public static boolean checkWin(int zeichen, String index){
		char[] charArray = index.toCharArray();
		
		int zeile = Character.getNumericValue(charArray[0]);
		int spalte = Character.getNumericValue(charArray[1]);
		
		//Speicherung des Ganges in GangArray
		ggg[zeile][spalte]=zeichen;
		
		boolean gefunden;	
		//Check: horizontal
		for(int i = 0; i < ggg.length; i++){
			gefunden = true;
			for(int j = 0; j < ggg.length; j++){
				if(ggg[i][j]!=zeichen){
					gefunden=false;
				}
			}
			if(gefunden==true){
				return true;
			}
		}
		
		//Check: vertikal
		for(int i = 0; i < ggg.length; i++){
			gefunden = true;
			for(int j = 0; j < ggg.length; j++){
				if(ggg[j][i]!=zeichen){
					gefunden=false;
				}
			}
			if(gefunden==true){
				return true;
			}
		}
		
		//Check: diagonal (links-oben nach rechts-unten)
		gefunden = true;
		for(int i = 0; i < ggg.length; i++){
			if(ggg[i][i]!=zeichen){
				gefunden=false;
			}
		}
		if(gefunden==true){
			return true;
		}
		
		
		//Check: diagonal (rechts-oben nach links-unten)
		gefunden = true; int in = 4;
		for(int i = 0; i < ggg.length; i++){
			if(ggg[i][in]!=zeichen){
				gefunden=false;
			}
			in--;
		}
		//falls man gewonnen hat
		if(gefunden==true){
			return true;
		}
		
		//falls man 'nicht' gewonnen hat
		return false;
	}
	


}
