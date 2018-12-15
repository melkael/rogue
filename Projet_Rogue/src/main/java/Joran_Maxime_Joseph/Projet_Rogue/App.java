package Joran_Maxime_Joseph.Projet_Rogue;
import java.util.Scanner;
import java.util.ArrayList;

public class App 
{
    public static void main( String[] args )
    {
    	Joueur j = new Joueur("Jojo", 5, 5, 1, 10, 5, 1, 0);
    	Gobelin g1 = new Gobelin("Gobelin Jamel", 2, 3, 1, 10, 5);
    	Gobelin g2 = new Gobelin("Gobelin Abdel", 1, 4, 1, 10, 5);
    	Gobelin g3 = new Gobelin("Gobelin Lakrim", 7, 2, 1, 10, 5);
    	ArrayList<Creature> ennemis = new ArrayList<Creature>();
    	ennemis.add(g1);
    	ennemis.add(g2);
    	ennemis.add(g3);
    	
    	Epee epee = new Epee("Excaliburne", "T", 10, 8, 8);
    	
    	Terrain t = new Terrain(10, j, ennemis, epee);
    	
    	Saisie saisie = new Saisie(t);
    	saisie.jouer();
    }
}