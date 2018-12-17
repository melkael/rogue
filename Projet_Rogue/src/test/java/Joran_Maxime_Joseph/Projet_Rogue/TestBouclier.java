package Joran_Maxime_Joseph.Projet_Rogue;

import static org.junit.Assert.*;

import org.junit.Test;

import Joran_Maxime_Joseph.Projet_Rogue.Objet.Bouclier;

/**
 * TestBouclierest une classe de test pour tester les méthodes de la classe Bouclier
 * @author Joran_Maxime_Joseph
 * @version 1.0
 */
public class TestBouclier {

	/**
	 * TestInstanceBouclier() qui teste la creation d'un bouclier
	 */
	@Test
	public void TestInstanceBouclier() 
	{
		Bouclier b= new Bouclier("boubou","B",10,3,3);
				
		assertNotNull(b);
	}

}
