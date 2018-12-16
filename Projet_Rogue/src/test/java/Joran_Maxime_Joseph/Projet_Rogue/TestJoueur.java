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

	@Test
	public void TestRamasseEpee() 
	{
		Joueur j = new Joueur("Maxou", 5, 5, 1, 10, 5, 1, 0);
		Epee epee = new Epee("Excaliburne", "T", 10, 8, 8);
		j.ramasserEpee(epee);
		
		assertEquals(15,j.degat);
	}
	
	@Test
	public void TestVivantJoueur() 
	{
		Joueur j = new Joueur("Maxou", 5, 5, 1, 10, 5, 1, 0);
			
		assertTrue(j.estVivant());
	}
	
	@Test
	public void TestMortJoueur() 
	{
		Joueur j = new Joueur("Maxou", 5, 5, 1, 0, 5, 1, 0);
		
		assertFalse(j.estVivant());
	}

}
