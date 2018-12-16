package Joran_Maxime_Joseph.Projet_Rogue;

import static org.junit.Assert.*;

import org.junit.Test;

import Joran_Maxime_Joseph.Projet_Rogue.Objet.Epee;

public class TestEpee {

	@Test
	public void TestInstanceEpee() 
	{
		Epee epee = new Epee("Excaliburne", "T", 10, 8, 8);
		
		assertNotNull(epee);
	}

}
