package Joran_Maxime_Joseph.Projet_Rogue;

import static org.junit.Assert.*;

import org.junit.Test;

import Joran_Maxime_Joseph.Projet_Rogue.Objet.Epee;

/**
 * TestEpee est une classe de test pour tester les méthodes de la classe Epee
 * 
 * @author Joran_Maxime_Joseph
 * @version 1.0
 */
public class TestEpee {

	/**
	 * TestInstanceEpee() qui teste la creation d'une epee
	 */
	@Test
	public void TestInstanceEpee() 
	{
		Epee epee = new Epee("Excaliburne", "T", 10, 8, 8);
		
		assertNotNull(epee);
	}

}
