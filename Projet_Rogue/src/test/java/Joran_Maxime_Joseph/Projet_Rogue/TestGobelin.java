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
 * TestGobelin est une classe de test pour tester les méthodes de la classe Gobelin
 * 
 * @author Joran_Maxime_Joseph
 * @version 1.0
 */
public class TestGobelin {

	/**
	 * TestInstanceGobelin() qui teste la creation de Gobelin
	 */
	@Test
	public void TestInstanceGobelin() 
	{
		Gobelin g = new Gobelin("Gobelin Jojo", 5, 3,  10, 5);
		assertNotNull(g);
	}
	
	/**
	 * TestVivantGobelin() qui teste si le gobelin est vivant
	 */
	@Test
	public void TestVivantGobelin() 
	{
		Gobelin g = new Gobelin("Gobelin Jojo", 5, 3,  10, 5);
		
		assertTrue(g.estVivant());
	}
	
	/**
	 * TestMortGobelin() qui teste si le gobelin est mort
	 */
	@Test
	public void TestMortGobelin() 
	{
		Gobelin g = new Gobelin("Gobelin Jojo", 5, 3,  0, 5);
		
		assertFalse(g.estVivant());
	}
	
	/**
	 * TestSeDeplaceHaut() qui teste si le gobelin  se deplace bien en haut avec les exceptions
	 */
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
	
	/**
	 * TestSeDeplaceBas() qui teste si le gobelin se deplace bien en bas avec les exceptions
	 */
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
	
	/**
	 * TestSeDeplaceGauche() qui teste si le gobelin se deplace bien à gauche avec les exceptions
	 */
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
	
	/**
	 * TestSeDeplaceDroite() qui teste si le gobelin se deplace bien à droite avec les exceptions
	 */
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
	
	/**
	 * TestAtqHaut() qui teste si le gobelin  attaque bien en haut avec les exceptions
	 */
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
	
	/**
	 * TestAtqBas() qui teste si le gobelin  attaque bien en bas avec les exceptions
	 */
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
	
	/**
	 * TestAtqGauche() qui teste si le gobelin  attaque bien à gauche avec les exceptions
	 */
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
	
	/**
	 * TestAtqDroite() qui teste si le gobelin attaque bien à droite avec les exceptions
	 */
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
	
	/**
	 * TestClosePlayerHaut() qui teste si le gobelin  est en bas du joueur
	 */
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
	
	/**
	 * TestClosePlayerBas() qui teste si le gobelin  est en haut du joueur
	 */
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
	
	/**
	 * TestClosePlayerGauche() qui teste si le gobelin  est a droite du joueur
	 */
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
	
	/**
	 * TestClosePlayerDroite() qui teste si le gobelin  est à gauche du joueur
	 */
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

	/**
	 * TestIAHaut() qui teste si l'IA attaque bien en haut si le joueur est en haut
	 * @throws ExceptionDeplacementIllegal envoie un message de deplacement illegal
	 * @throws ExceptionMarcheSurObjet envoie un message si marche sur un objet
	 * @throws ExceptionAttaqueImpossible envoie un message si attaque impossible
	 * @throws ExceptionOuvrePorte envoie un message si la porte est ouverte
	 */
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
	
	/**
	 * TestIABas() qui teste si l'IA attaque bien en bas si le joueur est en bas
	 * @throws ExceptionDeplacementIllegal envoie un message de deplacement illegal
	 * @throws ExceptionMarcheSurObjet envoie un message si marche sur un objet
	 * @throws ExceptionAttaqueImpossible envoie un message si attaque impossible
	 * @throws ExceptionOuvrePorte envoie un message si la porte est ouverte
	 */
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
	
	/**
	 * TestIAGauche() qui teste si l'IA attaque bien a gauchesi le joueur est a gauche
	 * @throws ExceptionDeplacementIllegal envoie un message de deplacement illegal
	 * @throws ExceptionMarcheSurObjet envoie un message si marche sur un objet
	 * @throws ExceptionAttaqueImpossible envoie un message si attaque impossible
	 * @throws ExceptionOuvrePorte envoie un message si la porte est ouverte
	 */
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
	
	/**
	 * TestIADroite() qui teste si l'IA attaque bien a droite si le joueur est a droite
	 * @throws ExceptionDeplacementIllegal envoie un message de deplacement illegal
	 * @throws ExceptionMarcheSurObjet envoie un message si marche sur un objet
	 * @throws ExceptionAttaqueImpossible envoie un message si attaque impossible
	 * @throws ExceptionOuvrePorte envoie un message si la porte est ouverte
	 */
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
	
	/**
	 * TestIADefault() qui teste si l'IA se deplace bien quand elle n'est pas a cote du joueur
	 * @throws ExceptionDeplacementIllegal envoie un message de deplacement illegal
	 * @throws ExceptionMarcheSurObjet envoie un message si marche sur un objet
	 * @throws ExceptionAttaqueImpossible envoie un message si attaque impossible
	 * @throws ExceptionOuvrePorte envoie un message si la porte est ouverte
	 */
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
