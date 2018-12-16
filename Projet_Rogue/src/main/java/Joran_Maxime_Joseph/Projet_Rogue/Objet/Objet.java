package Joran_Maxime_Joseph.Projet_Rogue.Objet;

import java.io.Serializable;

public abstract class Objet implements Serializable {
	private String glyph;
	private int x;
	private int y;
	private String nom;
	

	Objet()
	{
		this.nom = "";
		this.glyph ="";
		this.x = -1;
		this.y = -1;
	}
	Objet(String nom, String glyph,int x,int y)
	{
		this.nom = nom;
		this.glyph = glyph;
		this.x = x;
		this.y = y;
	}
	public String getGlyph() 
	{
		return glyph;
	}
	
	public void setGlyph(String glyph) 
	{
		this.glyph = glyph;
	}
	
	public int getX() 
	{
		return x;
	}
	
	public void setX(int x) 
	{
		this.x = x;
	}
	
	public int getY() 
	{
		return y;
	}
	
	public void setY(int y) 
	{
		this.y = y;
	}
	
	public String getNom()
	{
		return nom;
	}
	
	public void setNom(String nom)
	{
		this.nom = nom;
	}
}
