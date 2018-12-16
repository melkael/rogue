package Joran_Maxime_Joseph.Projet_Rogue.Creature;

import Joran_Maxime_Joseph.Projet_Rogue.Actions;
import Joran_Maxime_Joseph.Projet_Rogue.Terrain;
import Joran_Maxime_Joseph.Projet_Rogue.Exception.ExceptionAttaqueImpossible;
import Joran_Maxime_Joseph.Projet_Rogue.Exception.ExceptionDeplacementIllegal;
import Joran_Maxime_Joseph.Projet_Rogue.Exception.ExceptionMarcheSurObjet;
import Joran_Maxime_Joseph.Projet_Rogue.Exception.ExceptionOuvrePorte;

import java.io.Serializable;

public abstract class Creature implements Serializable {
	
	private String nom;
	private int x;
	private int y;
	private int pv;
	private int degat;
	private String symbole;
	
	public Creature(String nom,int x,int y,int nb_actions,int pv,int degat)
	{
		this.nom=nom;
		this.x=x;
		this.y=y;
		this.pv=pv;
		this.degat=degat;	
	}
	
	public String getnom()
	{
		return this.nom;
	}
	
	public boolean estVivant() {
		if (pv <= 0)
			return false;
		return true;
	}
	
	public void sedeplacer(Actions a,Terrain t) throws ExceptionDeplacementIllegal, ExceptionMarcheSurObjet, ExceptionOuvrePorte{
		a.deplace(this, t);
	}
	public void attaquer(Actions a,Terrain t) throws ExceptionAttaqueImpossible
	{
		a.attaque(this,t);
	}
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
	
	abstract public void IA(Terrain t)throws ExceptionDeplacementIllegal, ExceptionMarcheSurObjet,ExceptionAttaqueImpossible, ExceptionOuvrePorte;

	public String getNom() 
	{
		return nom;
	}

	public void setNom(String nom) 
	{
		this.nom = nom;
	}

	public int getX() 
	{
		return x;
	}

	public void setX(int x) 
	{
		this.x = x;
	}

	public int getY() 
	{
		return y;
	}

	public void setY(int y) 
	{
		this.y = y;
	}

	public int getPv() 
	{
		return pv;
	}

	public void setPv(int pv) 
	{
		this.pv = pv;
	}

	public int getDegat() 
	{
		return degat;
	}

	public void setDegat(int degat) 
	{
		this.degat = degat;
	}

	public String getSymbole() 
	{
		return symbole;
	}

	public void setSymbole(String symbole) 
	{
		this.symbole = symbole;
	}
	
}
