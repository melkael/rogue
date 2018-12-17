package Joran_Maxime_Joseph.Projet_Rogue;

import java.util.Scanner;

import Joran_Maxime_Joseph.Projet_Rogue.Creature.Joueur;
import Joran_Maxime_Joseph.Projet_Rogue.Divers.Correcteur;
import Joran_Maxime_Joseph.Projet_Rogue.Exception.*;
import Joran_Maxime_Joseph.Projet_Rogue.Menu.LoadMenu;
import Joran_Maxime_Joseph.Projet_Rogue.Objet.Epee;
import Joran_Maxime_Joseph.Projet_Rogue.Menu.SaveMenu;

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
	    switch(cmd){
			case "go haut":
				t.getPersonnage().sedeplacer(Actions.HAUT,t);
				break;
			case "go bas":
				t.getPersonnage().sedeplacer(Actions.BAS,t);
				break;
			case "go gauche":
				t.getPersonnage().sedeplacer(Actions.GAUCHE,t);
				break;
			case "go droite":
				t.getPersonnage().sedeplacer(Actions.DROITE,t);
				break;
			case "atk gauche":
				t.getPersonnage().attaquer(Actions.GAUCHE,t);
				break;
			case "atk droite":
				t.getPersonnage().attaquer(Actions.DROITE,t);
				break;
			case "atk bas":
				t.getPersonnage().attaquer(Actions.BAS,t);
				break;
			case "atk haut":
				t.getPersonnage().attaquer(Actions.HAUT,t);
				break;
			case "game over":
				System.exit(0);
				break;
			case "save":
				SaveMenu save = new SaveMenu();
				save.save(t.getPersonnage().getNom(), t);
				break;
			case "load":
				try {
					LoadMenu load = new LoadMenu();
					t = load.load(t);
				}
				catch (ExceptionAbsenceDeSauvegarde e){
					System.out.println(e.getMessage());
				}
				break;
			default:
				throw new ExceptionInvalidCommand();
		}
	}
	
	public void jouer() {
		Scanner sc= new Scanner(System.in);
		String cmd = "go !";
		boolean joueurAPuJouer;
		Correcteur c = new Correcteur();
		while(cmd != "game over") {
	    	//for(int i = 0; i < 100; i++) {System.out.println();}
	        t.Affiche();
			cmd = sc.nextLine();
			if(!"".equals(c.corriger(cmd))){
				cmd = c.corriger(cmd);
				System.out.println("Oups, j'ai l'impression que tu as fait une faute de frappe");
				System.out.println("Je corrige en : " + cmd);
			}
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
