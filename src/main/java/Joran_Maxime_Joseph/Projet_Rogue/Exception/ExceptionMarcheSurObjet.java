package Joran_Maxime_Joseph.Projet_Rogue.Exception;

/**
 * ExceptionMarcheSurObjet est une classe exception  qui se déclenche quand le personnage arrive sur un objet
 * 
 * @author Joran_Maxime_Joseph
 * @version 1.0
 */

public class ExceptionMarcheSurObjet extends Exception{
	
	/**
	 * Constructeur ExceptionMarcheSurObjet()
	 */
	public ExceptionMarcheSurObjet() {
		super("Marche sur un objet");
	}
}
