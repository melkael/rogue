package Joran_Maxime_Joseph.Projet_Rogue;
import java.util.Scanner;

import Joran_Maxime_Joseph.Projet_Rogue.Creature.Joueur;

import java.util.ArrayList;

public class App 
{
    public static void main( String[] args )
    {
    	Joueur j = new Joueur("Jojo", 2, 2, 1, 10, 5, 1, 0);
    	Saisie saisie = new Saisie(j);
    	saisie.jouer();
    }
}