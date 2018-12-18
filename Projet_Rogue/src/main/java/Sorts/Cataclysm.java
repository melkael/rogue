package Sorts;

import Joran_Maxime_Joseph.Projet_Rogue.Terrain;

public class Cataclysm extends Sort{
	public Cataclysm()
	{
		super();
	}
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
			msg = "Le cataclysm se déchaine ! Tout les ennemsi perdent 10Pv";
		}
		
		return msg;
		}
}
