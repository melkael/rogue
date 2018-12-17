package Joran_Maxime_Joseph.Projet_Rogue.Creature;

import Joran_Maxime_Joseph.Projet_Rogue.Terrain;
import Joran_Maxime_Joseph.Projet_Rogue.Objet.Bouclier;
import Joran_Maxime_Joseph.Projet_Rogue.Objet.Epee;

/**
 * Joueur est une classe qui représente le joueur
 * 
 * @author Joran_Maxime_Joseph
 * @version 1.0
 */
public class Joueur extends Creature {
	
	/**
	 * Attribut int lvl qui représente le niveau
	 * Attribut int exp qui représente l'experience
	 * Attribut Epee epee qui représente le port de l'epee
	 */
	private int lvl;
	private int exp;
	private Bouclier bouclier;
	private Epee epee;
	
	/**
	 * Constructeur avec attribut
	 * @param nom qui représente le nom du joueur
	 * @param x qui représente la coordonnée x du joueur
	 * @param y qui représente la coordonnée y du joueur
	 * @param nb_actions qui repésente le nb_actions du joueur
	 * @param pv qui représente les pv du joueur
	 * @param degat qui représente les degats du joueur
	 * @param lvl qui représente les lvl du joueur
	 * @param exp qui représente l'experience du joueur
	 */
	public Joueur(String nom,int x,int y,int nb_actions,int pv,int degat,int lvl,int exp)
	{
		super(nom,x,y,nb_actions,pv,degat);
		this.lvl=lvl;
		this.exp=exp;
		this.setSymbole("@") ;
		this.bouclier = new Bouclier();
		this.epee = new Epee();
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
	
	@Override
	public void IA(Terrain t){
		
	}

	/**
	 * Getter de lvl qui renvoie le niveau du joueur
	 * @return lvl le lvl du joueur
	 */
	public int getLvl() 
	{
		return lvl;
	}

	/**
	 * Setter de lvl qui modifie le niveau du joueur
	 * @param lvl le lvl du joueur
	 */
	public void setLvl(int lvl) 
	{
		this.lvl = lvl;
	}

	/**
	 * Getter de exp qui renvoie l'experience du joueur
	 * @return exp l'exp du joueur
	 */
	public int getExp() 
	{
		return exp;
	}

	/**
	 * Setter de exp qui modifie l'exp du joueur
	 * @param exp l'exp du joueur
	 */
	public void setExp(int exp) 
	{
		this.exp = exp;
	}

	public Bouclier getBouclier() 
	{
		return bouclier;
	}

	public void setBouclier(Bouclier bouclier) 
	{
		this.bouclier = bouclier;
	}

	/**
	 * Getter de Epee qui renvoie l'epee du joueur
	 * @return epee l'epee du joueur
	 */
	public Epee getEpee() 
	{
		return epee;
	}

	/**
	 * Setter de epee qui modifie l'epee du joueur
	 * @param epee l'epee du joueur
	 */
	public void setEpee(Epee epee) 
	{
		this.epee = epee;
	}
	
}
