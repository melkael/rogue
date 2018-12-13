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
	public void TestDeplaceHaut()  throws ExceptionDeplacementIllegal,ExceptionMarcheSurObjet
	{
		Actions h = Actions.HAUT;
		Joueur j = new Joueur("Jojo", 5, 5, 1, 10, 5, 1, 0);
		Epee epee = new Epee("Excaliburne", "t", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		Terrain t = new Terrain(10, j, ennemis,epee);
		
		
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
	public void TestDeplaceBas() throws ExceptionDeplacementIllegal,ExceptionMarcheSurObjet
	{
		Actions b = Actions.BAS;
		Joueur j = new Joueur("Jojo", 5, 5, 1, 10, 5, 1, 0);
		Epee epee = new Epee("Excaliburne", "t", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		Terrain t = new Terrain(10, j, ennemis,epee);
		
		
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
	public void TestDeplaceGauche() throws ExceptionDeplacementIllegal,ExceptionMarcheSurObjet
	{
		Actions g = Actions.GAUCHE;
		Joueur j = new Joueur("Jojo", 5, 5, 1, 10, 5, 1, 0);
		Epee epee = new Epee("Excaliburne", "t", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		Terrain t = new Terrain(10, j, ennemis,epee);
		
		
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
	public void TestDeplaceDroite() throws ExceptionDeplacementIllegal,ExceptionMarcheSurObjet
	{
		Actions d = Actions.DROITE;
		Joueur j = new Joueur("Jojo", 5, 5, 1, 10, 5, 1, 0);
		Epee epee = new Epee("Excaliburne", "t", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		Terrain t = new Terrain(10, j, ennemis,epee);
		
		
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
