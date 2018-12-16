package Joran_Maxime_Joseph.Projet_Rogue.Objet;

public class Epee extends Objet{
	
	private int degat;
	
	public Epee() 
	{
		super();
		this.degat = 0;
	}
	
	public Epee(String nom,String glyph,int degat,int x,int y)
	{
		super(nom,glyph,x,y);
		this.degat = degat;
	}
	
	public int getDegat() 
	{
		return degat;
	}
	
	public void setDegat(int degat)
	{
		this.degat = degat;
	}

}
