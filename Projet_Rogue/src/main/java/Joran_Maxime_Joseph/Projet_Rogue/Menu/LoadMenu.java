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
	 * Constructeur par defaut
	 */
	    public LoadMenu(){}
	   
	        public Terrain load() throws ExceptionAbsenceDeSauvegarde{
	            Joueur j = new Joueur("dummy", -1, -1, -1, -1, -1, -1, -1);
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
	                    System.out.println(fileList[i].getName() + " - " + Integer.toString(i));
	                }
	                Scanner sc = new Scanner(System.in);
	                int choix;
	                String s = "";
	                System.out.println("Choisis le numero de ta sauvegarde !");
	                do{
	                    s = sc.nextLine();
	                    try{
	                        choix = Integer.parseInt(s);
	                    }
	                    catch (NumberFormatException e) {
	                        choix = -1;
	                        System.out.println("Choisis le numero de ta sauvegarde !");
	                    }
	                }while(choix < 0 || fileList.length < choix);
	                return t.readFromFile(fileList[choix].getName());
	            }
	            catch (Exception e){
	                System.out.println(e.getMessage());
	                return t;
	            }
	        }
}

