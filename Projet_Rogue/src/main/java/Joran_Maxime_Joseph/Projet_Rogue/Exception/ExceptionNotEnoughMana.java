package Joran_Maxime_Joseph.Projet_Rogue.Exception;

/**
 * ExceptionNotEnoughMana est une classe exception  qui se déclenche lorsque le joueur n'a pas pas assez de mana pour lancer un sort
 * 
 * @author Joran_Maxime_Joseph
 * @version 1.0
 */

public class ExceptionNotEnoughMana extends Exception{
	
	/**
	 * Constructeur ExceptionAbsenceDeSauvegarde()
	 */
    public ExceptionNotEnoughMana(){
        super("Tu manques de mana pour lancer ce sort !");
        System.out.println(getMessage());
        System.exit(0);
    }
}