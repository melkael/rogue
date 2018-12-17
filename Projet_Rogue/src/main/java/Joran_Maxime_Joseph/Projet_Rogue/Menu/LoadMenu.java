package Joran_Maxime_Joseph.Projet_Rogue.Menu;

import java.io.File;
import java.util.Scanner;

import Joran_Maxime_Joseph.Projet_Rogue.Divers.Filter;
import Joran_Maxime_Joseph.Projet_Rogue.Exception.ExceptionAbsenceDeSauvegarde;
import Joran_Maxime_Joseph.Projet_Rogue.Terrain;

/**
 * LoadMenu est une classe qui représente le menu de chargement
 * 
 * @author Joran_Maxime_Joseph
 * @version 1.0
 */

public class LoadMenu {
	/**
	 * Constructeur par defaut
	 */
    public LoadMenu(){}
    /**
     * Fonction load qui permet de charger un fichier contenant un terrain
     * @param t terrain contenu dans le fichier
     * @return t renvoie le terrain
     * @throws ExceptionAbsenceDeSauvegarde qui affiche un message si il n'y a pas de sauvegarde
     */
    public Terrain load(Terrain t) throws ExceptionAbsenceDeSauvegarde{

        try {
            File f = new File("f");
            String path = f.getCanonicalPath();
            String p = path.substring(0, path.length() -1);
            Filter filter = new Filter();
            File[] fileList = filter.finder(p);
            if (fileList.length == 0) {
                throw new ExceptionAbsenceDeSauvegarde();
            }
            for(int i = 0; i < fileList.length; i++){
                System.out.println(fileList[i].getName() + " - " + Integer.toString(i));
            }
            Scanner sc = new Scanner(System.in);
            int choix;
            do{
                System.out.println("Choisis le numero de ta sauvegarde !");
                choix = sc.nextInt();
            }while(choix < 0 || fileList.length < choix);
            return t.readFromFile(fileList[choix].getName());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return t;
        }
    }
}
