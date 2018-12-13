package Joran_Maxime_Joseph.Projet_Rogue;

import java.util.Scanner;

public class Saisie {
	private Terrain t;
	public Saisie(Terrain t) {
		this.t = t;
	}
	public void joueurJoue(String cmd) throws ExceptionDeplacementIllegal, ExceptionInvalidCommand, ExceptionAttaqueImpossible{
	     if (cmd.equals("go haut")) {
	     	t.deplacerPersonnage(Actions.HAUT);
	     }
	     else if (cmd.equals("go bas")) {
	     	t.deplacerPersonnage(Actions.BAS);
	     }
	     else if (cmd.equals("go gauche")) {
	     	t.deplacerPersonnage(Actions.GAUCHE);
	     }
	     else if (cmd.equals("go droite")) {
	     	t.deplacerPersonnage(Actions.DROITE);
	     }
	     else if (cmd.equals("atk gauche")) {
	    	 t.attaquerPersonnage(Actions.GAUCHE);
	     }
	     else if (cmd.equals("atk droite")) {
	    	 t.attaquerPersonnage(Actions.DROITE);
	     }
	     else if (cmd.equals("atk bas")) {
	    	 t.attaquerPersonnage(Actions.BAS);
	     }
	     else if (cmd.equals("atk haut")) {
	    	 t.attaquerPersonnage(Actions.HAUT);
	     }
	     else {
	     	throw new ExceptionInvalidCommand();
	     }
	}
	
	public void jouer() {
		Scanner sc= new Scanner(System.in);
		String cmd = "go !";
		boolean joueurAPuJouer;
		while(cmd != "game over") {
	    	//for(int i = 0; i < 100; i++) {System.out.println();}
	        t.Affiche();
			cmd = sc.nextLine();
			try {
				joueurJoue(cmd);
				joueurAPuJouer = true;
			}
			catch (Exception e1){
				System.out.println(e1.getMessage());
				joueurAPuJouer = false;
			}
			if (joueurAPuJouer) {
				try {
					t.deplacerEnnemis();
				}
				catch (ExceptionDeplacementIllegal e2) {
					
				}
			}
		}
		sc.close();
	}
}
