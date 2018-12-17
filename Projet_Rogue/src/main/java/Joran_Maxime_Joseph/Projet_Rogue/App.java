package Joran_Maxime_Joseph.Projet_Rogue;
import java.util.Scanner;

import Joran_Maxime_Joseph.Projet_Rogue.Creature.Joueur;
import Joran_Maxime_Joseph.Projet_Rogue.Menu.LoadMenu;
import Joran_Maxime_Joseph.Projet_Rogue.Menu.StartMenu;

import java.util.ArrayList;

/**
 * App classe principale qui exécute le programme
 * 
 * @author Joran_Maxime_Joseph
 * @version 1.0
 */
public class App 
{
	/**
	 * Fonction principale du programme 
	 * @param args non utilisé
	 */
    public static void main( String[] args )
    {
        StartMenu menu = new StartMenu();
    	Joueur j = menu.CreerPersonnage();
    	Saisie saisie = new Saisie(j);
    	saisie.jouer();
    }
}