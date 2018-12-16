package Joran_Maxime_Joseph.Projet_Rogue;

import java.util.ArrayList;
import java.util.Scanner;

public class Saisie {
	private Terrain t;
	public Saisie(Terrain t) {
		this.t = t;
	}
	public void joueurJoue(String cmd) throws ExceptionDeplacementIllegal, ExceptionInvalidCommand, ExceptionAttaqueImpossible, ExceptionMarcheSurObjet, ExceptionOuvrePorte{
	     if (cmd.equals("go haut")) {
	     	t.personnage.sedeplacer(Actions.HAUT,t);
	     }
	     else if (cmd.equals("go bas")) {
	     	t.personnage.sedeplacer(Actions.BAS,t);
	     }
	     else if (cmd.equals("go gauche")) {
	    	 t.personnage.sedeplacer(Actions.GAUCHE,t);
	     }
	     else if (cmd.equals("go droite")) {
	    	 t.personnage.sedeplacer(Actions.DROITE,t);
	     }
	     else if (cmd.equals("atk gauche")) {
	    	 t.personnage.attaquer(Actions.GAUCHE,t);
	     }
	     else if (cmd.equals("atk droite")) {
	    	 t.personnage.attaquer(Actions.DROITE,t);
	     }
	     else if (cmd.equals("atk bas")) {
	    	 t.personnage.attaquer(Actions.BAS,t);
	     }
	     else if (cmd.equals("atk haut")) {
	    	 t.personnage.attaquer(Actions.HAUT,t);
	     }
	     else if (cmd.equals("game over")) {
	    	 System.exit(0);
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
			catch (ExceptionMarcheSurObjet e1){
				t.personnage.ramasserEpee(t.epee);
				t.epee = new Epee();
				joueurAPuJouer = true;
			}
			catch (ExceptionOuvrePorte e2) {
				System.out.println(e2.getMessage());
				Gobelin g1 = new Gobelin("Gobelin Jamel", 2, 3, 1, 20, 5);
				Gobelin g2 = new Gobelin("Gobelin Abdel", 1, 4, 1, 20, 5);
				Gobelin g3 = new Gobelin("Gobelin Lakrim", 7, 2, 1, 20, 5);
				Gobelin g4 = new Gobelin("Gobelin Jamel", 5, 1, 1, 20, 5);
				Gobelin g5 = new Gobelin("Gobelin Abdel", 6, 9, 1, 20, 5);
				Gobelin g6 = new Gobelin("Gobelin Lakrim", 2, 2, 1, 20, 5);

				ArrayList<Creature> ennemis = new ArrayList<Creature>();
				ennemis.add(g1);
				ennemis.add(g2);
				ennemis.add(g3);
				ennemis.add(g4);
				ennemis.add(g5);
				ennemis.add(g6);
				Epee epee = new Epee("un sabre laser", "I", 20, 8, 8);
				Joueur pers = t.personnage;
				t = new Terrain(20, pers, ennemis, epee);

				joueurAPuJouer = true;
			}
			catch (Exception e3) {
				System.out.println(e3.getMessage());
				joueurAPuJouer = false;
			}
			if (joueurAPuJouer) {
				
					for(int i = 0;i<t.ennemis.size();i++)
					{
						try {
							t.ennemis.get(i).IA(t);
						}
						catch (Exception e4) {
						}
					}
				
			}
		}
		sc.close();
	}
}
