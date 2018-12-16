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
	public void TestDeplaceHaut()  throws ExceptionDeplacementIllegal,ExceptionMarcheSurObjet, ExceptionOuvrePorte
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
		catch(ExceptionMarcheSurObjet e)
		{
			assertTrue(e.getMessage().equals("Marche sur un objet"));
		}
		catch(ExceptionOuvrePorte e)
		{
			assertTrue(e.getMessage().equals("Vous ouvrez une porte !"));
		}
	}
	
	@Test
	public void TestDeplaceBas() throws ExceptionDeplacementIllegal,ExceptionMarcheSurObjet, ExceptionOuvrePorte
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
		catch(ExceptionMarcheSurObjet e)
		{
			assertTrue(e.getMessage().equals("Marche sur un objet"));
		}
		catch(ExceptionOuvrePorte e)
		{
			assertTrue(e.getMessage().equals("Vous ouvrez une porte !"));
		}
	}

	@Test
	public void TestDeplaceGauche() throws ExceptionDeplacementIllegal,ExceptionMarcheSurObjet, ExceptionOuvrePorte
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
		catch(ExceptionMarcheSurObjet e)
		{
			assertTrue(e.getMessage().equals("Marche sur un objet"));
		}
		catch(ExceptionOuvrePorte e)
		{
			assertTrue(e.getMessage().equals("Vous ouvrez une porte !"));
		}
	}
	
	@Test
	public void TestDeplaceDroite() throws ExceptionDeplacementIllegal,ExceptionMarcheSurObjet, ExceptionOuvrePorte
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
		catch(ExceptionMarcheSurObjet e)
		{
			assertTrue(e.getMessage().equals("Marche sur un objet"));
		}
		catch(ExceptionOuvrePorte e)
		{
			assertTrue(e.getMessage().equals("Vous ouvrez une porte !"));
		}
	}
	
	@Test
	public void TestAtqHautJoueur()  throws ExceptionAttaqueImpossible
	{
		Actions h = Actions.HAUT;
		Joueur j = new Joueur("Jojo", 5, 5, 1, 10, 5, 1, 0);
		Epee epee = new Epee("Excaliburne", "t", 10, 8, 8);
		Gobelin g1 = new Gobelin("Gobelin Jamel", 4, 5, 1, 10, 5);
    	ArrayList<Creature> ennemis = new ArrayList<Creature>();
    	ennemis.add(g1);
		Terrain t = new Terrain(10, j, ennemis,epee);
		
		
		try
		{
			h.attaque(j, t);
			assertEquals(5,g1.pv);
			
		}
		catch(ExceptionAttaqueImpossible e)
		{
			assertTrue(e.getMessage().equals("Attaque impossible !!"));
		}
		
	}
	
	@Test
	public void TestAtqBasJoueur()  throws ExceptionAttaqueImpossible
	{
		Actions b = Actions.BAS;
		Joueur j = new Joueur("Jojo", 5, 5, 1, 10, 5, 1, 0);
		Epee epee = new Epee("Excaliburne", "t", 10, 8, 8);
		Gobelin g1 = new Gobelin("Gobelin Jamel", 6, 5, 1, 10, 5);
    	ArrayList<Creature> ennemis = new ArrayList<Creature>();
    	ennemis.add(g1);
		Terrain t = new Terrain(10, j, ennemis,epee);
		
		
		try
		{
			b.attaque(j, t);
			assertEquals(5,g1.pv);
			
		}
		catch(ExceptionAttaqueImpossible e)
		{
			assertTrue(e.getMessage().equals("Attaque impossible !!"));
		}
		
	}
	
	@Test
	public void TestAtqDroiteJoueur()  throws ExceptionAttaqueImpossible
	{
		Actions d = Actions.DROITE;
		Joueur j = new Joueur("Jojo", 5, 5, 1, 10, 5, 1, 0);
		Epee epee = new Epee("Excaliburne", "t", 10, 8, 8);
		Gobelin g1 = new Gobelin("Gobelin Jamel", 5, 6, 1, 10, 5);
    	ArrayList<Creature> ennemis = new ArrayList<Creature>();
    	ennemis.add(g1);
		Terrain t = new Terrain(10, j, ennemis,epee);
		
		
		try
		{
			d.attaque(j, t);
			assertEquals(5,g1.pv);
			
		}
		catch(ExceptionAttaqueImpossible e)
		{
			assertTrue(e.getMessage().equals("Attaque impossible !!"));
		}
		
	}
	
	@Test
	public void TestAtqGaucheJoueur()  throws ExceptionAttaqueImpossible
	{
		Actions g = Actions.GAUCHE;
		Joueur j = new Joueur("Jojo", 5, 5, 1, 10, 5, 1, 0);
		Epee epee = new Epee("Excaliburne", "t", 10, 8, 8);
		Gobelin g1 = new Gobelin("Gobelin Jamel", 5, 4, 1, 10, 5);
    	ArrayList<Creature> ennemis = new ArrayList<Creature>();
    	ennemis.add(g1);
		Terrain t = new Terrain(10, j, ennemis,epee);
		
		
		try
		{
			g.attaque(j, t);
			assertEquals(5,g1.pv);
			
		}
		catch(ExceptionAttaqueImpossible e)
		{
			assertTrue(e.getMessage().equals("Attaque impossible !!"));
		}
		
	}
	
	@Test
	public void TestAtqHautGobelin()  throws ExceptionAttaqueImpossible
	{
		Actions h = Actions.HAUT;
		Joueur j = new Joueur("Jojo", 5, 5, 1, 10, 5, 1, 0);
		Epee epee = new Epee("Excaliburne", "t", 10, 8, 8);
		Gobelin g1 = new Gobelin("Gobelin Jamel", 6, 5, 1, 10, 5);
    	ArrayList<Creature> ennemis = new ArrayList<Creature>();
    	ennemis.add(g1);
		Terrain t = new Terrain(10, j, ennemis,epee);
		
		
		try
		{
			h.attaque(g1, t);
			assertEquals(5,j.pv);
			
		}
		catch(ExceptionAttaqueImpossible e)
		{
			assertTrue(e.getMessage().equals("Attaque impossible !!"));
		}
	}
	
	@Test
	public void TestAtqBasGobelin()  throws ExceptionAttaqueImpossible
	{
		Actions b = Actions.BAS;
		Joueur j = new Joueur("Jojo", 7, 5, 1, 10, 5, 1, 0);
		Epee epee = new Epee("Excaliburne", "t", 10, 8, 8);
		Gobelin g1 = new Gobelin("Gobelin Jamel", 6, 5, 1, 10, 5);
    	ArrayList<Creature> ennemis = new ArrayList<Creature>();
    	ennemis.add(g1);
		Terrain t = new Terrain(10, j, ennemis,epee);
		
		
		try
		{
			b.attaque(g1, t);
			assertEquals(5,j.pv);
			
		}
		catch(ExceptionAttaqueImpossible e)
		{
			assertTrue(e.getMessage().equals("Attaque impossible !!"));
		}
	}
	
	@Test
	public void TestAtqGaucheGobelin()  throws ExceptionAttaqueImpossible
	{
		Actions g = Actions.GAUCHE;
		Joueur j = new Joueur("Jojo", 6, 4, 1, 10, 5, 1, 0);
		Epee epee = new Epee("Excaliburne", "t", 10, 8, 8);
		Gobelin g1 = new Gobelin("Gobelin Jamel", 6, 5, 1, 10, 5);
    	ArrayList<Creature> ennemis = new ArrayList<Creature>();
    	ennemis.add(g1);
		Terrain t = new Terrain(10, j, ennemis,epee);
		
		
		try
		{
			g.attaque(g1, t);
			assertEquals(5,j.pv);
			
		}
		catch(ExceptionAttaqueImpossible e)
		{
			assertTrue(e.getMessage().equals("Attaque impossible !!"));
		}
	}
	
	@Test
	public void TestAtqDroiteGobelin()  throws ExceptionAttaqueImpossible
	{
		Actions d = Actions.DROITE;
		Joueur j = new Joueur("Jojo", 6, 6, 1, 10, 5, 1, 0);
		Epee epee = new Epee("Excaliburne", "t", 10, 8, 8);
		Gobelin g1 = new Gobelin("Gobelin Jamel", 6, 5, 1, 10, 5);
    	ArrayList<Creature> ennemis = new ArrayList<Creature>();
    	ennemis.add(g1);
		Terrain t = new Terrain(10, j, ennemis,epee);
		
		
		try
		{
			d.attaque(g1, t);
			assertEquals(5,j.pv);
			
		}
		catch(ExceptionAttaqueImpossible e)
		{
			assertTrue(e.getMessage().equals("Attaque impossible !!"));
		}
	}
}
