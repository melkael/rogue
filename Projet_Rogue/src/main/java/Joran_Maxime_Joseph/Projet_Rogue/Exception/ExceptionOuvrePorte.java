package Joran_Maxime_Joseph.Projet_Rogue.Exception;

/**
 * ExceptionOuvrePorte est une classe exception qui se declenche quand le personnage arrive sur un porte
 * 
 * @author Joran_Maxime_Joseph
 * @version 1.0
 */

public class ExceptionOuvrePorte extends Exception {
	
	/**
	 * Constructeur ExceptionOuvrePorte()
	 */
    public ExceptionOuvrePorte() {
        super("Vous ouvrez une porte !");
    }
}
