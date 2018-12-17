package Joran_Maxime_Joseph.Projet_Rogue;

import java.util.Random;

import Joran_Maxime_Joseph.Projet_Rogue.Creature.Creature;
import Joran_Maxime_Joseph.Projet_Rogue.Creature.Gobelin;
import Joran_Maxime_Joseph.Projet_Rogue.Creature.Joueur;
import Joran_Maxime_Joseph.Projet_Rogue.Objet.Epee;

import java.util.ArrayList;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Terrain est une classe qui représente la map 
 * 
 * @author Joran_Maxime_Joseph
 * @version 1.0
 */

public class Terrain  implements Serializable{
	
	private ArrayList<Creature> ennemis;
	private Joueur personnage;
	private Decor[][] tab;
	private int taille;
	private Epee epee;
	
	/**
	 * Constructeur avec attribut
	 * @param taille qui représente la taille du terrain
	 * @param personnage qui représente le joueur 
	 * @param ennemis qui repésente la liste d'ennemis
	 * @param epee qui repésente l'epee
	 */
	public Terrain(int taille, Joueur personnage, ArrayList<Creature> ennemis, Epee epee) 
	{
		this.ennemis = ennemis;
		this.taille = taille;
		this.tab = new Decor[taille][taille];
		this.personnage = personnage;
		this.epee = epee;
		Init();
	}

	/**
	 * Constructeur avec attribut personnage
	 * @param personnage qui représente le perso
	 */
	public Terrain(Joueur personnage){
		this.ennemis = new ArrayList<Creature>();
		this.taille = 10;
		this.tab = new Decor[taille][taille];
		this.personnage = personnage;
		this.epee = new Epee();
		Init();
	}
	
	/**
	 * Fonction qui initialise le terrain
	 */
	public void Init()
	{
		Random rand = new Random();

		for(int i = 0; i < taille; i++) {
			for(int j = 0; j < taille; j++) {
				boolean mur_legal = true;
				for (int k = 0 ; k < ennemis.size() ; k++) {
					if (ennemis.get(k).getX() == i && ennemis.get(k).getY() == j) {
						mur_legal = false;
					}
				}
				if ((personnage.getX() == i && personnage.getY() == j) || (epee.getX() == i && epee.getY() == j)) {
					mur_legal = false;
				}
				if (rand.nextInt(10) == 0 && mur_legal) {
					tab[i][j] = Decor.MUR;
				}
				else {
					tab[i][j] = Decor.SOL;
				}
				
			}
		}
		for(int i = 0 ; i < taille ; i++) {
			tab[0][i] = Decor.LIMITE;
			tab[taille - 1][i] = Decor.LIMITE;
			tab[i][0] = Decor.LIMITE;
			tab[i][taille - 1] = Decor.LIMITE;
		}

		int x_porte;
		int y_porte;
		do {
			x_porte = rand.nextInt(taille - 2) + 1;
			y_porte = rand.nextInt(taille - 2) + 1;
		}while(x_porte == epee.getX() && y_porte == epee.getY());
		tab[x_porte][y_porte] = Decor.PORTE;
	}

	/**
	 * Getter du nom de gobelin
	 * @return Jamel le nom du perso
	 */
	private String getRandomGobelinName(){
		return "Jamel";
	}

	/**
	 * Getter du nom de l'epee
	 * @return Excaliburne le nom de l'epee
	 */
	private String getRandomEpeeName(){
		return "Excaliburne";
	}

	/**
	 * Fonction qui initilaise un terrain avec des ennemis et des objets
	 * @param niveau qui représente le niveau du terrain
	 * @return t le terrain
	 */
	public Terrain InitAvecEnnemisEtObjets(int niveau){
		int taille = niveau * 5;
		if (niveau == 0){
			taille = 5;
		}
		ArrayList<Creature> new_ennemis = new ArrayList<Creature>();
		Random rand = new Random();

		int degatsEpee = 0;
		if(niveau == 0){
			degatsEpee = rand.nextInt(5 - 2) + 2;
		}
		else {
			degatsEpee = rand.nextInt(niveau * 10 - niveau * 7) + niveau * 7;
		}
		Epee new_epee = new Epee(getRandomEpeeName(), "T", degatsEpee, 3, 3);

		Terrain t = new Terrain(taille, this.personnage, new_ennemis, new_epee);

		for (int i = 0; i < niveau; i++){
			String nom = "Gobelin " + getRandomGobelinName();
			int pv = rand.nextInt(niveau * 13 - niveau * 5) + niveau * 5;
			int x;
			int y;
			do{
				x = rand.nextInt(taille - 1) + 1;
				y = rand.nextInt(taille - 1) + 1;
			}while(!t.EnnemiEstLegal(x, y));

			Gobelin g = new Gobelin(nom, x, y, 1, pv, 5 * niveau);
			t.getEnnemis().add(g);
		}
		return t;
	}
	
	/**
	 * Fonction qui affiche le terrain
	 */
	public void Affiche() {
		for(int i = 0; i < taille; i++) {
			for(int j = 0; j < taille; j++) {
				boolean ennemi_ici = false;
				boolean ennemiEstSurEpee = false;
				for(int k = 0; k < ennemis.size(); k++) {
					if (ennemis.get(k).estVivant()) {
						if (ennemis.get(k).getX() == i && ennemis.get(k).getY() == j) {
							System.out.print(ennemis.get(k).getSymbole());
							ennemi_ici = true;
						}
						if (ennemis.get(k).getX() == epee.getX() && ennemis.get(k).getY() == epee.getY()){
							ennemiEstSurEpee = true;
						}
					}
					else {
						ennemis.remove(k);
					}
				}
				if (personnage.getX() == i && personnage.getY() == j) {
					System.out.print(personnage.getSymbole());
					ennemi_ici = true;
				}
				if (epee.getX() == i && epee.getY() == j  && !ennemiEstSurEpee) {
					System.out.print(epee.getGlyph());
					ennemi_ici = true;
				}
				if (!ennemi_ici){
					System.out.print(tab[i][j]);
				}
			}
			System.out.println();
		}
	}
	/**
	 * Fonction qui vérifie si un ennemi peut etre positionner 
	 * @param x qui représente les coordonnés x
	 * @param y qui représente les coordonnés y
	 * @return false si c'est pas légal sinon true
	 */
	// à appeller uniquement à la génération du terrain pour verifier que le nouvel ennemi ne va pas etre mis sur le precedent
	public boolean EnnemiEstLegal(int x, int y){
		boolean legal = true;
		for(int i = 0; i < ennemis.size(); i++){
			if(ennemis.get(i).getX() == x && ennemis.get(i).getY() == y){
				legal = false;
			}
		}
		if ((x == 0) || (x >= taille - 1) || (y == 0) || (y >= taille - 1) || (x == epee.getX()) || (y == epee.getY())){
			legal = false;
		}
		return legal;
	}

	/**
	 * Fonction qui permet de sauvegarder dans un fichier
	 * @param nom qui représente le nom du fichier
	 * @throws Exception qui gere l'exception de sauvegarde
	 */
	public void saveToFIle(String nom) throws Exception {
		// write object to file
		FileOutputStream fos = new FileOutputStream(nom + ".sav");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(this);
		oos.close();
	}

	/**
	 * Fonction qui permet de lire un fichier
	 * @param fichier le nom du fichier
	 * @return result le resultat
	 * @throws Exception qui gere l'exception de lecture
	 */
	public Terrain readFromFile(String fichier) throws Exception {
		FileInputStream fis = new FileInputStream(fichier);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Terrain result = (Terrain) ois.readObject();
		ois.close();
		return result;
	}
	
	/**
	 * Getter ennemis qui permet de renvoyer les ennemis
	 * @return ennemis la liste
	 */
	public ArrayList<Creature> getEnnemis() 
	{
		return ennemis;
	}
	/**
	 * Setter ennemi qui permet de modfiier les ennemis
	 * @param ennemis la liste
	 */
	public void setEnnemis(ArrayList<Creature> ennemis) 
	{
		this.ennemis = ennemis;
	}

	/**
	 * Getter personnage qui permet de renvoyer le personnage
	 * @return personnage le perso
	 */
	public Joueur getPersonnage() 
	{
		return personnage;
	}
	
	/**
	 * Setter personnage qui permet de modifier le personnage
	 * @param personnage le perso
	 */
	public void setPersonnage(Joueur personnage) 
	{
		this.personnage = personnage;
	}

	/**
	 * Getter getTab qui renvoie le decor
	 * @return tab le terrain
	 */
	public Decor[][] getTab() 
	{
		return tab;
	}

	/**
	 * Setter tab qui permet de modifier le decor
	 * @param tab le terrain
	 */
	public void setTab(Decor[][] tab) 
	{
		this.tab = tab;
	}

	/**
	 * Getter taile qui permet de renvoyer la taille
	 * @return taille la taille du terrain
	 */
	public int getTaille() 
	{
		return taille;
	}

	/**
	 * Setter taille qui permet de modifier la taille
	 * @param taille la taille du terrain
	 */
	public void setTaille(int taille) 
	{
		this.taille = taille;
	}

	/**
	 *  Getter getEpee qui permet de renvoyer l'epee
	 * @return epee l'epee du perso
	 */
	public Epee getEpee() 
	{
		return epee;
	}

	/**
	 * Setter epee qui permet de modifier l'epee 
	 * @param epee l'epee du perso
	 */
	public void setEpee(Epee epee) 
	{
		this.epee = epee;
	}
}
