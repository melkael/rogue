package Sorts;

import Joran_Maxime_Joseph.Projet_Rogue.Terrain;

/**
 * Soin est une classe qui permet de lancer un sort qui soigne le joueur
 * 
 * @author Joran_Maxime_Joseph
 * @version 1.0
 */
public class Soin extends Sort{

	/**
	 * Constructeur Soin()
	 */
	public Soin()
	{
		super();
	}
	/**
	 * Constructeur Soin avec parametre
	 * @param nom qui represente le nom du Sort 
	 * @param Cout qui represente le cout du sort
	 */
	public Soin(String nom,int Cout)
	{
		super(nom,Cout);
	}
	
	@Override
	public String Effet(Terrain t) {
		String msg = new String();
		if(t.getPersonnage().getMana() < this.getCout())
			msg = "Not Enough Mana";
		else {
			t.getPersonnage().setMana(t.getPersonnage().getMana()-this.getCout());
			t.getPersonnage().setPv(t.getPersonnage().getPv()+10);
			msg = "Vous vous sentez mieux ! Vous gagnez 10 pv";
		}
		return msg;
	}

}
