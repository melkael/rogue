package Joran_Maxime_Joseph.Projet_Rogue;

import static org.junit.Assert.*;

import java.util.ArrayList;

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

	@Test
	public void TestSeDeplaceHaut() throws ExceptionDeplacementIllegal, ExceptionMarcheSurObjet, ExceptionOuvrePorte
	{
		Joueur j = new Joueur("Maxou", 5, 5, 1, 0, 5, 1, 0);
		Epee epee = new Epee("Excaliburne", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		try 
		{
			j.sedeplacer(Actions.HAUT, t);
		
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
	public void TestSeDeplaceBas() throws ExceptionDeplacementIllegal, ExceptionMarcheSurObjet, ExceptionOuvrePorte
	{
		Joueur j = new Joueur("Maxou", 5, 5, 1, 0, 5, 1, 0);
		Epee epee = new Epee("Excaliburne", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		try 
		{
			j.sedeplacer(Actions.BAS, t);
		
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
	public void TestSeDeplaceGauche() throws ExceptionDeplacementIllegal, ExceptionMarcheSurObjet, ExceptionOuvrePorte
	{
		Joueur j = new Joueur("Maxou", 5, 5, 1, 0, 5, 1, 0);
		Epee epee = new Epee("Excaliburne", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		try 
		{
			j.sedeplacer(Actions.GAUCHE, t);
		
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
	public void TestSeDeplaceDroite() throws ExceptionDeplacementIllegal, ExceptionMarcheSurObjet, ExceptionOuvrePorte
	{
		Joueur j = new Joueur("Maxou", 5, 5, 1, 0, 5, 1, 0);
		Epee epee = new Epee("Excaliburne", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		try 
		{
			j.sedeplacer(Actions.DROITE, t);
		
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
	public void TestAtqHaut() throws ExceptionAttaqueImpossible
	{
		Joueur j = new Joueur("Maxou", 5, 5, 1, 10, 5, 1, 0);
		Gobelin g = new Gobelin("Gobelin Jojo", 4, 5, 1, 10, 5);
		Epee epee = new Epee("Excaliburne", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		ennemis.add(g);
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		try
		{
			j.attaquer(Actions.HAUT, t);
			assertEquals(5,g.pv);
		}
		catch(ExceptionAttaqueImpossible e)
		{
			assertTrue(e.getMessage().equals("Attaque impossible !!"));
		}
	}
	
	@Test
	public void TestAtqBas() throws ExceptionAttaqueImpossible
	{
		Joueur j = new Joueur("Maxou", 5, 5, 1, 10, 5, 1, 0);
		Gobelin g = new Gobelin("Gobelin Jojo", 6, 5, 1, 10, 5);
		Epee epee = new Epee("Excaliburne", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		ennemis.add(g);
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		try
		{
			j.attaquer(Actions.BAS, t);
			assertEquals(5,g.pv);
		}
		catch(ExceptionAttaqueImpossible e)
		{
			assertTrue(e.getMessage().equals("Attaque impossible !!"));
		}
	}
	
	@Test
	public void TestAtqGauche() throws ExceptionAttaqueImpossible
	{
		Joueur j = new Joueur("Maxou", 5, 5, 1, 10, 5, 1, 0);
		Gobelin g = new Gobelin("Gobelin Jojo", 5, 4, 1, 10, 5);
		Epee epee = new Epee("Excaliburne", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		ennemis.add(g);
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		try
		{
			j.attaquer(Actions.GAUCHE, t);
			assertEquals(5,g.pv);
		}
		catch(ExceptionAttaqueImpossible e)
		{
			assertTrue(e.getMessage().equals("Attaque impossible !!"));
		}
	}
	
	@Test
	public void TestAtqDroite() throws ExceptionAttaqueImpossible
	{
		Joueur j = new Joueur("Maxou", 5, 5, 1, 10, 5, 1, 0);
		Gobelin g = new Gobelin("Gobelin Jojo", 5, 6, 1, 10, 5);
		Epee epee = new Epee("Excaliburne", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		ennemis.add(g);
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		try
		{
			j.attaquer(Actions.DROITE, t);
			assertEquals(5,g.pv);
		}
		catch(ExceptionAttaqueImpossible e)
		{
			assertTrue(e.getMessage().equals("Attaque impossible !!"));
		}
	}
	
	@Test
	public void TestClosePlayer()
	{
		Joueur j = new Joueur("Maxou", 5, 5, 1, 10, 5, 1, 0);
		Epee epee = new Epee("Excaliburne", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		assertEquals(-1,j.close_to_player(t));
	}
}
