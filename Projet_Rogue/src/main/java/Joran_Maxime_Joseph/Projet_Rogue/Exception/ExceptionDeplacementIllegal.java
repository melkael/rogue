package Joran_Maxime_Joseph.Projet_Rogue.Exception;

/**
 * ExceptionDeplacementIllegal qui se déclenche lors d'une collision avec un autre objet
 * 
 * @author Joran_Maxime_Joseph
 * @version 1.0
 */

public class ExceptionDeplacementIllegal extends Exception {
	
	/**
	 * Constructeur par defaut
	 */
	public ExceptionDeplacementIllegal()
	{
		super("Deplacement Illegal");
	}

}
