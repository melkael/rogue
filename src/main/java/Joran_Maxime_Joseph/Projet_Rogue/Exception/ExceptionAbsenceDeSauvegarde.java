package Joran_Maxime_Joseph.Projet_Rogue.Exception;

/**
 * ExceptionAbsenceDeSauvegarde est une classe exception  qui se déclenche lorsqu'il n'y a pas de sauvegarde
 * 
 * @author Joran_Maxime_Joseph
 * @version 1.0
 */

public class ExceptionAbsenceDeSauvegarde extends Exception{
	
	/**
	 * Constructeur ExceptionAbsenceDeSauvegarde()
	 */
    public ExceptionAbsenceDeSauvegarde(){
        super("Aucune sauvegarde trouvée !");
        System.out.println(getMessage());
        System.exit(0);
    }
}
