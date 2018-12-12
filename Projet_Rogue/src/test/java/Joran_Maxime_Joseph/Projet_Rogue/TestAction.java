package Joran_Maxime_Joseph.Projet_Rogue;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAction {

	@Test
	public void TestInstanceHaut() 
	{
		Actions h = Actions.HAUT;
		assertNotNull(h);
	}
	
	@Test
	public void TestInstanceBas() 
	{
		Actions b = Actions.BAS;
		assertNotNull(b);
	}
	
	@Test
	public void TestInstanceGauche() 
	{
		Actions g = Actions.GAUCHE;
		assertNotNull(g);
	}
	
	@Test
	public void TestInstanceDroite() 
	{
		Actions d = Actions.DROITE;
		assertNotNull(d);
	}
	
	@Test
	public void TestDeplaceHaut() 
	{
		Actions h = Actions.HAUT;
		assertNotNull(h);
	}
	
	@Test
	public void TestDeplaceBas() 
	{
		Actions b = Actions.BAS;
		assertNotNull(b);
	}

	@Test
	public void TestDeplaceGauche() 
	{
		Actions g = Actions.GAUCHE;
		assertNotNull(g);
	}
	
	@Test
	public void TestDeplaceDroite() 
	{
		Actions d = Actions.DROITE;
		assertNotNull(d);
	}
}
