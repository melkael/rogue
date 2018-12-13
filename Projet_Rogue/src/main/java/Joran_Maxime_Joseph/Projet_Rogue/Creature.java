package Joran_Maxime_Joseph.Projet_Rogue;

public abstract class Creature {
	
	private String nom;
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
}
