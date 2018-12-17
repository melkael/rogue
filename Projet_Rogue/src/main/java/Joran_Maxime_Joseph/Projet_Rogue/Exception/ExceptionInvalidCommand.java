package Joran_Maxime_Joseph.Projet_Rogue.Exception;

/**
 * ExceptionInvalidCommand est une classe exception  qui se déclenche lors d'une mauvaise commande
 * 
 * @author Joran_Maxime_Joseph
 * @version 1.0
 */

public class ExceptionInvalidCommand extends Exception {
	
	/**
	 * Constructeur par defaut de l'exception
	 */
	
	public ExceptionInvalidCommand()
	{
		super("Commande invalide !!");
	}

}