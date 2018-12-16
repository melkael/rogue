package Joran_Maxime_Joseph.Projet_Rogue.Creature;

import Joran_Maxime_Joseph.Projet_Rogue.Terrain;
import Joran_Maxime_Joseph.Projet_Rogue.Objet.Bouclier;
import Joran_Maxime_Joseph.Projet_Rogue.Objet.Epee;

public class Joueur extends Creature {
	
	private int lvl;
	private int exp;
	private Bouclier bouclier;
	private Epee epee;
	
	public Joueur(String nom,int x,int y,int nb_actions,int pv,int degat,int lvl,int exp)
	{
		super(nom,x,y,nb_actions,pv,degat);
		this.lvl=lvl;
		this.exp=exp;
		this.setSymbole("@") ;
		this.bouclier = new Bouclier();
		this.epee = new Epee();
	}
	
	public void ramasserEpee(Epee e) {
		this.setDegat(this.getDegat()-this.epee.getDegat()) ;
		this.setEpee(e);
		this.setDegat(this.getDegat()+this.epee.getDegat()) ;
		System.out.println("Vous ramassez " + e.getNom() + ", vos degats : " + this.getDegat());
	}
	
	@Override
	public void IA(Terrain t){
		
	}

	public int getLvl() 
	{
		return lvl;
	}

	public void setLvl(int lvl) 
	{
		this.lvl = lvl;
	}

	public int getExp() 
	{
		return exp;
	}

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

	public Epee getEpee() 
	{
		return epee;
	}

	public void setEpee(Epee epee) 
	{
		this.epee = epee;
	}
	
}
