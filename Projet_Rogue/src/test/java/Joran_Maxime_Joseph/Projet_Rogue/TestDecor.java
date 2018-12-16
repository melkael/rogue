package Joran_Maxime_Joseph.Projet_Rogue;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;

public class TestDecor {

	@Test
	public void TestInstanceMur() 
	{
		Decor mur = Decor.MUR;
		assertNotNull(mur);
	}
	
	@Test
	public void TestInstanceSol() 
	{
		Decor sol = Decor.SOL;
		assertNotNull(sol);
	}
	
	@Test
	public void TestInstancePorte() 
	{
		Decor porte = Decor.PORTE;
		assertNotNull(porte);
	}
	
	@Test
	public void TestInstanceLimite() 
	{
		Decor lim = Decor.LIMITE;
		assertNotNull(lim);
	}
	
	@Test
	public void TestAffichageMur() 
	{
		Decor mur = Decor.MUR;
		assertEquals("#",mur.toString());
	}
	
	@Test
	public void TestAffichageSol() 
	{
		Decor sol = Decor.SOL;
		assertEquals(" ",sol.toString());
	}
	
	@Test
	public void TestAffichagePorte() 
	{
		Decor porte = Decor.PORTE;
		assertEquals("0",porte.toString());
	}
	
	@Test
	public void TestAffichageLimite() 
	{
		Decor lim = Decor.LIMITE;
		assertEquals("X",lim.toString());
	}
	
	@Test
	public void TestFctOuvertMur() 
	{
		Decor mur = Decor.MUR;
		Joueur j = new Joueur("Jojo", 5, 5, 1, 10, 5, 1, 0);
    	ArrayList<Creature> ennemis = new ArrayList<Creature>();
    	Epee epee = new Epee("Excaliburne", "T", 10, 8, 8);
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		assertFalse(mur.estOuverte(t));
	}
	
	@Test
	public void TestFctOuvertSol() 
	{
		Decor sol = Decor.SOL;
		Joueur j = new Joueur("Jojo", 5, 5, 1, 10, 5, 1, 0);
    	ArrayList<Creature> ennemis = new ArrayList<Creature>();
    	Epee epee = new Epee("Excaliburne", "T", 10, 8, 8);
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		assertFalse(sol.estOuverte(t));
		
	}
	
	@Test
	public void TestFctOuvertLimite() 
	{
		Decor lim = Decor.LIMITE;
		Joueur j = new Joueur("Jojo", 5, 5, 1, 10, 5, 1, 0);
    	ArrayList<Creature> ennemis = new ArrayList<Creature>();
    	Epee epee = new Epee("Excaliburne", "T", 10, 8, 8);
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		assertFalse(lim.estOuverte(t));
		
	}
	
	@Test
	public void TestFctOuvertPorte() 
	{
		Decor p = Decor.PORTE;
		Joueur j = new Joueur("Jojo", 5, 5, 1, 10, 5, 1, 0);
    	ArrayList<Creature> ennemis = new ArrayList<Creature>();
    	Epee epee = new Epee("Excaliburne", "T", 10, 8, 8);
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		assertTrue(p.estOuverte(t));
		
	}
	
	@Test
	public void TestFctOuvertPorteFerme() 
	{
		Decor p = Decor.PORTE;
		Joueur j = new Joueur("Jojo", 5, 5, 1, 10, 5, 1, 0);
		Gobelin g1 = new Gobelin("Gobelin Jamel", 2, 3, 1, 10, 5);
    	ArrayList<Creature> ennemis = new ArrayList<Creature>();
    	Epee epee = new Epee("Excaliburne", "T", 10, 8, 8);
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		ennemis.add(g1);
		
		assertFalse(p.estOuverte(t));
		
	}

}
