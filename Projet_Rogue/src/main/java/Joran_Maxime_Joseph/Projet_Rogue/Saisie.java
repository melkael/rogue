package Joran_Maxime_Joseph.Projet_Rogue;

import java.util.ArrayList;
import java.util.Scanner;

import Joran_Maxime_Joseph.Projet_Rogue.Creature.Creature;
import Joran_Maxime_Joseph.Projet_Rogue.Creature.Gobelin;
import Joran_Maxime_Joseph.Projet_Rogue.Creature.Joueur;
import Joran_Maxime_Joseph.Projet_Rogue.Exception.ExceptionAttaqueImpossible;
import Joran_Maxime_Joseph.Projet_Rogue.Exception.ExceptionDeplacementIllegal;
import Joran_Maxime_Joseph.Projet_Rogue.Exception.ExceptionInvalidCommand;
import Joran_Maxime_Joseph.Projet_Rogue.Exception.ExceptionMarcheSurObjet;
import Joran_Maxime_Joseph.Projet_Rogue.Exception.ExceptionOuvrePorte;
import Joran_Maxime_Joseph.Projet_Rogue.Objet.Epee;

import java.util.Random;

public class Saisie {
	private Terrain t;
	private Joueur j;
	private int niveau;
	
	public Saisie(Joueur j) 
	{
		this.niveau = 0;
		this.j = j;
		this.t = new Terrain(j);
		this.t = t.InitAvecEnnemisEtObjets(niveau);
	}
	public void joueurJoue(String cmd) throws ExceptionDeplacementIllegal, ExceptionInvalidCommand, ExceptionAttaqueImpossible, ExceptionMarcheSurObjet, ExceptionOuvrePorte{
	     if (cmd.equals("go haut")) {
	     	t.getPersonnage().sedeplacer(Actions.HAUT,t);
	     }
	     else if (cmd.equals("go bas")) {
	     	t.getPersonnage().sedeplacer(Actions.BAS,t);
	     }
	     else if (cmd.equals("go gauche")) {
	    	 t.getPersonnage().sedeplacer(Actions.GAUCHE,t);
	     }
	     else if (cmd.equals("go droite")) {
	    	 t.getPersonnage().sedeplacer(Actions.DROITE,t);
	     }
	     else if (cmd.equals("atk gauche")) {
	    	 t.getPersonnage().attaquer(Actions.GAUCHE,t);
	     }
	     else if (cmd.equals("atk droite")) {
	    	 t.getPersonnage().attaquer(Actions.DROITE,t);
	     }
	     else if (cmd.equals("atk bas")) {
	    	 t.getPersonnage().attaquer(Actions.BAS,t);
	     }
	     else if (cmd.equals("atk haut")) {
	    	 t.getPersonnage().attaquer(Actions.HAUT,t);
	     }
	     else if (cmd.equals("game over")) {
	    	 System.exit(0);
	     }
	     else if (cmd.equals("save")) {
	     	try {
				t.saveToFIle();
			}
	     	catch (Exception e){
	     		System.out.println(e.getMessage());
			}
		 }
	     else if (cmd.equals("load")){
	     	try {
	     		t = t.readFromFile();
			}
			catch (Exception e){
				System.out.println(e.getMessage());
			}
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
				t.getPersonnage().ramasserEpee(t.getEpee());
				t.setEpee(new Epee());
				joueurAPuJouer = true;
			}
			catch (ExceptionOuvrePorte e2) {
				System.out.println(e2.getMessage());
				niveau ++;
				t = t.InitAvecEnnemisEtObjets(niveau);
				joueurAPuJouer = true;
			}
			catch (Exception e3) {
				System.out.println(e3.getMessage());
				joueurAPuJouer = false;
			}
			if (joueurAPuJouer) {
				
					for(int i = 0;i<t.getEnnemis().size();i++)
					{
						try {
							t.getEnnemis().get(i).IA(t);
						}
						catch (Exception e4) {
						}
					}
				
			}
		}
		sc.close();
	}
}
