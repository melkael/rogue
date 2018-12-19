package Joran_Maxime_Joseph.Projet_Rogue.Sorts;

import Joran_Maxime_Joseph.Projet_Rogue.Terrain;

/**
 * Cataclysme est une classe qui permet de lancer un sort qui touche tous les ennemis sur le terrain
 * 
 * @author Joran_Maxime_Joseph
 * @version 1.0
 */

public class Cataclysm extends Sort{
	/**
	 * Constructeur Cataclysm
	 */
	public Cataclysm()
	{
		super();
	}
	/**
	 * Constructeur Cataclysme avec parametre
	 * @param nom qui représente le nom du sort
	 * @param Cout qui représente le cout du sort
	 */
	public Cataclysm(String nom,int Cout)
	{
		super(nom,Cout);
	}
	
	// Retourne un message d'interaction 
	@Override
	public String Effet(Terrain t) {
		String msg = new String();
		if(t.getPersonnage().getMana() < this.getCout())
			msg = "Not Enough Mana";
		else {
			t.getPersonnage().setMana(t.getPersonnage().getMana()-this.getCout());
			for(int i = 0;i< t.getEnnemis().size();i++) {
				t.getEnnemis().get(i).setPv(t.getEnnemis().get(i).getPv() - 10);
			}
			msg = "Le cataclysm se déchaine ! Tout les ennemis perdent 10Pv";
		}
		
		return msg;
		}
}
