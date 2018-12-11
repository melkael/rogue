package Joran_Maxime_Joseph.Projet_Rogue;

public class Joueur extends Creature {
	
	private int lvl;
	private int exp;
	
	public Joueur(String nom,int x,int y,int nb_actions,int pv,int degat,int lvl,int exp)
	{
		super(nom,x,y,nb_actions,pv,degat);
		this.lvl=lvl;
		this.exp=exp;
	}

}
