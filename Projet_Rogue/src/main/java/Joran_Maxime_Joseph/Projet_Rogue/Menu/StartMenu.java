package Joran_Maxime_Joseph.Projet_Rogue.Menu;

import Joran_Maxime_Joseph.Projet_Rogue.Creature.Joueur;

import java.util.Scanner;

public class StartMenu {
    public StartMenu(){

    }
    public Joueur CreerPersonnage(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenue dans ASCIImpossible, c'est leur de la création de ton personnage !");
        System.out.println("D'abord, héros, quel est ton nom ?");
        String nom = sc.nextLine();
        String classe;
        while (true){
            System.out.println("Maintenant tu dois choisir ta classe, es tu plutot un ASSASSIN ou un CHEVALIER ?");
            classe = sc.nextLine();
            if (classe.equalsIgnoreCase("ASSASSIN") || classe.equalsIgnoreCase("CHEVALIER")){
               break;
            }
            System.out.println("Choisis ta classe petit malin !");
        }
        int pv, atk;
        if (classe.equalsIgnoreCase("ASSASSIN")){
            System.out.println("Tu seras donc un assassin : 30pv de base et 15 de dégats !");
            pv = 30;
            atk = 15;
        }
        else {
            System.out.println("Tu seras donc un preux chevalier : 50pv de base et 7 de dégats !");
            pv = 50;
            atk = 7;
        }
        Joueur j = new Joueur(nom, 2, 2, 1, pv, atk, 1, 0);
        return j;
    }
}