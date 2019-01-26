package Joran_Maxime_Joseph.Projet_Rogue.Menu;

import java.io.File;
import java.util.Scanner;

import Joran_Maxime_Joseph.Projet_Rogue.Creature.Joueur;
import Joran_Maxime_Joseph.Projet_Rogue.Divers.Filter;
import Joran_Maxime_Joseph.Projet_Rogue.Exception.ExceptionAbsenceDeSauvegarde;
import Joran_Maxime_Joseph.Projet_Rogue.Terrain;


/**
 * LoadMenu est une classe qui représente le menu de chargement
 * 
 * @author Joran_Maxime_Joseph
 * @version 1.0
 */

public class LoadMenu extends Menu{
	
	/**
	 * Constructeur LoadMenu
	 */
	    public LoadMenu(){}
	   
	    	/**
	    	 * Fonction load() qui permet de charger un fichier sauvegarder
	    	 * @return t qui renvoie le terrain
	    	 * @throws ExceptionAbsenceDeSauvegarde qui envoie un message s'il n'y a pas de sauvegarde
	    	 */
	        public Terrain load() throws ExceptionAbsenceDeSauvegarde{
	            Joueur j = new Joueur("dummy", -1, -1, -1, -1,-1);
	            Terrain t = new Terrain(j);

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
	                	String col = "";
	                	if(i % 2 == 0)
	                		col = ANSI_GREEN_BACKGROUND;
	                	else
	                		col = ANSI_BLUE_BACKGROUND;

	                    System.out.println(col + ANSI_BLACK +fileList[i].getName() + " - " + Integer.toString(i) + ANSI_RESET);
	                }
	                Scanner sc = new Scanner(System.in);
	                int choix;
	                String s = "";
	                do{
	                	System.out.println();
						System.out.println(ANSI_RED_BACKGROUND + ANSI_BLACK + "Choisis le numero de ta sauvegarde !" + ANSI_RESET);
	                    s = sc.nextLine();
	                    try{
	                        choix = Integer.parseInt(s);
	                    }
	                    catch (NumberFormatException e) {
	                        choix = -1;
	                    };
	                }while(choix < 0 || fileList.length < choix);
	                return t.readFromFile(fileList[choix].getName());
	            }
	            catch (Exception e){
	                System.out.println(e.getMessage());
	                return t;
	            }
	        }
}

