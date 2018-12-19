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
	
	private int lvl;
	private int exp;
	private Epee epee;
	private int Mana;
	
	/**
	 * Constructeur Joueur
	 * @param nom qui représente le nom du joueur
	 * @param x qui représente la coordonnée x du joueur
	 * @param y qui représente la coordonnée y du joueur
	 * @param pv qui représente les pv du joueur
	 * @param degat qui représente les degats du joueur
	 * @param lvl qui représente les lvl du joueur
	 * @param exp qui représente l'experience du joueur
	 * @param mana qui représente le mana du joueur
	 */
	public Joueur(String nom,int x,int y,int pv,int degat,int lvl,int exp,int mana)
	{
		super(nom,x,y,pv,degat);
		this.lvl=lvl;
		this.exp=exp;
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
		System.out.println("Vous ramassez " + e.getNom() + ", vos degats : " + this.getDegat());
	}

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
	 * Getter getLvl() 
	 * @return lvl qui renvoie le niveau du joueur
	 */
	public int getLvl() 
	{
		return lvl;
	}

	/**
	 * Setter setLvl(int lvl) 
	 * @param lvl qui modifie le niveau du joueur
	 */
	public void setLvl(int lvl) 
	{
		this.lvl = lvl;
	}

	/**
	 * Getter getExp() 
	 * @return exp qui renvoie l'experience du joueur
	 */
	public int getExp() 
	{
		return exp;
	}

	/**
	 * Setter setExp(int exp) 
	 * @param exp qui modifie l'exp du joueur
	 */
	public void setExp(int exp) 
	{
		this.exp = exp;
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

	public int getMana() {
		return Mana;
	}

	public void setMana(int mana) {
		Mana = mana;
	}
	
}
