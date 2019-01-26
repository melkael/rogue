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

/**
 * TestJoueur est une classe de test pour tester les méthodes de la classe Joueur
 * 
 * @author Joran_Maxime_Joseph
 * @version 1.0
 */
public class TestJoueur {

	/**
	 * TestInstanceJoueur() qui teste la creation de Joueur
	 */
	@Test
	public void TestInstanceJoueur() 
	{
		Joueur j = new Joueur("Maxou", 5, 5, 10, 5, 100);
		assertNotNull(j);
	}

	/**
	 * TestRamasseEpee qui teste que le joueur ramasse bien une epee
	 */
	@Test
	public void TestRamasseEpee() 
	{
		Joueur j = new Joueur("Maxou", 5, 5, 10, 5, 100);
		Epee epee = new Epee("Excalibur", "T", 10, 8, 8);
		j.ramasserEpee(epee);
		
		assertEquals(15,j.getDegat());
	}
	
	/**
	 * TestVivantJoueur() qui teste si le joueur est vivant
	 */
	@Test
	public void TestVivantJoueur() 
	{
		Joueur j = new Joueur("Maxou", 5, 5, 10, 5, 100);
			
		assertTrue(j.estVivant());
	}
	
	/**
	 * TestMortJoueur() qui teste si le joueur est mort
	 */
	@Test
	public void TestMortJoueur() 
	{
		Joueur j = new Joueur("Maxou", 5, 5, 0, 5, 100);
		
		assertFalse(j.estVivant());
	}

	/**
	 * TestSeDeplaceHaut() qui teste si le joueur  se deplace bien en haut avec les exceptions
	 */
	@Test
	public void TestSeDeplaceHaut() throws ExceptionDeplacementIllegal, ExceptionMarcheSurObjet, ExceptionOuvrePorte
	{
		Joueur j = new Joueur("Maxou", 5, 5, 0, 5, 100);
		Epee epee = new Epee("Excalibur", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		try 
		{
			j.sedeplacer(Actions.HAUT, t);
		
			assertEquals(4,j.getX());
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
	
	/**
	 * TestSeDeplaceBas() qui teste si le joueur  se deplace bien en bas avec les exceptions
	 */
	@Test
	public void TestSeDeplaceBas() throws ExceptionDeplacementIllegal, ExceptionMarcheSurObjet, ExceptionOuvrePorte
	{
		Joueur j = new Joueur("Maxou", 5, 5, 0, 5, 100);
		Epee epee = new Epee("Excalibur", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		try 
		{
			j.sedeplacer(Actions.BAS, t);
		
			assertEquals(6,j.getX());
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
	
	/**
	 * TestSeDeplaceGauche() qui teste si le joueur  se deplace bien à gauche avec les exceptions
	 */
	@Test
	public void TestSeDeplaceGauche() throws ExceptionDeplacementIllegal, ExceptionMarcheSurObjet, ExceptionOuvrePorte
	{
		Joueur j = new Joueur("Maxou", 5, 5, 0, 5, 100);
		Epee epee = new Epee("Excalibur", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		try 
		{
			j.sedeplacer(Actions.GAUCHE, t);
		
			assertEquals(4,j.getY());
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
	
	/**
	 * TestSeDeplaceDroite() qui teste si le joueur  se deplace bien à droite avec les exceptions
	 */
	@Test
	public void TestSeDeplaceDroite() throws ExceptionDeplacementIllegal, ExceptionMarcheSurObjet, ExceptionOuvrePorte
	{
		Joueur j = new Joueur("Maxou", 5, 5, 0, 5, 100);
		Epee epee = new Epee("Excalibur", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		try 
		{
			j.sedeplacer(Actions.DROITE, t);
		
			assertEquals(6,j.getY());
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
	
	/**
	 * TestAtqHaut() qui teste si le joueur  attaque bien en haut avec les exceptions
	 */
	@Test
	public void TestAtqHaut() throws ExceptionAttaqueImpossible
	{
		Joueur j = new Joueur("Maxou", 5, 5, 10, 5, 100);
		Gobelin g = new Gobelin("Gobelin Jojo", 4, 5, 10, 5);
		Epee epee = new Epee("Excalibur", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		ennemis.add(g);
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		try
		{
			j.attaquer(Actions.HAUT, t);
			assertEquals(5,g.getPv());
		}
		catch(ExceptionAttaqueImpossible e)
		{
			assertTrue(e.getMessage().equals("Attaque impossible !!"));
		}
	}
	
	/**
	 * TestAtqBas() qui teste si le joueur  attaque bien en bas avec les exceptions
	 */
	@Test
	public void TestAtqBas() throws ExceptionAttaqueImpossible
	{
		Joueur j = new Joueur("Maxou", 5, 5, 10, 5, 100);
		Gobelin g = new Gobelin("Gobelin Jojo", 6, 5, 10, 5);
		Epee epee = new Epee("Excalibur", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		ennemis.add(g);
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		try
		{
			j.attaquer(Actions.BAS, t);
			assertEquals(5,g.getPv());
		}
		catch(ExceptionAttaqueImpossible e)
		{
			assertTrue(e.getMessage().equals("Attaque impossible !!"));
		}
	}
	
	/**
	 * TestAtqGauche() qui teste si le joueur  attaque bien à gauche avec les exceptions
	 */
	@Test
	public void TestAtqGauche() throws ExceptionAttaqueImpossible
	{
		Joueur j = new Joueur("Maxou", 5, 5, 10, 5, 100);
		Gobelin g = new Gobelin("Gobelin Jojo", 5, 4, 10, 5);
		Epee epee = new Epee("Excalibur", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		ennemis.add(g);
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		try
		{
			j.attaquer(Actions.GAUCHE, t);
			assertEquals(5,g.getPv());
		}
		catch(ExceptionAttaqueImpossible e)
		{
			assertTrue(e.getMessage().equals("Attaque impossible !!"));
		}
	}
	
	/**
	 * TestAtqDroite() qui teste si le joueur  attaque bien à droite avec les exceptions
	 */
	@Test
	public void TestAtqDroite() throws ExceptionAttaqueImpossible
	{
		Joueur j = new Joueur("Maxou", 5, 5, 10, 5, 100);
		Gobelin g = new Gobelin("Gobelin Jojo", 5, 6, 10, 5);
		Epee epee = new Epee("Excalibur", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		ennemis.add(g);
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		try
		{
			j.attaquer(Actions.DROITE, t);
			assertEquals(5,g.getPv());
		}
		catch(ExceptionAttaqueImpossible e)
		{
			assertTrue(e.getMessage().equals("Attaque impossible !!"));
		}
	}
	
	/**
	 * TestClosePlayer() qui teste si le joueur  ne peut pas etre a cote d'un autre joueur
	 */
	@Test
	public void TestClosePlayer()
	{
		Joueur j = new Joueur("Maxou", 5, 5, 10, 5, 100);
		Epee epee = new Epee("Excalibur", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		assertEquals(-1,j.close_to_player(t));
	}
}
