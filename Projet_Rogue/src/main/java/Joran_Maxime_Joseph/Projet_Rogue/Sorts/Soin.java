package Joran_Maxime_Joseph.Projet_Rogue.Sorts;

import Joran_Maxime_Joseph.Projet_Rogue.Terrain;
import Joran_Maxime_Joseph.Projet_Rogue.Exception.ExceptionNotEnoughMana;

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
	public void Effet(Terrain t) throws ExceptionNotEnoughMana{
		if(t.getPersonnage().getMana() < this.getCout())
			throw new ExceptionNotEnoughMana();
		t.getPersonnage().setMana(t.getPersonnage().getMana()-this.getCout());
		t.getPersonnage().setPv(t.getPersonnage().getPv()+10);
		System.out.println("Vous vous sentez mieux ! Vous gagnez 10 pv");
	}

}
