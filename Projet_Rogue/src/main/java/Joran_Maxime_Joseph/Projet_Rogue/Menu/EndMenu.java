package Joran_Maxime_Joseph.Projet_Rogue.Menu;

/**
 * EndMenu est une classe qui représente le Menu Game Over
 * 
 * @author Joran_Maxime_Joseph
 * @version 1.0
 */
public class EndMenu extends Menu{
	/**
	 * Constructeur EndMenu
	 * @param nomPerso qui représente le nom du Personnage
	 */
    public EndMenu(String nomPerso){
        AsciiArt("ADIEU");
        AsciiArt(nomPerso);
        System.out.println();
    }
}
