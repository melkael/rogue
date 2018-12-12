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

}
