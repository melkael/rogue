package Sorts;

import Joran_Maxime_Joseph.Projet_Rogue.Terrain;

public class Soin extends Sort{

	public Soin()
	{
		super();
	}
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
