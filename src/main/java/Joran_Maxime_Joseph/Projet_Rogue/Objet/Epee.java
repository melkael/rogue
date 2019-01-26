package Joran_Maxime_Joseph.Projet_Rogue.Objet;

/**
 * Epee est une classe qui hérite de Objet représentant un Objet Epée
 * 
 * @author Joran_Maxime_Joseph
 * @version 1.0
 */
public class Epee extends Objet{
	
	/**
	 * Attribut int dégât qui représente les degats de l'epee
	 */
	private int degat;
	
	/**
	 * Constructeur Par Defaut Epée
	 * 
	 */
	public Epee() 
	{
		super();
		this.degat = 0;
	}
	
	/**
	 * Constructeur Epee avec attribut 
	 * 
	 * @param nom nom de l'épée
	 * @param glyph symbole de l'épée
	 * @param degat degat de l'épée
	 * @param x coordonnée x de l'épée
	 * @param y coordonnée y de l'épée
	 * 
	 */
	public Epee(String nom,String glyph,int degat,int x,int y)
	{
		super(nom,glyph,x,y);
		this.degat = degat;
	}
	
	/**
	 * Getter de degat
	 * @return degat les degats du perso
	 */
	public int getDegat() 
	{
		return degat;
	}
	
	/**
	 * Setter de degat
	 * @param degat permet de modifier la valeur de degat
	 * 
	 */
	public void setDegat(int degat)
	{
		this.degat = degat;
	}

}
