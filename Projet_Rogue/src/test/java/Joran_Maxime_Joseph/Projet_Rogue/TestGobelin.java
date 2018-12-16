package Joran_Maxime_Joseph.Projet_Rogue;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGobelin {

	@Test
	public void TestInstanceGobelin() 
	{
		Gobelin g = new Gobelin("Gobelin Jojo", 5, 3, 1, 10, 5);
		assertNotNull(g);
	}
	
	@Test
	public void TestVivantGobelin() 
	{
		Gobelin g = new Gobelin("Gobelin Jojo", 5, 3, 1, 10, 5);
		
		assertTrue(g.estVivant());
	}
	
	@Test
	public void TestMortGobelin() 
	{
		Gobelin g = new Gobelin("Gobelin Jojo", 5, 3, 1, 0, 5);
		
		assertFalse(g.estVivant());
	}

}
