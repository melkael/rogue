package Joran_Maxime_Joseph.Projet_Rogue;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Joran_Maxime_Joseph.Projet_Rogue.Creature.Creature;
import Joran_Maxime_Joseph.Projet_Rogue.Creature.Gobelin;
import Joran_Maxime_Joseph.Projet_Rogue.Creature.Joueur;
import Joran_Maxime_Joseph.Projet_Rogue.Objet.Epee;

public class TestTerrain {

	@Test
	public void TestInstanceTerrain() 
	{
		Joueur j = new Joueur("Jojo", 5, 5, 1, 10, 5, 1, 0);
		Epee epee = new Epee("Excaliburne", "t", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		
		Terrain t= new Terrain(10, j, ennemis,epee);
		
		assertNotNull(t);
	}
	
	@Test
	public void TestEnnemiLegal() 
	{
		Joueur j = new Joueur("Jojo", 5, 5, 1, 10, 5, 1, 0);
		Gobelin g = new Gobelin("Gobelin Jojo", 5, 3, 1, 10, 5);
		Epee epee = new Epee("Excaliburne", "t", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		ennemis.add(g);
		
		Terrain t= new Terrain(10, j, ennemis,epee);
		
		assertTrue(t.EnnemiEstLegal(7,3));
	}
	
	@Test
	public void TestEnnemiPasLegal() 
	{
		Joueur j = new Joueur("Jojo", 5, 5, 1, 10, 5, 1, 0);
		Gobelin g = new Gobelin("Gobelin Jojo", 5, 3, 1, 10, 5);
		Epee epee = new Epee("Excaliburne", "t", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		ennemis.add(g);
		
		Terrain t= new Terrain(10, j, ennemis,epee);
		
		assertFalse(t.EnnemiEstLegal(5,3));
	}
	
	@Test
	public void TestTailleTerrain() 
	{
		Joueur j = new Joueur("Jojo", 5, 5, 1, 10, 5, 1, 0);
		Gobelin g = new Gobelin("Gobelin Jojo", 5, 3, 1, 10, 5);
		Epee epee = new Epee("Excaliburne", "t", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		ennemis.add(g);
		
		Terrain t= new Terrain(10, j, ennemis,epee);
		
		assertEquals(10,t.getTaille());
	}
	
	@Test
	public void TestTailleNegativeTerrain() 
	{
		Joueur j = new Joueur("Jojo", 5, 5, 1, 10, 5, 1, 0);
		Gobelin g = new Gobelin("Gobelin Jojo", 5, 3, 1, 10, 5);
		Epee epee = new Epee("Excaliburne", "t", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		ennemis.add(g);
		
		try
		{
			Terrain t= new Terrain(-1, j, ennemis,epee);
		}
		catch(NegativeArraySizeException e)
		{
			System.out.print(e.getMessage());
		}
	}
}

