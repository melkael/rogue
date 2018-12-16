package Joran_Maxime_Joseph.Projet_Rogue;
import java.util.Scanner;

import Joran_Maxime_Joseph.Projet_Rogue.Creature.Joueur;
import Joran_Maxime_Joseph.Projet_Rogue.Menu.StartMenu;

import java.util.ArrayList;

public class App 
{
    public static void main( String[] args )
    {
        StartMenu menu = new StartMenu();
    	Joueur j = menu.CreerPersonnage();
    	Saisie saisie = new Saisie(j);
    	saisie.jouer();
    }
}