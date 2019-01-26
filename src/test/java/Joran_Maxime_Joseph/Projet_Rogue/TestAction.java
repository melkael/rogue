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
 * TestAction est une classe de test pour tester les méthodes de la classe Action
 * 
 * @author Joran_Maxime_Joseph
 * @version 1.0
 */
public class TestAction {

	/**
	 * TestInstanceHaut() qui teste la creation de HAUT
	 */
	@Test
	public void TestInstanceHaut() 
	{
		Actions h = Actions.HAUT;
		assertNotNull(h);
	}
	
	/**
	 * TestInstanceBas() qui teste la creation de BAS
	 */
	@Test
	public void TestInstanceBas() 
	{
		Actions b = Actions.BAS;
		assertNotNull(b);
	}
	
	/**
	 * TestInstanceGauche() qui teste la creation de GAUCHE
	 */
	@Test
	public void TestInstanceGauche() 
	{
		Actions g = Actions.GAUCHE;
		assertNotNull(g);
	}
	
	/**
	 * TestInstanceDroite() qui teste la creation de DROITE
	 */
	@Test
	public void TestInstanceDroite() 
	{
		Actions d = Actions.DROITE;
		assertNotNull(d);
	}
	
	/**
	 * TestDeplaceHautJoueur() qui teste si le personnage peut se deplacer en haut avec les exceptions
	 */
	@Test
	public void TestDeplaceHautJoueur()  throws ExceptionDeplacementIllegal,ExceptionMarcheSurObjet, ExceptionOuvrePorte
	{
		Actions h = Actions.HAUT;
		Joueur j = new Joueur("Jojo", 5, 5,10, 5,100);
		Epee epee = new Epee("Excalibur", "t", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		Terrain t = new Terrain(10, j, ennemis,epee);
		
		
		try
		{
			h.deplace(j, t);
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
	 * TestDeplaceBasJoueur() qui teste si le personnage peut se deplacer en bas avec les exceptions
	 */
	@Test
	public void TestDeplaceBasJoueur() throws ExceptionDeplacementIllegal,ExceptionMarcheSurObjet, ExceptionOuvrePorte
	{
		Actions b = Actions.BAS;
		Joueur j = new Joueur("Jojo", 5, 5, 10, 5,100);
		Epee epee = new Epee("Excalibur", "t", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		Terrain t = new Terrain(10, j, ennemis,epee);
		
		
		try
		{
			b.deplace(j, t);
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
	 * TestDeplaceGaucheJoueur() qui teste si le personnage peut se deplacer à gauche avec les exceptions
	 */
	@Test
	public void TestDeplaceGaucheJoueur() throws ExceptionDeplacementIllegal,ExceptionMarcheSurObjet, ExceptionOuvrePorte
	{
		Actions g = Actions.GAUCHE;
		Joueur j = new Joueur("Jojo", 5, 5, 10, 5,100);
		Epee epee = new Epee("Excalibur", "t", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		Terrain t = new Terrain(10, j, ennemis,epee);
		
		
		try 
		{
			g.deplace(j, t);
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
	 * TestDeplaceDroiteJoueur() qui teste si le personnage peut se deplacer à droite avec les exceptions
	 */
	@Test
	public void TestDeplaceDroiteJoueur() throws ExceptionDeplacementIllegal,ExceptionMarcheSurObjet, ExceptionOuvrePorte
	{
		Actions d = Actions.DROITE;
		Joueur j = new Joueur("Jojo", 5, 5, 10, 5,100);
		Epee epee = new Epee("Excalibur", "t", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		Terrain t = new Terrain(10, j, ennemis,epee);
		
		
		try 
		{
			d.deplace(j, t);
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
	 * TestDeplaceHautGobelin() qui teste si le gobelin peut se deplacer en haut avec les exceptions
	 */
	@Test
	public void TestDeplaceHautGobelin()  throws ExceptionDeplacementIllegal,ExceptionMarcheSurObjet, ExceptionOuvrePorte
	{
		Actions h = Actions.HAUT;
		Joueur j = new Joueur("Jojo", 5, 5,10, 5,100);
		Gobelin g = new Gobelin("Gobelin Jojo", 5, 3,  10, 5);
		Epee epee = new Epee("Excalibur", "t", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		Terrain t = new Terrain(10, j, ennemis,epee);
		
		
		try
		{
			h.deplace(g, t);
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
	
	/**
	 * TestDeplaceBasGobelin() qui teste si le gobelin peut se deplacer en bas avec les exceptions
	 */
	@Test
	public void TestDeplaceBasGobelin() throws ExceptionDeplacementIllegal,ExceptionMarcheSurObjet, ExceptionOuvrePorte
	{
		Actions b = Actions.BAS;
		Joueur j = new Joueur("Jojo", 5, 5, 10, 5,100);
		Gobelin g = new Gobelin("Gobelin Jojo", 5, 3,  10, 5);
		Epee epee = new Epee("Excalibur", "t", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		Terrain t = new Terrain(10, j, ennemis,epee);
		
		
		try
		{
			b.deplace(g, t);
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

	/**
	 * TestDeplaceGaucheGobelin() qui teste si le Gobelin peut se deplacer à gauche avec les exceptions
	 */
	@Test
	public void TestDeplaceGaucheGobelin() throws ExceptionDeplacementIllegal,ExceptionMarcheSurObjet, ExceptionOuvrePorte
	{
		Actions g = Actions.GAUCHE;
		Joueur j = new Joueur("Jojo", 5, 5, 10, 5,100);
		Gobelin gob = new Gobelin("Gobelin Jojo", 5, 3,  10, 5);
		Epee epee = new Epee("Excalibur", "t", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		Terrain t = new Terrain(10, j, ennemis,epee);
		
		
		try 
		{
			g.deplace(gob, t);
			assertEquals(2,gob.getY());
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
	 * TestDeplaceDroiteGobelin() qui teste si le gobelin peut se deplacer à droite avec les exceptions
	 */
	@Test
	public void TestDeplaceDroiteGobelin() throws ExceptionDeplacementIllegal,ExceptionMarcheSurObjet, ExceptionOuvrePorte
	{
		Actions d = Actions.DROITE;
		Joueur j = new Joueur("Jojo", 5, 5, 10, 5,100);
		Gobelin g = new Gobelin("Gobelin Jojo", 5, 3,  10, 5);
		Epee epee = new Epee("Excalibur", "t", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		Terrain t = new Terrain(10, j, ennemis,epee);
		
		
		try 
		{
			d.deplace(g, t);
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
	
	/**
	 * TestAtqHautJoueur() qui teste si le personnage peut attaquer en haut avec les exceptions
	 */
	@Test
	public void TestAtqHautJoueur()  throws ExceptionAttaqueImpossible
	{
		Actions h = Actions.HAUT;
		Joueur j = new Joueur("Jojo", 5, 5, 10, 5,100);
		Epee epee = new Epee("Excalibur", "t", 10, 8, 8);
		Gobelin g1 = new Gobelin("Gobelin Jamel", 4, 5, 10, 5);
    	ArrayList<Creature> ennemis = new ArrayList<Creature>();
    	ennemis.add(g1);
		Terrain t = new Terrain(10, j, ennemis,epee);
		
		
		try
		{
			h.attaque(j, t);
			assertEquals(5,g1.getPv());
			
		}
		catch(ExceptionAttaqueImpossible e)
		{
			assertTrue(e.getMessage().equals("Attaque impossible !!"));
		}
		
	}
	
	/**
	 * TestAtqHBasJoueur() qui teste si le personnage peut attaquer en bas avec les exceptions
	 */
	@Test
	public void TestAtqBasJoueur()  throws ExceptionAttaqueImpossible
	{
		Actions b = Actions.BAS;
		Joueur j = new Joueur("Jojo", 5, 5, 10, 5,100);
		Epee epee = new Epee("Excalibur", "t", 10, 8, 8);
		Gobelin g1 = new Gobelin("Gobelin Jamel", 6, 5, 10, 5);
    	ArrayList<Creature> ennemis = new ArrayList<Creature>();
    	ennemis.add(g1);
		Terrain t = new Terrain(10, j, ennemis,epee);
		
		
		try
		{
			b.attaque(j, t);
			assertEquals(5,g1.getPv());
			
		}
		catch(ExceptionAttaqueImpossible e)
		{
			assertTrue(e.getMessage().equals("Attaque impossible !!"));
		}
		
	}
	
	/**
	 * TestAtqDroiteJoueur() qui teste si le personnage peut attaquer à droite avec les exceptions
	 */
	@Test
	public void TestAtqDroiteJoueur()  throws ExceptionAttaqueImpossible
	{
		Actions d = Actions.DROITE;
		Joueur j = new Joueur("Jojo", 5, 5, 10, 5,100);
		Epee epee = new Epee("Excalibur", "t", 10, 8, 8);
		Gobelin g1 = new Gobelin("Gobelin Jamel", 5, 6, 10, 5);
    	ArrayList<Creature> ennemis = new ArrayList<Creature>();
    	ennemis.add(g1);
		Terrain t = new Terrain(10, j, ennemis,epee);
		
		
		try
		{
			d.attaque(j, t);
			assertEquals(5,g1.getPv());
			
		}
		catch(ExceptionAttaqueImpossible e)
		{
			assertTrue(e.getMessage().equals("Attaque impossible !!"));
		}
		
	}
	
	/**
	 * TestAtqGaucheJoueur() qui teste si le personnage peut attaquer à gaucheavec les exceptions
	 */
	@Test
	public void TestAtqGaucheJoueur()  throws ExceptionAttaqueImpossible
	{
		Actions g = Actions.GAUCHE;
		Joueur j = new Joueur("Jojo", 5, 5, 10, 5,100);
		Epee epee = new Epee("Excalibur", "t", 10, 8, 8);
		Gobelin g1 = new Gobelin("Gobelin Jamel", 5, 4, 10, 5);
    	ArrayList<Creature> ennemis = new ArrayList<Creature>();
    	ennemis.add(g1);
		Terrain t = new Terrain(10, j, ennemis,epee);
		
		
		try
		{
			g.attaque(j, t);
			assertEquals(5,g1.getPv());
			
		}
		catch(ExceptionAttaqueImpossible e)
		{
			assertTrue(e.getMessage().equals("Attaque impossible !!"));
		}
		
	}
	
	/**
	 * TestAtqHautGobelin() qui teste si le gobelin peut attaquer en haut avec les exceptions
	 */
	@Test
	public void TestAtqHautGobelin()  throws ExceptionAttaqueImpossible
	{
		Actions h = Actions.HAUT;
		Joueur j = new Joueur("Jojo", 5, 5, 10, 5,100);
		Epee epee = new Epee("Excalibur", "t", 10, 8, 8);
		Gobelin g1 = new Gobelin("Gobelin Jamel", 6, 5, 10, 5);
    	ArrayList<Creature> ennemis = new ArrayList<Creature>();
    	ennemis.add(g1);
		Terrain t = new Terrain(10, j, ennemis,epee);
		
		
		try
		{
			h.attaque(g1, t);
			assertEquals(5,j.getPv());
			
		}
		catch(ExceptionAttaqueImpossible e)
		{
			assertTrue(e.getMessage().equals("Attaque impossible !!"));
		}
	}
	
	/**
	 * TestAtqBasGobelin() qui teste si le gobelin peut attaquer en bas avec les exceptions
	 */
	@Test
	public void TestAtqBasGobelin()  throws ExceptionAttaqueImpossible
	{
		Actions b = Actions.BAS;
		Joueur j = new Joueur("Jojo", 7, 5, 10, 5, 100);
		Epee epee = new Epee("Excalibur", "t", 10, 8, 8);
		Gobelin g1 = new Gobelin("Gobelin Jamel", 6, 5, 10, 5);
    	ArrayList<Creature> ennemis = new ArrayList<Creature>();
    	ennemis.add(g1);
		Terrain t = new Terrain(10, j, ennemis,epee);
		
		
		try
		{
			b.attaque(g1, t);
			assertEquals(5,j.getPv());
			
		}
		catch(ExceptionAttaqueImpossible e)
		{
			assertTrue(e.getMessage().equals("Attaque impossible !!"));
		}
	}
	
	/**
	 * TestAtqGaucheGobelin() qui teste si le gobelin peut attaquer à gauche avec les exceptions
	 */
	@Test
	public void TestAtqGaucheGobelin()  throws ExceptionAttaqueImpossible
	{
		Actions g = Actions.GAUCHE;
		Joueur j = new Joueur("Jojo", 6, 4, 10, 5, 100);
		Epee epee = new Epee("Excalibur", "t", 10, 8, 8);
		Gobelin g1 = new Gobelin("Gobelin Jamel", 6, 5, 10, 5);
    	ArrayList<Creature> ennemis = new ArrayList<Creature>();
    	ennemis.add(g1);
		Terrain t = new Terrain(10, j, ennemis,epee);
		
		
		try
		{
			g.attaque(g1, t);
			assertEquals(5,j.getPv());
			
		}
		catch(ExceptionAttaqueImpossible e)
		{
			assertTrue(e.getMessage().equals("Attaque impossible !!"));
		}
	}
	
	/**
	 * TestAtqDroiteGobelin() qui teste si le gobelin peut attaquer à droite avec les exceptions
	 */
	@Test
	public void TestAtqDroiteGobelin()  throws ExceptionAttaqueImpossible
	{
		Actions d = Actions.DROITE;
		Joueur j = new Joueur("Jojo", 6, 6, 10, 5, 100);
		Epee epee = new Epee("Excalibur", "t", 10, 8, 8);
		Gobelin g1 = new Gobelin("Gobelin Jamel", 6, 5, 10, 5);
    	ArrayList<Creature> ennemis = new ArrayList<Creature>();
    	ennemis.add(g1);
		Terrain t = new Terrain(10, j, ennemis,epee);
		
		
		try
		{
			d.attaque(g1, t);
			assertEquals(5,j.getPv());
			
		}
		catch(ExceptionAttaqueImpossible e)
		{
			assertTrue(e.getMessage().equals("Attaque impossible !!"));
		}
	}
}
