package Joran_Maxime_Joseph.Projet_Rogue.Exception;

/**
 * ExceptionAttaqueImpossible est une classe exception qui se déclenche lors d'une attaque qui n'a pas lieu sur un gobelin
 * 
 * @author Joran_Maxime_Joseph
 * @version 1.0
 */

public class ExceptionAttaqueImpossible extends Exception{
	
	/**
	 * Constructeur ExceptionAttaqueImpossible()
	 */
	public ExceptionAttaqueImpossible() {
		super("Attaque impossible !!");
	}
}
