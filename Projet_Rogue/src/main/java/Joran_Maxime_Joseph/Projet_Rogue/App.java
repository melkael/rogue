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
    	   // for(int i = 0; i < 100; i++) {System.out.println();}
           t.Affiche();
           String s=sc.nextLine();
           try {
        	   System.out.println(s);
        	   
        	   if (s.equals("haut")) {
        		   t.deplacerPersonnage(Actions.HAUT);
        	   }
        	   else if (s.equals("bas")) {
        		   t.deplacerPersonnage(Actions.BAS);
        	   }
        	   else if (s.equals("gauche")) {
        		   t.deplacerPersonnage(Actions.GAUCHE);
        	   }
        	   else if (s.equals("droite")) {
        		   t.deplacerPersonnage(Actions.DROITE);
        	   }
           }
           catch (ExceptionDeplacementIllegal e) {
        	   e.getMessage();
        	   continue;
           }
       }
    }
}