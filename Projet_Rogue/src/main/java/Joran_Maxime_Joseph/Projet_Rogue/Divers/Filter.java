package Joran_Maxime_Joseph.Projet_Rogue.Divers;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Filter est une classe pour le type de fichier sauvegarder
 * 
 * @author Joran_Maxime_Joseph
 * @version 1.0
 */

public class Filter {

	/**
	 * Fonction qui permet de récupeer tous les fichiers de sauvegarde
	 * @param dirName nom du dossier
	 * @return le fichier suivit de .sav
	 */
    public File[] finder(String dirName){
        File dir = new File(dirName);

        return dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String filename)
            { return filename.endsWith(".sav"); }
        } );
    }
}
