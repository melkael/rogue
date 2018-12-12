package Joran_Maxime_Joseph.Projet_Rogue;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestJoueur {

	@Test
	public void TestInstanceJoueur() 
	{
		Joueur j = new Joueur("Maxou", 5, 5, 1, 10, 5, 1, 0);
		assertNotNull(j);
	}

}
