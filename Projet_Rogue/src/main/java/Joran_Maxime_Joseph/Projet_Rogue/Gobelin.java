package Joran_Maxime_Joseph.Projet_Rogue;

public class Gobelin extends Creature {
	
	public Gobelin(String nom,int x,int y,int nb_actions,int pv,int degat)
	{
		super(nom,x,y,nb_actions,pv,degat);
		this.symbole = "G";
	}

}
