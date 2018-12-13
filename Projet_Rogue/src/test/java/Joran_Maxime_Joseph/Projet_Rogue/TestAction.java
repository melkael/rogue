package Joran_Maxime_Joseph.Projet_Rogue;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestAction {

	@Test
	public void TestInstanceHaut() 
	{
		Actions h = Actions.HAUT;
		assertNotNull(h);
	}
	
	@Test
	public void TestInstanceBas() 
	{
		Actions b = Actions.BAS;
		assertNotNull(b);
	}
	
	@Test
	public void TestInstanceGauche() 
	{
		Actions g = Actions.GAUCHE;
		assertNotNull(g);
	}
	
	@Test
	public void TestInstanceDroite() 
	{
		Actions d = Actions.DROITE;
		assertNotNull(d);
	}
	
	@Test
	public void TestDeplaceHaut()  throws ExceptionDeplacementIllegal
	{
		Actions h = Actions.HAUT;
		Joueur j = new Joueur("Jojo", 5, 5, 1, 10, 5, 1, 0);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		Terrain t = new Terrain(10, j, ennemis);
		
		
		try
		{
			h.deplace(j, t);
			assertEquals(4,j.x);
		}
		catch(ExceptionDeplacementIllegal e)
		{
			assertTrue(e.getMessage().equals("Deplacement Illegal"));
		}
	}
	
	@Test
	public void TestDeplaceBas() throws ExceptionDeplacementIllegal
	{
		Actions b = Actions.BAS;
		Joueur j = new Joueur("Jojo", 5, 5, 1, 10, 5, 1, 0);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		Terrain t = new Terrain(10, j, ennemis);
		
		
		try
		{
			b.deplace(j, t);
			assertEquals(6,j.x);
		}
		catch(ExceptionDeplacementIllegal e)
		{
			assertTrue(e.getMessage().equals("Deplacement Illegal"));
		}
	}

	@Test
	public void TestDeplaceGauche() throws ExceptionDeplacementIllegal
	{
		Actions g = Actions.GAUCHE;
		Joueur j = new Joueur("Jojo", 5, 5, 1, 10, 5, 1, 0);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		Terrain t = new Terrain(10, j, ennemis);
		
		
		try 
		{
			g.deplace(j, t);
			assertEquals(4,j.y);
		}
		catch(ExceptionDeplacementIllegal e)
		{
			assertTrue(e.getMessage().equals("Deplacement Illegal"));
		}
	}
	
	@Test
	public void TestDeplaceDroite() throws ExceptionDeplacementIllegal
	{
		Actions d = Actions.DROITE;
		Joueur j = new Joueur("Jojo", 5, 5, 1, 10, 5, 1, 0);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		Terrain t = new Terrain(10, j, ennemis);
		
		
		try 
		{
			d.deplace(j, t);
			assertEquals(6,j.y);
		}
		catch(ExceptionDeplacementIllegal e)
		{
			assertTrue(e.getMessage().equals("Deplacement Illegal"));
		}
		
	}
}
