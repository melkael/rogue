package Joran_Maxime_Joseph.Projet_Rogue;

import java.util.Scanner;

import Joran_Maxime_Joseph.Projet_Rogue.Creature.Joueur;
import Joran_Maxime_Joseph.Projet_Rogue.Divers.Correcteur;
import Joran_Maxime_Joseph.Projet_Rogue.Exception.*;
import Joran_Maxime_Joseph.Projet_Rogue.Menu.EndMenu;
import Joran_Maxime_Joseph.Projet_Rogue.Menu.LoadMenu;
import Joran_Maxime_Joseph.Projet_Rogue.Objet.Epee;
import Joran_Maxime_Joseph.Projet_Rogue.Sorts.Cataclysm;
import Joran_Maxime_Joseph.Projet_Rogue.Sorts.Soin;
import Joran_Maxime_Joseph.Projet_Rogue.Menu.SaveMenu;

/**
 * Saisie est une classe  qui représente le jeu
 * 
 * @author Joran_Maxime_Joseph
 * @version 1.0
 */
public class Saisie {
	private Terrain t;
	private Joueur j;
	private int niveau;
	
	/**
	 * Constructeur Saisie
	 * @param j qui représente le joueur
	 */
	public Saisie(Joueur j) 
	{
		this.niveau = 0;
		this.j = j;
		this.t = new Terrain(j);
		this.t = t.InitAvecEnnemisEtObjets(niveau);
	}

	/**
	 * Constructeur Saisie
	 * @param t qui représente le terrain
	 */
	public Saisie(Terrain t)
	{
		this.niveau = t.getTaille() / 5;
		this.j = t.getPersonnage();
		this.t = t;
	}

	/**
	 * Fonction joueurJoue qui permet au joueur de jouer
	 * @param cmd qui représente les cmds tapées par le joueur
	 * @throws ExceptionDeplacementIllegal qui envoie un message lors de deplacements illegaux
	 * @throws ExceptionInvalidCommand qui envoie un message lors d'une mauvaise commande
	 * @throws ExceptionAttaqueImpossible qui envoie un message lors d'une attaque impossible
	 * @throws ExceptionMarcheSurObjet qui envoie un message lorsque le joueur marche sur un objet
	 * @throws ExceptionOuvrePorte qui envoie un message quand on ouvre une porte
	 * @throws ExceptionNotEnoughMana qui envoie un message quand lej oueur n'a pas assez de mana
	 */
	public void joueurJoue(String cmd) throws ExceptionDeplacementIllegal, ExceptionInvalidCommand, ExceptionAttaqueImpossible, ExceptionMarcheSurObjet, ExceptionOuvrePorte, ExceptionNotEnoughMana{
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
				EndMenu end = new EndMenu(j.getNom());
				end.AsciiArt("LVL : " + Integer.toString(niveau));
				System.exit(0);
				break;
			case "save":
				SaveMenu save = new SaveMenu();
				save.save(t.getPersonnage().getNom(), t);
				break;
			case "load":
				try {
					LoadMenu load = new LoadMenu();
					t = load.load();
				}
				catch (ExceptionAbsenceDeSauvegarde e){
					System.out.println(e.getMessage());
				}
				break;
			case "cataclysme" :
				try {
				Cataclysm spell = new Cataclysm("BombeA",50);
				spell.Effet(t);
				}
				catch(ExceptionNotEnoughMana e){
					System.out.println(e.getMessage());
				}
				
				break;
			case "soin" :
				try {
				Soin swag =new Soin("Heal",30);
				swag.Effet(t);
				}
				catch(ExceptionNotEnoughMana e) {
					System.out.println(e.getMessage());
				}
				break;	
			default:
				throw new ExceptionInvalidCommand();
		}
	}
	
	/**
	 * Fonction jouer qui permet au jeu de s'exécuter
	 */
	public void jouer() {
		Scanner sc= new Scanner(System.in);
		String cmd = "go !";
		boolean joueurAPuJouer;
		Correcteur c = new Correcteur();
		while(cmd != "game over") {
			for (int i = 0; i < 5; i++) {
				System.out.println();
			}
			t.getPersonnage().afficheStats();
			t.Affiche();
			cmd = sc.nextLine();
			if (!"".equals(c.corriger(cmd))) {
				cmd = c.corriger(cmd);
				System.out.println("Oups, j'ai l'impression que tu as fait une faute de frappe");
				System.out.println("Je corrige en : " + cmd);
			}
			try {
				joueurJoue(cmd);
				joueurAPuJouer = true;
			} catch (ExceptionMarcheSurObjet e1) {
				t.getPersonnage().ramasserEpee(t.getEpee());
				t.setEpee(new Epee());
				joueurAPuJouer = true;
			} catch (ExceptionOuvrePorte e2) {
				System.out.println(e2.getMessage());
				niveau++;
				t.getPersonnage().setPv(t.getPersonnage().getPv() + niveau * 5);
				t.getPersonnage().setMana(t.getPersonnage().getMana() + niveau * 5);
				t = t.InitAvecEnnemisEtObjets(niveau);
				joueurAPuJouer = true;
			} catch (Exception e3) {
				System.out.println(e3.getMessage());
				joueurAPuJouer = false;
			}
			if (joueurAPuJouer) {
				for (int i = 0; i < t.getEnnemis().size(); i++) {
					try {
						t.getEnnemis().get(i).IA(t);
					} catch (Exception e4) {
						// ne pas afficher l'erreur pour les gobelins
					}
				}
			}
			if (!t.getPersonnage().estVivant()){
				EndMenu end = new EndMenu(j.getNom());
				end.AsciiArt("LVL : " + Integer.toString(niveau));
				System.exit(0);
			}
		}
		sc.close();
	}
}
