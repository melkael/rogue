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

}
