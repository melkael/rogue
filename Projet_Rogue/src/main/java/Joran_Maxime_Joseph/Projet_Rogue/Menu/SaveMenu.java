package Joran_Maxime_Joseph.Projet_Rogue.Menu;

import Joran_Maxime_Joseph.Projet_Rogue.Terrain;
import java.util.Scanner;

public class SaveMenu {
    public SaveMenu(){}
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
