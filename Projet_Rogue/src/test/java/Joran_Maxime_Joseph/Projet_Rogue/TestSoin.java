package Joran_Maxime_Joseph.Projet_Rogue;

import static org.junit.Assert.*;

import java.util.ArrayList;

import Joran_Maxime_Joseph.Projet_Rogue.Creature.Creature;
import Joran_Maxime_Joseph.Projet_Rogue.Creature.Joueur;
import Joran_Maxime_Joseph.Projet_Rogue.Exception.ExceptionNotEnoughMana;
import Joran_Maxime_Joseph.Projet_Rogue.Objet.Epee;
import Joran_Maxime_Joseph.Projet_Rogue.Sorts.Soin;

import org.junit.Test;

public class TestSoin {

	@Test
	public void TestInstanceSoin() 
	{
		Soin s = new Soin();
		
		assertNotNull(s);
	}
	
	@Test
	public void TestInstanceSoin2() 
	{
		Soin s = new Soin("sort",10);
		
		assertNotNull(s);
	}

	@Test
	public void TestEffetPv() throws ExceptionNotEnoughMana
	{
		Soin s = new Soin("s",20);
		Joueur j = new Joueur("Maxou", 5, 5, 10, 5, 1, 0,100);
		Epee epee = new Epee("Excalibur", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		s.Effet(t);
		
		assertEquals(20,t.getPersonnage().getPv());
	}
	
	@Test
	public void TestEffetMana() throws ExceptionNotEnoughMana
	{
		Soin s = new Soin("s",20);
		Joueur j = new Joueur("Maxou", 5, 5, 10, 5, 1, 0,100);
		Epee epee = new Epee("Excalibur", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		s.Effet(t);
		
		assertEquals(80,t.getPersonnage().getMana());
	}
	
	@Test
	public void TestEffetAffichageFaux() throws ExceptionNotEnoughMana
	{
		Soin s = new Soin("s",20);
		Joueur j = new Joueur("Maxou", 5, 5, 10, 5, 1, 0,10);
		Epee epee = new Epee("Excalibur", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		try{
			s.Effet(t);
		}
		catch(ExceptionNotEnoughMana e) {
			assertTrue(e.getMessage().equals("Tu manques de mana pour lancer ce sort !"));
		}
	}
	
	@Test
	public void TestEffetAffichageOK() throws ExceptionNotEnoughMana
	{
		Soin s = new Soin("s",20);
		Joueur j = new Joueur("Maxou", 5, 5, 10, 5, 1, 0,100);
		Epee epee = new Epee("Excalibur", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		try
		{
			s.Effet(t);
			assertTrue("Vous vous sentez mieux ! Vous gagnez 10 pv",true);

		}
		catch(ExceptionNotEnoughMana e)
		{
			assertTrue(e.getMessage().equals("Tu manques de mana pour lancer ce sort !"));
		}
	}	
}
