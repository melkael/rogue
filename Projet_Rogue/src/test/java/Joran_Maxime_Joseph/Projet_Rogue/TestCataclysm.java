package Joran_Maxime_Joseph.Projet_Rogue;

import static org.junit.Assert.*;

import java.util.ArrayList;

import Joran_Maxime_Joseph.Projet_Rogue.Creature.Creature;
import Joran_Maxime_Joseph.Projet_Rogue.Creature.Gobelin;
import Joran_Maxime_Joseph.Projet_Rogue.Creature.Joueur;
import Joran_Maxime_Joseph.Projet_Rogue.Exception.ExceptionAttaqueImpossible;
import Joran_Maxime_Joseph.Projet_Rogue.Exception.ExceptionDeplacementIllegal;
import Joran_Maxime_Joseph.Projet_Rogue.Exception.ExceptionMarcheSurObjet;
import Joran_Maxime_Joseph.Projet_Rogue.Exception.ExceptionNotEnoughMana;
import Joran_Maxime_Joseph.Projet_Rogue.Exception.ExceptionOuvrePorte;
import Joran_Maxime_Joseph.Projet_Rogue.Objet.Epee;
import Joran_Maxime_Joseph.Projet_Rogue.Sorts.Cataclysm;
import Joran_Maxime_Joseph.Projet_Rogue.Sorts.Soin;
import Joran_Maxime_Joseph.Projet_Rogue.Terrain;

import org.junit.Test;

public class TestCataclysm {

	@Test
	public void TestInstanceCataclysm() 
	{
		Cataclysm c = new Cataclysm();
		
		assertNotNull(c);
	}
	
	@Test
	public void TestInstanceCataclysm2() 
	{
		Cataclysm c = new Cataclysm("c",20);
		
		assertNotNull(c);
	}

	@Test
	public void TestEffetPv() throws ExceptionNotEnoughMana
	{
		Cataclysm c = new Cataclysm("c",20);
		Joueur j = new Joueur("Maxou", 5, 5, 10, 5, 1, 0,100);
		Gobelin g = new Gobelin("Gobelin Jojo", 5, 3,  19, 5);
		Epee epee = new Epee("Excalibur", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		Terrain t = new Terrain(10, j, ennemis, epee);
		ennemis.add(g);
		
		c.Effet(t);
		
		assertEquals(9,g.getPv());
	}
	
	@Test
	public void TestEffetMana() throws ExceptionNotEnoughMana
	{
		Cataclysm c = new Cataclysm("c",20);
		Joueur j = new Joueur("Maxou", 5, 5, 10, 5, 1, 0,100);
		Epee epee = new Epee("Excalibur", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		c.Effet(t);
		
		assertEquals(80,t.getPersonnage().getMana());
	}
	
	@Test
	public void TestEffetAffichageFaux() throws ExceptionNotEnoughMana
	{
		Cataclysm c = new Cataclysm("c",20);
		Joueur j = new Joueur("Maxou", 5, 5, 10, 5, 1, 0,10);
		Epee epee = new Epee("Excalibur", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		Terrain t = new Terrain(10, j, ennemis, epee);
		try{
			c.Effet(t);
		}
		catch(ExceptionNotEnoughMana e) {
			assertTrue(e.getMessage().equals("Not Enough Mana"));
		}
		
	}
	/*
	@Test
	public void TestEffetAffichageOK()
	{
		Cataclysm c = new Cataclysm("c",20);
		Joueur j = new Joueur("Maxou", 5, 5, 10, 5, 1, 0,100);
		Epee epee = new Epee("Excalibur", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		c.Effet(t);
		
		assertEquals("Le cataclysm se déchaine ! Tout les ennemis perdent 10Pv",c.Effet(t));
	}
	*/

}
