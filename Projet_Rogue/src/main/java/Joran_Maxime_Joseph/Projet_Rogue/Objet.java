package Joran_Maxime_Joseph.Projet_Rogue;

public abstract class Objet {
	public String glyph;
	public int x;
	public int y;
	public String nom;
	

	Objet()
	{
		this.nom = "";
		this.glyph ="";
		this.x = -1;
		this.y = -1;
	}
	Objet(String nom, String glyph,int x,int y){
		this.nom = nom;
		this.glyph = glyph;
		this.x = x;
		this.y = y;
	}
}
