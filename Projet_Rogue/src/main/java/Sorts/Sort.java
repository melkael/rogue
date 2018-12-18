package Sorts;

import Joran_Maxime_Joseph.Projet_Rogue.Terrain;

public abstract class Sort {
	private String nom;
	private int Cout;
	public Sort()
	{
		this.nom = "";
		this.setCout(0);
	}
	public Sort(String nom,int Cout) {
		this.nom = nom;
		this.setCout(Cout);
	}
	public abstract String Effet(Terrain t);
	public void setNom(String nom)
	{
		this.nom = nom;
	}
	public String getNom()
	{
		return this.nom;
	}
	public int getCout() {
		return Cout;
	}
	public void setCout(int cout) {
		Cout = cout;
	}
}
