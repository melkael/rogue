package Joran_Maxime_Joseph.Projet_Rogue.Menu;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

/**
 * StartMenu est une classe représentant le menu de départ
 * 
 * @author Joran_Maxime_Joseph
 * @version 1.0
 */

public class StartMenu extends Menu{
    public String entree;
    
    /**
	 * Constructeur par defaut
	 */
    public StartMenu(){
        AsciiArt("UVSQuest");
        padding();
        System.out.println("###############################################" + ANSI_YELLOW + "  C pour charger ta save" + ANSI_RESET + "    #############################################");
        System.out.println("###############################################" + ANSI_YELLOW + " N pour commencer la partie" + ANSI_RESET + " #############################################");
        padding();
        Scanner sc = new Scanner(System.in);
        String entree = "";
        do{
            entree = sc.nextLine();
        }while(!entree.equalsIgnoreCase("c") && !entree.equalsIgnoreCase("n"));
        this.entree = entree;
    }
}
