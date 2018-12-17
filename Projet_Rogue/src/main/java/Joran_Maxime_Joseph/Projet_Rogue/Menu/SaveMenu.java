package Joran_Maxime_Joseph.Projet_Rogue.Menu;

import Joran_Maxime_Joseph.Projet_Rogue.Terrain;
import java.util.Scanner;


/**
 * SaveMenu est une classe représentant le menu de sauvegarde
 * 
 * @author Joran_Maxime_Joseph
 * @version 1.0
 */


public class SaveMenu extends Menu{

	/**
	 * Constructeur SaveMenu()
	 */
    public SaveMenu(){}
    
    /**
     * Fonction save qui sauvegarde létat actuel du jeu dans un fichier
     * @param nom qui prend en parametre le nom du fichier
     * @param t qui prend en parametre le terrain actuel
     */
    public void save(String nom, Terrain t){
        System.out.println("Tu veux donc sauvegarder ta progression, " +
                nom + ", très bien, donne moi simplement le nom du fichier à sauvegarder (l'extension .sav sera" +
                " automatiquement ajoutée à la fin)");
        Scanner sc = new Scanner(System.in);
        String nomFichier = sc.nextLine();
        try {
            t.saveToFIle(nomFichier);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
