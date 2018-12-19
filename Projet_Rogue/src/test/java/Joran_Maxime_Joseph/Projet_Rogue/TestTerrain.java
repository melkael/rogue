package Joran_Maxime_Joseph.Projet_Rogue;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Joran_Maxime_Joseph.Projet_Rogue.Creature.Creature;
import Joran_Maxime_Joseph.Projet_Rogue.Creature.Gobelin;
import Joran_Maxime_Joseph.Projet_Rogue.Creature.Joueur;
import Joran_Maxime_Joseph.Projet_Rogue.Objet.Epee;

/**
 * TestTerrain est une classe de test pour tester les méthodes de la classe Terrain
 * 
 * @author Joran_Maxime_Joseph
 * @version 1.0
 */
public class TestTerrain {

	/**
	 * TestInstanceTerrain() qui teste si le Terrain est bien créer
	 */
	@Test
	public void TestInstanceTerrain() 
	{
		Joueur j = new Joueur("Jojo", 5, 5, 10, 5, 1, 0,100);
		Epee epee = new Epee("Excalibur", "t", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		
		Terrain t= new Terrain(10, j, ennemis,epee);
		
		assertNotNull(t);
	}
	
	/**
	 * TestEnnemiLegal() qui teste si un ennemi peut se positionner
	 */
	@Test
	public void TestEnnemiLegal() 
	{
		Joueur j = new Joueur("Jojo", 5, 5, 10, 5, 1, 0,100);
		Gobelin g = new Gobelin("Gobelin Jojo", 5, 3, 10, 5);
		Epee epee = new Epee("Excalibur", "t", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		ennemis.add(g);
		
		Terrain t= new Terrain(10, j, ennemis,epee);
		
		assertTrue(t.EnnemiEstLegal(7,3));
	}
	
	/**
	 * TestEnnemiLegal() qui teste si un ennemi ne peut se positionner
	 */
	@Test
	public void TestEnnemiPasLegal() 
	{
		Joueur j = new Joueur("Jojo", 5, 5, 10, 5, 1, 0,100);
		Gobelin g = new Gobelin("Gobelin Jojo", 5, 3, 10, 5);
		Epee epee = new Epee("Excalibur", "t", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		ennemis.add(g);
		
		Terrain t= new Terrain(10, j, ennemis,epee);
		
		assertFalse(t.EnnemiEstLegal(5,3));
	}
	
	/**
	 * TestTailleTerrain() qui teste la taille du Terrain
	 */
	@Test
	public void TestTailleTerrain() 
	{
		Joueur j = new Joueur("Jojo", 5, 5, 10, 5, 1, 0,100);
		Gobelin g = new Gobelin("Gobelin Jojo", 5, 3, 10, 5);
		Epee epee = new Epee("Excalibur", "t", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		ennemis.add(g);
		
		Terrain t= new Terrain(10, j, ennemis,epee);
		
		assertEquals(10,t.getTaille());
	}
	
	/**
	 * TestTailleNegativeTerrain() qui teste l'envoie d'une exception si taille negative
	 */
	@Test
	public void TestTailleNegativeTerrain() 
	{
		Joueur j = new Joueur("Jojo", 5, 5, 10, 5, 1, 0,100);
		Gobelin g = new Gobelin("Gobelin Jojo", 5, 3, 10, 5);
		Epee epee = new Epee("Excalibur", "t", 10, 8, 8);
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

