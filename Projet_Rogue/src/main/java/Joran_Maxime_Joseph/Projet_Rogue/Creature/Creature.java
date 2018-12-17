package Joran_Maxime_Joseph.Projet_Rogue.Creature;

import Joran_Maxime_Joseph.Projet_Rogue.Actions;

import Joran_Maxime_Joseph.Projet_Rogue.Terrain;
import Joran_Maxime_Joseph.Projet_Rogue.Exception.ExceptionAttaqueImpossible;
import Joran_Maxime_Joseph.Projet_Rogue.Exception.ExceptionDeplacementIllegal;
import Joran_Maxime_Joseph.Projet_Rogue.Exception.ExceptionMarcheSurObjet;
import Joran_Maxime_Joseph.Projet_Rogue.Exception.ExceptionOuvrePorte;

import java.io.Serializable;

/**
 * Creature est une classe abstraite qui représente les creatures
 * 
 * @author Joran_Maxime_Joseph
 * @version 1.0
 */
public abstract class Creature implements Serializable {
	
	/**
	 * Attribut String nom qui représente le nom de la creature
	 * Attribut int x qui représente la coordonnée x de la creature
	 * Attribut int y qui représente la coordonnée de la creature
	 * Attribut int pv qui représente les pv de la creature
	 * Attribut int degat qui représente les degats de la creature
	 * Attribut String symbole qui représente le symbole de la creature
	 */
	private String nom;
	private int x;
	private int y;
	private int pv;
	private int degat;
	private String symbole;
	
	/**
	 * Constructeur avec attribut
	 * @param nom qui représente le nom de la creature
	 * @param x qui représente la coordonnée x de la creature
	 * @param y qui représente la coordonnée de la creature
	 * @param nb_actions qui reprsénte le nb actions de la creature
	 * @param pv qui représente les pv de la creature
	 * @param degat qui représente les degats de la creature
	 */
	public Creature(String nom,int x,int y,int nb_actions,int pv,int degat)
	{
		this.nom=nom;
		this.x=x;
		this.y=y;
		this.pv=pv;
		this.degat=degat;	
	}
	
	/**
	 * Getter du nom pour renvoyer le nom de la creature
	 * @return nom le nom de la creature
	 */
	public String getnom()
	{
		return this.nom;
	}
	
	/**
	 * Fonction estVivant pour savoir si une creature est vivante
	 * @return false si mort sinon true
	 */
	public boolean estVivant() {
		if (pv <= 0)
			return false;
		return true;
	}
	
	/**
	 * Fonction sedeplacer qui permet a une creature de se deplacer
	 * @param a qui représente une action(haut,bas,gauche,droite)
	 * @param t qui représente le terrain
	 * @throws ExceptionDeplacementIllegal qui gere les deplacements illegaux
	 * @throws ExceptionMarcheSurObjet qui envoie un message lorsque le joueur marche sur un objet
	 * @throws ExceptionOuvrePorte qui envoie un message quand on ouvre une porte
	 */
	public void sedeplacer(Actions a,Terrain t) throws ExceptionDeplacementIllegal, ExceptionMarcheSurObjet, ExceptionOuvrePorte{
		a.deplace(this, t);
	}
	
	/**
	 * Fonction attaquer qui permet a une creature d'attaquer
	 * @param a qui représente une action
	 * @param t qui représente le terrain
	 * @throws ExceptionAttaqueImpossible qui envoie un message lors d'une attaque impossible
	 */
	public void attaquer(Actions a,Terrain t) throws ExceptionAttaqueImpossible
	{
		a.attaque(this,t);
	}
	/**
	 * Fcontion close_to_player qui permet de savoir si une creature est proche du joueur
	 * @param t qui représente le terrain
	 * @return 1 si le joueur est en bas,2 si il est en haut,3 si il est a droite,4 si il est a gauche sinon -1
	 */
	//donne la position du joueur par rapport à la créature
	public int close_to_player(Terrain t){
		if(this.getX() == t.getPersonnage().getX()-1 && this.getY() == t.getPersonnage().getY())
			return 1; //perso en bas
		else if(this.getX() == t.getPersonnage().getX()+1 && this.getY() == t.getPersonnage().getY())
			return 2; //perso en haut
		else if(this.getX() == t.getPersonnage().getX() && this.getY() == t.getPersonnage().getY()-1)
			return 3; //Perso à droite
		else if(this.getX() == t.getPersonnage().getX() && this.getY() == t.getPersonnage().getY()+1)
			return 4; //Perso à gauche
		else 
			return -1;//Perso Pas Là		
	}
	
	/**
	 * Fonction IA qui permet aux gobelins de jouer tout seul
	 * @param t qui représente le terrain
	 * @throws ExceptionDeplacementIllegal qui envoie un message lors d'un deplacement illegal
	 * @throws ExceptionMarcheSurObjet qui envoie un message lorsque le joueur marche sur un objet
	 * @throws ExceptionAttaqueImpossible qui envoie un message lorsuqu'une attaque est impossible
	 * @throws ExceptionOuvrePorte qui envoie un message lorsqu'on ouvre une porte
	 */
	abstract public void IA(Terrain t)throws ExceptionDeplacementIllegal, ExceptionMarcheSurObjet,ExceptionAttaqueImpossible, ExceptionOuvrePorte;

	/**
	 * Getter nom qui renvoie le nom de la creature
	 * @return nom le nom de la creature
	 */
	public String getNom() 
	{
		return nom;
	}

	/**
	 * Setter nom qui permet de modifier le nom de la creature
	 * @param nom le nom de la creature
	 */
	public void setNom(String nom) 
	{
		this.nom = nom;
	}

	/**
	 *  Getter x qui renvoie la coordonnée x de la creature
	 * @return x la coordonee de la creature
	 */
	public int getX() 
	{
		return x;
	}
	
	/**
	 * Setter x qui permet de modifier la coordonnée x  de la creature
	 * @param x la coordonee de la creature
	 */
	public void setX(int x) 
	{
		this.x = x;
	}

	/**
	 * Getter y qui permet de recuperer la coordonne y de la creature
	 * @return y la coordonee de la creature
	 */
	public int getY() 
	{
		return y;
	}

	/**
	 * Setter y qui permet de modifier la coordonne y de la creature
	 * @param y la coordonnee de la creature
	 */
	public void setY(int y) 
	{
		this.y = y;
	}

	/**
	 *  Getter pv qui permet de renvoyer les pv de la creature
	 * @return pv les pv de la creature
	 */
	public int getPv() 
	{
		return pv;
	}

	/**
	 * Setter pv qui permet de modifier les pv de la creature
	 * @param pv les pv de la creature
	 */
	public void setPv(int pv) 
	{
		this.pv = pv;
	}

	/**
	 * Getter degat qui permet de renvoyer les degats de la creature
	 * @return degat les degats de la creature
	 */
	public int getDegat() 
	{
		return degat;
	}

	/**
	 * Setter degat qui permet de modifier les degats de la creature
	 * @param degat lles degats de la creature
	 */
	public void setDegat(int degat) 
	{
		this.degat = degat;
	}

	/**
	 * Getter symbole qui permet de recuperer le symbole de la creature
	 * @return symbole le symbole de la creature
	 */
	public String getSymbole() 
	{
		return symbole;
	}

	/**
	 * Setter symbole qui permet de modifier le symbole de la creature
	 * @param symbole le symbole de la creature
	 */
	public void setSymbole(String symbole) 
	{
		this.symbole = symbole;
	}
	
}
