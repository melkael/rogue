package Joran_Maxime_Joseph.Projet_Rogue;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;

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
	
	@Test
	public void TestAffichageMur() 
	{
		Decor mur = Decor.MUR;
		assertEquals("#",mur.toString());
	}
	
	@Test
	public void TestAffichageSol() 
	{
		Decor sol = Decor.SOL;
		assertEquals(" ",sol.toString());
	}
	
	@Test
	public void TestAffichagePorte() 
	{
		Decor porte = Decor.PORTE;
		assertEquals("0",porte.toString());
	}
	
	@Test
	public void TestAffichageLimite() 
	{
		Decor lim = Decor.LIMITE;
		assertEquals("X",lim.toString());
	}

}
