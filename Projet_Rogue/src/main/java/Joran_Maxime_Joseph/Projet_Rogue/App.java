package Joran_Maxime_Joseph.Projet_Rogue;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc= new Scanner(System.in);
    	Joueur j = new Joueur("Jojo", 5, 5, 1, 10, 5, 1, 0);
    	Terrain t = new Terrain(10, j);
    	
       while(true)
       {
    	   for(int i = 0; i < 100; i++) {System.out.println();}
           t.Affiche();
           String s=sc.nextLine();
           t.deplacerPersonnage(Actions.HAUT);
       }
    }
}