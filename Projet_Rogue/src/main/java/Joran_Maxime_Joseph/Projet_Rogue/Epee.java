package Joran_Maxime_Joseph.Projet_Rogue;

public class Epee extends Objet{
	
	public int degat;
	public Epee() {
		super();
		this.degat = 0;
	}
	public Epee(String nom,String glyph,int degat,int x,int y)
	{
		super(nom,glyph,x,y);
		this.degat = degat;
	}

}
