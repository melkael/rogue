package Joran_Maxime_Joseph.Projet_Rogue;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestDecor {

	@Test
	public void TestInstanceMur() 
	{
		Decor mur = Decor.MUR;
		assertNotNull(mur);
	}

}
