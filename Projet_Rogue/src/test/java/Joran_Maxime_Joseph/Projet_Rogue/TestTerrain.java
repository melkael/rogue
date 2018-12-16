package Joran_Maxime_Joseph.Projet_Rogue;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

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
}

