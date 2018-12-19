package Joran_Maxime_Joseph.Projet_Rogue;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Joran_Maxime_Joseph.Projet_Rogue.Creature.Creature;
import Joran_Maxime_Joseph.Projet_Rogue.Creature.Gobelin;
import Joran_Maxime_Joseph.Projet_Rogue.Creature.Joueur;
import Joran_Maxime_Joseph.Projet_Rogue.Objet.Epee;

import org.junit.Before;
import org.junit.BeforeClass;

/**
 * TestDecor est une classe de test pour tester les méthodes de la classe Decor
 * 
 * @author Joran_Maxime_Joseph
 * @version 1.0
 */
public class TestDecor {

	/**
	 * TestInstanceMur() qui teste la creation de MUR
	 */
	@Test
	public void TestInstanceMur() 
	{
		Decor mur = Decor.MUR;
		assertNotNull(mur);
	}
	
	/**
	 * TestInstanceSol() qui teste la creation de SOL
	 */
	@Test
	public void TestInstanceSol() 
	{
		Decor sol = Decor.SOL;
		assertNotNull(sol);
	}
	
	/**
	 * TestInstancePorte() qui teste la creation de PORTE
	 */
	@Test
	public void TestInstancePorte() 
	{
		Decor porte = Decor.PORTE;
		assertNotNull(porte);
	}
	
	/**
	 * TestInstanceLimite() qui teste la creation de LIMITE
	 */
	@Test
	public void TestInstanceLimite() 
	{
		Decor lim = Decor.LIMITE;
		assertNotNull(lim);
	}
	
	/**
	 * TestAffichageMur() qui teste l(affichage de MUR
	 */
	@Test
	public void TestAffichageMur() 
	{
		Decor mur = Decor.MUR;
		assertEquals("\uD83D\uDD6F️",mur.toString());
	}
	
	/**
	 * TestAffichageSOl() qui teste l(affichage de SOL
	 */
	@Test
	public void TestAffichageSol() 
	{
		Decor sol = Decor.SOL;
		assertEquals(" ",sol.toString());
	}
	
	/**
	 * TestAffichagePorte() qui teste l(affichage de PORTE
	 */
	@Test
	public void TestAffichagePorte() 
	{
		Decor porte = Decor.PORTE;
		assertEquals("\uD83D\uDEAA",porte.toString());
	}
	
	/**
	 * TestAffichageLimite() qui teste l(affichage de LIMITE
	 */
	@Test
	public void TestAffichageLimite() 
	{
		Decor lim = Decor.LIMITE;
		assertEquals(".",lim.toString());
	}
	
	/**
	 * TestFctOuvertMur() qui teste que la porte est fermée
	 */
	@Test
	public void TestFctOuvertMur() 
	{
		Decor mur = Decor.MUR;
		Joueur j = new Joueur("Jojo", 5, 5, 10, 5, 100);
    	ArrayList<Creature> ennemis = new ArrayList<Creature>();
    	Epee epee = new Epee("Excalibur", "T", 10, 8, 8);
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		assertFalse(mur.estOuverte(t));
	}
	
	/**
	 * TestFctOuvertSol() qui teste que la porte est fermée
	 */
	@Test
	public void TestFctOuvertSol() 
	{
		Decor sol = Decor.SOL;
		Joueur j = new Joueur("Jojo", 5, 5, 10, 5, 100);
    	ArrayList<Creature> ennemis = new ArrayList<Creature>();
    	Epee epee = new Epee("Excalibur", "T", 10, 8, 8);
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		assertFalse(sol.estOuverte(t));
		
	}
	
	/**
	 * TestFctOuvertLimite() qui teste que la porte est fermée
	 */
	@Test
	public void TestFctOuvertLimite() 
	{
		Decor lim = Decor.LIMITE;
		Joueur j = new Joueur("Jojo", 5, 5, 10, 5, 100);
    	ArrayList<Creature> ennemis = new ArrayList<Creature>();
    	Epee epee = new Epee("Excalibur", "T", 10, 8, 8);
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		assertFalse(lim.estOuverte(t));
		
	}
	
	/**
	 * TestFctOuvertPorte() qui teste que la porte est ouverte
	 */
	@Test
	public void TestFctOuvertPorte() 
	{
		Decor p = Decor.PORTE;
		Joueur j = new Joueur("Jojo", 5, 5, 10, 5, 100);
    	ArrayList<Creature> ennemis = new ArrayList<Creature>();
    	Epee epee = new Epee("Excalibur", "T", 10, 8, 8);
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		assertTrue(p.estOuverte(t));
		
	}
	
	/**
	 * TestFctOuvertPorteFerme() qui teste que la porte est fermée
	 */
	@Test
	public void TestFctOuvertPorteFerme() 
	{
		Decor p = Decor.PORTE;
		Joueur j = new Joueur("Jojo", 5, 5, 10, 5, 100);
		Gobelin g1 = new Gobelin("Gobelin Jamel", 2, 3, 10, 5);
    	ArrayList<Creature> ennemis = new ArrayList<Creature>();
    	Epee epee = new Epee("Excalibur", "T", 10, 8, 8);
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		ennemis.add(g1);
		
		assertFalse(p.estOuverte(t));
		
	}

}
