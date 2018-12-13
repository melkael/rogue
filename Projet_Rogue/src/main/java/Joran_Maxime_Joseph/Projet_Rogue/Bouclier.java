package Joran_Maxime_Joseph.Projet_Rogue;

public class Bouclier extends Objet{
	public int shield;
	public Bouclier() {
		super();
		this.shield = 0;
	}
	public Bouclier(String nom,String glyph,int shield,int x,int y)
	{
		super(nom,glyph,x,y);
		this.shield = shield;
	}

}
