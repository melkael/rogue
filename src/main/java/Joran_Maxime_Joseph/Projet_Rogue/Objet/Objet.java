package Joran_Maxime_Joseph.Projet_Rogue.Objet;

import java.io.Serializable;

/**
 * Objet est une classe abstraite qui représente les objets
 * 
 * @author Joran_Maxime_Joseph
 * @version 1.0
 */

public abstract class Objet implements Serializable {
	/**
	 * Attribut String glyph qui représente le symbole de l'epee
	 * Attribut int x qui représente les coordonnées x de l'objet
	 * Attribut int y qui représente les coordonnées y de l'objet
	 * Attribut String nom qui représente le nom de l'objet
	 * 
	 */
	private String glyph;
	private int x;
	private int y;
	private String nom;
	
	/**
	 * Constructeur par défaut de Objet
	 */
	Objet()
	{
		this.nom = "";
		this.glyph ="";
		this.x = -1;
		this.y = -1;
	}
	/**
	 * Constructeur avec attribut de Objet
	 * @param nom qui représente le nom de l'objet
	 * @param glyph qui représente le symbole de l'objet
	 * @param x qui représente les coordonnées x de l'objet
	 * @param y qui représente les coordonnées y de l'objet
	 */
	Objet(String nom, String glyph,int x,int y)
	{
		this.nom = nom;
		this.glyph = glyph;
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Getter de glyphe pour récupérer le symbole
	 * @return glyph le symbole de l'objet
	 */
	public String getGlyph() 
	{
		return glyph;
	}
	
	/**
	 * Setter de Glyphe pour modifier le symbole
	 * @param glyph le symbole de l'objet
	 */
	public void setGlyph(String glyph) 
	{
		this.glyph = glyph;
	}
	
	/**
	 * Getter de x qui récupère la coordonée x de l'objet
	 * @return x la coordonee de l'objet
	 */
	public int getX() 
	{
		return x;
	}
	
	/**
	 * Setter de x qui modifie la coordonnée x de l'objet
	 * @param x la coordonnee de l'objet
	 */
	public void setX(int x) 
	{
		this.x = x;
	}
	
	/**
	 * Getter de y qui récupère la coordonnée de y de l'objet
	 * @return y la coordonnee de l'objet
	 */
	public int getY() 
	{
		return y;
	}
	
	/**
	 * Setter de y qui modifie la coordonnée y de l'objet
	 * @param y la coordonne de l'objet
	 */
	public void setY(int y) 
	{
		this.y = y;
	}
	
	/**
	 * Getter de nom qui récupère le nom de l'objet
	 * @return nom le nom de l'objet
	 */
	public String getNom()
	{
		return nom;
	}
	
	/**
	 * Setter de nom qui modifie le nom de l'objet
	 * @param nom le nom de l'objet
	 */
	public void setNom(String nom)
	{
		this.nom = nom;
	}
}
