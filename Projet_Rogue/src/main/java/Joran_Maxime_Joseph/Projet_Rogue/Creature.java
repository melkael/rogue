package Joran_Maxime_Joseph.Projet_Rogue;

import Joran_Maxime_Joseph.Projet_Rogue.Exception.ExceptionAttaqueImpossible;
import Joran_Maxime_Joseph.Projet_Rogue.Exception.ExceptionDeplacementIllegal;
import Joran_Maxime_Joseph.Projet_Rogue.Exception.ExceptionMarcheSurObjet;
import Joran_Maxime_Joseph.Projet_Rogue.Exception.ExceptionOuvrePorte;

public abstract class Creature {
	
	public String nom;
	public int x;
	public int y;
	public int pv;
	public int degat;
	public String symbole;
	
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
		if(this.x == t.personnage.x-1 && this.y == t.personnage.y)
			return 1; //perso en bas
		else if(this.x == t.personnage.x+1 && this.y == t.personnage.y)
			return 2; //perso en haut
		else if(this.x == t.personnage.x && this.y == t.personnage.y-1)
			return 3; //Perso à droite
		else if(this.x == t.personnage.x && this.y == t.personnage.y+1)
			return 4; //Perso à gauche
		else 
			return -1;//Perso Pas Là		
	}
	
	abstract public void IA(Terrain t)throws ExceptionDeplacementIllegal, ExceptionMarcheSurObjet,ExceptionAttaqueImpossible, ExceptionOuvrePorte;
	
}
