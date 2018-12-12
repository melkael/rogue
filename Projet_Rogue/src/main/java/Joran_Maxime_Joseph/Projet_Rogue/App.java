package Joran_Maxime_Joseph.Projet_Rogue;
import java.util.Scanner;
import java.util.ArrayList;

public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc= new Scanner(System.in);
    	Joueur j = new Joueur("Jojo", 5, 5, 1, 10, 5, 1, 0);
    	Gobelin g1 = new Gobelin("Gobelin Jamel", 5, 3, 1, 10, 5);
    	Gobelin g2 = new Gobelin("Gobelin Abdel", 5, 4, 1, 10, 5);
    	Gobelin g3 = new Gobelin("Gobelin Lakrim", 5, 2, 1, 10, 5);
    	ArrayList<Creature> ennemis = new ArrayList<Creature>();
    	ennemis.add(g1);
    	ennemis.add(g2);
    	ennemis.add(g3);
    	
    	Terrain t = new Terrain(10, j, ennemis);
    	
    	String s="";
    	
       while(!s.equals("exit"))
       {
    	   // for(int i = 0; i < 100; i++) {System.out.println();}
           t.Affiche();
           s=sc.nextLine();
           try {
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
        	   else {
        		   System.out.println("Mauvaise commande !!");
        	   }
        	   t.deplacerEnnemis();
           }
           catch (ExceptionDeplacementIllegal e) {
        	   System.out.println(e.getMessage());
        	   continue;
           }          
       }
       
       sc.close();
       System.exit(0);
    }
}