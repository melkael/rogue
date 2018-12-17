package Joran_Maxime_Joseph.Projet_Rogue.Menu;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

public class StartMenu extends Menu{
    public String entree;
    public StartMenu(){
        AsciiArt("UVSQuest");
        padding();
        System.out.println("###############################################  C pour charger ta save    #############################################");
        System.out.println("############################################### N pour commencer la partie #############################################");
        padding();
        Scanner sc = new Scanner(System.in);
        String entree = "";
        do{
            entree = sc.nextLine();
        }while(!entree.equalsIgnoreCase("c") && !entree.equalsIgnoreCase("n"));
        this.entree = entree;
    }
}
