package Joran_Maxime_Joseph.Projet_Rogue;

public class Joueur extends Creature {
	
	private int lvl;
	private int exp;
	public Bouclier bouclier;
	public Epee epee;
	
	public Joueur(String nom,int x,int y,int nb_actions,int pv,int degat,int lvl,int exp)
	{
		super(nom,x,y,nb_actions,pv,degat);
		this.lvl=lvl;
		this.exp=exp;
		this.symbole = "\uD83D\uDC68";
		this.bouclier = new Bouclier();
		this.epee = new Epee();
	}
	
	public void ramasserEpee(Epee e) {
		this.degat -= this.epee.degat;
		this.epee = e;
		this.degat += this.epee.degat;
		System.out.println("Vous ramassez " + e.nom + ", vos degats : " + this.degat);
	}
	
	@Override
	public void IA(Terrain t){
		
	}
	
}
