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
	 * Constructeur Terrain
	 * @param taille qui représente la taille du terrain
	 * @param personnage qui représente le joueur 
	 * @param ennemis qui représente la liste d'ennemis
	 * @param epee qui représente l'epee
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
	 * Constructeur Terrain
	 * @param personnage qui représente le joueur
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
	 * Getter getRandomGobelinName()
	 * @return le nom du Gobelin
	 */
	private String getRandomGobelinName(){
		String[] array = {"Oulboou", "Potter", "Gilet Jaune", "Johnson", "Zombie", "Flibustier", "Lepreux"};
		int rnd = new Random().nextInt(array.length);
		return array[rnd];
	}

	/**
	 * Getter getRandomEpeeName()
	 * @return le nom de l'epee
	 */
	private String getRandomEpeeName(){
		String[] array = {"Excalibur", "Sabre Laser", "Katana Kawai", "Epee Daedra", "Baton magique", "Dague aiguisée"};
		int rnd = new Random().nextInt(array.length);
		return array[rnd];
	}

	/**
	 * Fonction qui initialise un terrain avec des ennemis et des objets
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
		int x_epee = 0;
		int y_epee = 0;
		x_epee = rand.nextInt(taille - 2) + 1;
		y_epee = rand.nextInt(taille - 2) + 1;
		Epee new_epee;

		if (niveau > 1) {
			new_epee = new Epee(getRandomEpeeName(), "\uD83D\uDDE1️", degatsEpee, x_epee, y_epee);
		}
		else {
			new_epee = new Epee(getRandomEpeeName(), "\uD83D\uDDE1️", degatsEpee, 3, 3);
		}
		this.personnage.setMana(this.personnage.getMana() + 15);
		if (this.personnage.getMana() > 50)
			this.personnage.setMana(50);

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

			Gobelin g = new Gobelin(nom, x, y, pv, 5 * niveau);
			t.getEnnemis().add(g);
		}
		return t;
	}
	
	/**
	 * Fonction Affiche() qui affiche le terrain
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
	 * Fonction EnnemiEstLegal qui vérifie si un ennemi peut etre positionné
	 * @param x qui représente la coordonnée x
	 * @param y qui représente la coordonnée y
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
	 * Fonction saveToFIle qui permet de sauvegarder le jeu dans un fichier
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
	 * Fonction readFromFile qui permet de lire un fichier
	 * @param fichier qui représente le nom du fichier
	 * @return result qui retourne le resultat
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
	 * Getter getEnnemis() 
	 * @return ennemis qui renvoie la liste d'ennemis
	 */
	public ArrayList<Creature> getEnnemis() 
	{
		return ennemis;
	}
	

	/**
	 * Getter getPersonnage()  
	 * @return personnage qui permet de renvoyer le personnage
	 */
	public Joueur getPersonnage() 
	{
		return personnage;
	}

	/**
	 * Getter getTab()
	 * @return tab qui renvoie le terrain
	 */
	public Decor[][] getTab() 
	{
		return tab;
	}

	/**
	 * Getter getTaille() qui permet de renvoyer la taille
	 * @return taille qui permet de renvoyer la taille du terrain
	 */
	public int getTaille() 
	{
		return taille;
	}

	/**
	 *  Getter getEpee() 
	 * @return epee qui permet de renvoyer l'epee
	 */
	public Epee getEpee() 
	{
		return epee;
	}

	/**
	 * Setter setEpee(Epee epee) 
	 * @param epee qui permet de modifier l'epee 
	 */
	public void setEpee(Epee epee) 
	{
		this.epee = epee;
	}
}
