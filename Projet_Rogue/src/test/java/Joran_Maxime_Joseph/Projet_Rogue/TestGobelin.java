package Joran_Maxime_Joseph.Projet_Rogue;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Joran_Maxime_Joseph.Projet_Rogue.Creature.Creature;
import Joran_Maxime_Joseph.Projet_Rogue.Creature.Gobelin;
import Joran_Maxime_Joseph.Projet_Rogue.Creature.Joueur;
import Joran_Maxime_Joseph.Projet_Rogue.Exception.ExceptionAttaqueImpossible;
import Joran_Maxime_Joseph.Projet_Rogue.Exception.ExceptionDeplacementIllegal;
import Joran_Maxime_Joseph.Projet_Rogue.Exception.ExceptionMarcheSurObjet;
import Joran_Maxime_Joseph.Projet_Rogue.Exception.ExceptionOuvrePorte;
import Joran_Maxime_Joseph.Projet_Rogue.Objet.Epee;

public class TestGobelin {

	@Test
	public void TestInstanceGobelin() 
	{
		Gobelin g = new Gobelin("Gobelin Jojo", 5, 3,  10, 5);
		assertNotNull(g);
	}
	
	@Test
	public void TestVivantGobelin() 
	{
		Gobelin g = new Gobelin("Gobelin Jojo", 5, 3,  10, 5);
		
		assertTrue(g.estVivant());
	}
	
	@Test
	public void TestMortGobelin() 
	{
		Gobelin g = new Gobelin("Gobelin Jojo", 5, 3,  0, 5);
		
		assertFalse(g.estVivant());
	}
	
	@Test
	public void TestSeDeplaceHaut() throws ExceptionDeplacementIllegal, ExceptionMarcheSurObjet, ExceptionOuvrePorte
	{
		Joueur j = new Joueur("Maxou", 5, 5,  0, 5, 1, 0);
		Gobelin g = new Gobelin("Gobelin Jojo", 5, 3,  10, 5);
		Epee epee = new Epee("Excalibur", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		try 
		{
			g.sedeplacer(Actions.HAUT, t);
		
			assertEquals(4,g.getX());
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
		Joueur j = new Joueur("Maxou", 5, 5, 0, 5, 1, 0);
		Gobelin g = new Gobelin("Gobelin Jojo", 5, 3, 10, 5);
		Epee epee = new Epee("Excalibur", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		try 
		{
			g.sedeplacer(Actions.BAS, t);
		
			assertEquals(6,g.getX());
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
		Joueur j = new Joueur("Maxou", 5, 5, 0, 5, 1, 0);
		Gobelin g = new Gobelin("Gobelin Jojo", 5, 3, 10, 5);
		Epee epee = new Epee("Excalibur", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		try 
		{
			g.sedeplacer(Actions.GAUCHE, t);
		
			assertEquals(2,g.getY());
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
		Joueur j = new Joueur("Maxou", 5, 5, 0, 5, 1, 0);
		Gobelin g = new Gobelin("Gobelin Jojo", 5, 3, 10, 5);
		Epee epee = new Epee("Excalibur", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		try 
		{
			g.sedeplacer(Actions.DROITE, t);
		
			assertEquals(4,g.getY());
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
		Joueur j = new Joueur("Maxou", 3, 5, 10, 5, 1, 0);
		Gobelin g = new Gobelin("Gobelin Jojo", 4, 5, 10, 5);
		Epee epee = new Epee("Excalibur", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		ennemis.add(g);
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		try
		{
			g.attaquer(Actions.HAUT, t);
			assertEquals(5,j.getPv());
		}
		catch(ExceptionAttaqueImpossible e)
		{
			assertTrue(e.getMessage().equals("Attaque impossible !!"));
		}
	}
	
	@Test
	public void TestAtqBas() throws ExceptionAttaqueImpossible
	{
		Joueur j = new Joueur("Maxou", 5, 5, 10, 5, 1, 0);
		Gobelin g = new Gobelin("Gobelin Jojo", 4, 5, 10, 5);
		Epee epee = new Epee("Excalibur", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		ennemis.add(g);
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		try
		{
			g.attaquer(Actions.BAS, t);
			assertEquals(5,j.getPv());
		}
		catch(ExceptionAttaqueImpossible e)
		{
			assertTrue(e.getMessage().equals("Attaque impossible !!"));
		}
	}
	
	@Test
	public void TestAtqGauche() throws ExceptionAttaqueImpossible
	{
		Joueur j = new Joueur("Maxou", 4, 4, 10, 5, 1, 0);
		Gobelin g = new Gobelin("Gobelin Jojo", 4, 5, 10, 5);
		Epee epee = new Epee("Excalibur", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		ennemis.add(g);
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		try
		{
			g.attaquer(Actions.GAUCHE, t);
			assertEquals(5,j.getPv());
		}
		catch(ExceptionAttaqueImpossible e)
		{
			assertTrue(e.getMessage().equals("Attaque impossible !!"));
		}
	}
	
	@Test
	public void TestAtqDroite() throws ExceptionAttaqueImpossible
	{
		Joueur j = new Joueur("Maxou", 4, 6, 10, 5, 1, 0);
		Gobelin g = new Gobelin("Gobelin Jojo", 4, 5, 10, 5);
		Epee epee = new Epee("Excalibur", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		ennemis.add(g);
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		try
		{
			g.attaquer(Actions.DROITE, t);
			assertEquals(5,j.getPv());
		}
		catch(ExceptionAttaqueImpossible e)
		{
			assertTrue(e.getMessage().equals("Attaque impossible !!"));
		}
	}
	
	@Test
	public void TestClosePlayerHaut()
	{
		Joueur j = new Joueur("Maxou", 3, 5, 10, 5, 1, 0);
		Gobelin g = new Gobelin("Gobelin Jojo", 4, 5, 10, 5);
		Epee epee = new Epee("Excalibur", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		ennemis.add(g);
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		assertEquals(2,g.close_to_player(t));
	}
	
	@Test
	public void TestClosePlayerBas()
	{
		Joueur j = new Joueur("Maxou", 5, 5, 10, 5, 1, 0);
		Gobelin g = new Gobelin("Gobelin Jojo", 4, 5, 10, 5);
		Epee epee = new Epee("Excalibur", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		ennemis.add(g);
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		assertEquals(1,g.close_to_player(t));
	}
	
	@Test
	public void TestClosePlayerGauche()
	{
		Joueur j = new Joueur("Maxou", 4, 4, 10, 5, 1, 0);
		Gobelin g = new Gobelin("Gobelin Jojo", 4, 5, 10, 5);
		Epee epee = new Epee("Excalibur", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		ennemis.add(g);
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		assertEquals(4,g.close_to_player(t));
	}
	
	@Test
	public void TestClosePlayerDroite()
	{
		Joueur j = new Joueur("Maxou", 4, 6, 10, 5, 1, 0);
		Gobelin g = new Gobelin("Gobelin Jojo", 4, 5, 10, 5);
		Epee epee = new Epee("Excalibur", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		ennemis.add(g);
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		assertEquals(3,g.close_to_player(t));
	}

	@Test
	public void TestIAHaut() throws ExceptionDeplacementIllegal, ExceptionMarcheSurObjet,ExceptionAttaqueImpossible, ExceptionOuvrePorte
	{
		Joueur j = new Joueur("Maxou", 3, 5, 10, 5, 1, 0);
		Gobelin g = new Gobelin("Gobelin Jojo", 4, 5, 10, 5);
		Epee epee = new Epee("Excalibur", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		ennemis.add(g);
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		try
		{
			g.IA(t);
			assertEquals(5,j.getPv());
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
		catch(ExceptionAttaqueImpossible e)
		{
			assertTrue(e.getMessage().equals("Attaque impossible !!"));
		}
	}
	
	@Test
	public void TestIABas() throws ExceptionDeplacementIllegal, ExceptionMarcheSurObjet,ExceptionAttaqueImpossible, ExceptionOuvrePorte
	{
		Joueur j = new Joueur("Maxou", 5, 5, 10, 5, 1, 0);
		Gobelin g = new Gobelin("Gobelin Jojo", 4, 5, 10, 5);
		Epee epee = new Epee("Excalibur", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		ennemis.add(g);
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		try
		{
			g.IA(t);
			assertEquals(5,j.getPv());
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
		catch(ExceptionAttaqueImpossible e)
		{
			assertTrue(e.getMessage().equals("Attaque impossible !!"));
		}
	}
	
	@Test
	public void TestIAGauche() throws ExceptionDeplacementIllegal, ExceptionMarcheSurObjet,ExceptionAttaqueImpossible, ExceptionOuvrePorte
	{
		Joueur j = new Joueur("Maxou", 5, 4, 10, 5, 1, 0);
		Gobelin g = new Gobelin("Gobelin Jojo", 5, 5, 10, 5);
		Epee epee = new Epee("Excalibur", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		ennemis.add(g);
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		try
		{
			g.IA(t);
			assertEquals(5,j.getPv());
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
		catch(ExceptionAttaqueImpossible e)
		{
			assertTrue(e.getMessage().equals("Attaque impossible !!"));
		}
	}
	
	@Test
	public void TestIADroite() throws ExceptionDeplacementIllegal, ExceptionMarcheSurObjet,ExceptionAttaqueImpossible, ExceptionOuvrePorte
	{
		Joueur j = new Joueur("Maxou", 5, 6, 10, 5, 1, 0);
		Gobelin g = new Gobelin("Gobelin Jojo", 5, 5, 10, 5);
		Epee epee = new Epee("Excalibur", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		ennemis.add(g);
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		try
		{
			g.IA(t);
			assertEquals(5,j.getPv());
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
		catch(ExceptionAttaqueImpossible e)
		{
			assertTrue(e.getMessage().equals("Attaque impossible !!"));
		}
	}
	
	@Test
	public void TestIADefault() throws ExceptionDeplacementIllegal, ExceptionMarcheSurObjet,ExceptionAttaqueImpossible, ExceptionOuvrePorte
	{
		Joueur j = new Joueur("Maxou", 7, 7, 10, 5, 1, 0);
		Gobelin g = new Gobelin("Gobelin Jojo", 5, 5, 10, 5);
		Epee epee = new Epee("Excalibur", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		ennemis.add(g);
		Terrain t = new Terrain(10, j, ennemis, epee);
		int test[]=new int[] {g.getX(),g.getY()};
		
		try
		{
			g.IA(t);
			assertNotEquals(new int[] {g.getX(),g.getY()},test);
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
		catch(ExceptionAttaqueImpossible e)
		{
			assertTrue(e.getMessage().equals("Attaque impossible !!"));
		}
	}
}
