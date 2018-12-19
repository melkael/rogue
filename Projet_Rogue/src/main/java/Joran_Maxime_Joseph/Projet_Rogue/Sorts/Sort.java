package Joran_Maxime_Joseph.Projet_Rogue.Sorts;

import Joran_Maxime_Joseph.Projet_Rogue.Terrain;

/**
 * Sort est une classe abstraite qui représente les sorts
 * 
 * @author Joran_Maxime_Joseph
 * @version 1.0
 */
public abstract class Sort {
	
	private String nom;
	private int Cout;
	/**
	 * Constructeur de Sort()
	 */
	public Sort()
	{
		this.nom = "";
		this.setCout(0);
	}
	/**
	 * Constructeur de Sort avec parametre
	 * @param nom qui represente le nom du sort
	 * @param Cout qui represente le cout du sort
	 */
	public Sort(String nom,int Cout) {
		this.nom = nom;
		this.setCout(Cout);
	}
	/**
	 * Fonction String Effet(Terrain t) qui retourne un message si le sort a fonctionné ou non selon les manas du joueur
	 *
	 * @param t qui represente le terrain
	 * @return qui renvoie un message
	 */
	public abstract String Effet(Terrain t);
	/**
	 * Setter setNom(String nom)
	 * @param nom qui permet de modifier le nom du sort
	 */
	public void setNom(String nom)
	{
		this.nom = nom;
	}
	/**
	 * Getter getNom()
	 * @return le nom du sort
	 */
	public String getNom()
	{
		return this.nom;
	}
	/**
	 * Getter getCout()
	 * @return le cout du sort
	 */
	public int getCout() {
		return Cout;
	}
	/**
	 * Setter setCout(int cout)
	 * @param cout qui permet de modifier le cout
	 */
	public void setCout(int cout) {
		Cout = cout;
	}
}
