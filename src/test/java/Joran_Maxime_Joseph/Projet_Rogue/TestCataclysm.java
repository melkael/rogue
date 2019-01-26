package Joran_Maxime_Joseph.Projet_Rogue;

import static org.junit.Assert.*;

import java.util.ArrayList;

import Joran_Maxime_Joseph.Projet_Rogue.Creature.Creature;
import Joran_Maxime_Joseph.Projet_Rogue.Creature.Gobelin;
import Joran_Maxime_Joseph.Projet_Rogue.Creature.Joueur;
import Joran_Maxime_Joseph.Projet_Rogue.Exception.ExceptionNotEnoughMana;
import Joran_Maxime_Joseph.Projet_Rogue.Objet.Epee;
import Joran_Maxime_Joseph.Projet_Rogue.Sorts.Cataclysm;
import Joran_Maxime_Joseph.Projet_Rogue.Terrain;

import org.junit.Test;

public class TestCataclysm {

	/**
	 * TestInstanceCataclysm() qui teste la creation du cataclysme
	 */
	@Test
	public void TestInstanceCataclysm() 
	{
		Cataclysm c = new Cataclysm();
		
		assertNotNull(c);
	}
	
	/**
	 * TestInstanceCataclysm2() qui teste la creation du cataclysme
	 */
	@Test
	public void TestInstanceCataclysm2() 
	{
		Cataclysm c = new Cataclysm("c",20);
		
		assertNotNull(c);
	}

	/**
	 * TestEffetPv() qui teste si le joueur est bien soigné
	 * @throws ExceptionNotEnoughMana qui envoie un message si exception
	 */
	@Test
	public void TestEffetPv() throws ExceptionNotEnoughMana
	{
		Cataclysm c = new Cataclysm("c",20);
		Joueur j = new Joueur("Maxou", 5, 5, 10, 5, 100);
		Gobelin g = new Gobelin("Gobelin Jojo", 5, 3,  19, 5);
		Epee epee = new Epee("Excalibur", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		Terrain t = new Terrain(10, j, ennemis, epee);
		ennemis.add(g);
		
		c.Effet(t);
		
		assertEquals(9,g.getPv());
	}
	
	/**
	 * TestEffetMana() qui teste si le joueur a bien perdu du mana
	 * @throws ExceptionNotEnoughMana qui envoie un message si exception
	 */
	@Test
	public void TestEffetMana() throws ExceptionNotEnoughMana
	{
		Cataclysm c = new Cataclysm("c",20);
		Joueur j = new Joueur("Maxou", 5, 5, 10, 5, 100);
		Epee epee = new Epee("Excalibur", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		c.Effet(t);
		
		assertEquals(80,t.getPersonnage().getMana());
	}
	
	/**
	 * TestEffetAffichageFaux() qui teste si ca affiche le bon message
	 * @throws ExceptionNotEnoughMana qui envoie un message si exception
	 */
	@Test
	public void TestEffetAffichageFaux() throws ExceptionNotEnoughMana
	{
		Cataclysm c = new Cataclysm("c",20);
		Joueur j = new Joueur("Maxou", 5, 5, 10, 5,10);
		Epee epee = new Epee("Excalibur", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		Terrain t = new Terrain(10, j, ennemis, epee);
		try{
			c.Effet(t);
		}
		catch(ExceptionNotEnoughMana e) {
			assertTrue(e.getMessage().equals("Tu manques de mana pour lancer ce sort !"));
		}
		
	}
	
	/**
	 * TestEffetAffichageOK() qui teste si ca affiche le bon message
	 * @throws ExceptionNotEnoughMana qui envoie un message si exception
	 */
	@Test
	public void TestEffetAffichageOK() throws ExceptionNotEnoughMana
	{
		Cataclysm c = new Cataclysm("c",20);
		Joueur j = new Joueur("Maxou", 5, 5, 10, 5, 100);
		Epee epee = new Epee("Excalibur", "T", 10, 8, 8);
		ArrayList<Creature> ennemis = new ArrayList<Creature>();
		Terrain t = new Terrain(10, j, ennemis, epee);
		
		try{
			c.Effet(t);
			assertTrue("Vous vous sentez mieux ! Vous gagnez 10 pv",true);
		}
		catch(ExceptionNotEnoughMana e) {
			assertTrue(e.getMessage().equals("Tu manques de mana pour lancer ce sort !"));
		}
	}

}
