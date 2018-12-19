package Joran_Maxime_Joseph.Projet_Rogue.Creature;

import Joran_Maxime_Joseph.Projet_Rogue.Terrain;
import Joran_Maxime_Joseph.Projet_Rogue.Objet.Epee;

/**
 * Joueur est une classe qui représente le joueur
 * 
 * @author Joran_Maxime_Joseph
 * @version 1.0
 */
public class Joueur extends Creature {
	
	private Epee epee;
	private int Mana;
	
	/**
	 * Constructeur Joueur
	 * @param nom qui représente le nom du joueur
	 * @param x qui représente la coordonnée x du joueur
	 * @param y qui représente la coordonnée y du joueur
	 * @param pv qui représente les pv du joueur
	 * @param degat qui représente les degats du joueur
	 * @param mana qui représente le mana du joueur
	 */
	public Joueur(String nom,int x,int y,int pv,int degat,int mana)
	{
		super(nom,x,y,pv,degat);
		this.setSymbole("\uD83D\uDC82") ;
		this.epee = new Epee();
		this.Mana = mana;
	}
	
	/**
	 * Fonction ramasserEpee pour que le joueur ramasse une épée
	 * @param e qui représente une épée
	 */
	public void ramasserEpee(Epee e) {
		this.setDegat(this.getDegat()-this.epee.getDegat()) ;
		this.setEpee(e);
		this.setDegat(this.getDegat()+this.epee.getDegat()) ;
		System.out.println(ANSI_YELLOW + "Vous ramassez " + e.getNom() + ", vos degats : " + this.getDegat() + ANSI_RESET);
	}

	/**
	 * Fonction afficheStats() qui affiche les stats du perso
	 */
	public void afficheStats(){
		System.out.println("####################################");
		System.out.print("### ");
		System.out.print(ANSI_GREEN + "PV : ");
		System.out.print(this.getPv());
		System.out.print(ANSI_RESET);
		System.out.print(ANSI_RED + " DMG : ");
		System.out.print(this.getDegat());
		System.out.print(ANSI_RESET);
		System.out.print(ANSI_BLUE);
		System.out.print(" MANA : ");
		System.out.print(this.getMana());
		System.out.print("/50");
		System.out.print(ANSI_RESET);
		System.out.println(" ###");
		System.out.println("####################################");
	}
	
	@Override
	public void IA(Terrain t){
		
	}

	/**
	 * Getter getEpee() 
	 * @return epee qui renvoie l'epee du joueur
	 */
	public Epee getEpee() 
	{
		return epee;
	}

	/**
	 * Setter setEpee(Epee epee) 
	 * @param epee qui modifie l'epee du joueur
	 */
	public void setEpee(Epee epee) 
	{
		this.epee = epee;
	}

	/**
	 * Getter getMana()
	 * @return Mana qui renvoie le mana du joueur
	 */
	public int getMana() {
		return Mana;
	}

	/**
	 * Setter setMana(int mana) 
	 * @param mana qui permet de modifier le mana du joueur
	 */
	public void setMana(int mana) {
		Mana = mana;
	}
	
}
