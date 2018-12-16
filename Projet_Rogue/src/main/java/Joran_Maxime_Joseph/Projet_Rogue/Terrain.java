package Joran_Maxime_Joseph.Projet_Rogue;

import java.util.Random;
import java.util.ArrayList;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Terrain  implements Serializable{
	
	ArrayList<Creature> ennemis;
	Joueur personnage;
	Decor[][] tab;
	int taille;
	Epee epee;
	
	public Terrain(int taille, Joueur personnage, ArrayList<Creature> ennemis, Epee epee) 
	{
		this.ennemis = ennemis;
		this.taille = taille;
		this.tab = new Decor[taille][taille];
		this.personnage = personnage;
		this.epee = epee;
		Init();
	}
	
	public void Init()
	{
		Random rand = new Random();

		for(int i = 0; i < taille; i++) {
			for(int j = 0; j < taille; j++) {
				boolean mur_legal = true;
				for (int k = 0 ; k < ennemis.size() ; k++) {
					if (ennemis.get(k).x == i && ennemis.get(k).y == j) {
						mur_legal = false;
					}
				}
				if ((personnage.x == i && personnage.y == j) || (epee.x == i && epee.y == j)) {
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


		int x_porte = rand.nextInt(taille - 2) + 1;
		int y_porte = rand.nextInt(taille - 2) + 1;
		tab[x_porte][y_porte] = Decor.PORTE;
	}
	
	public void Affiche() {
		for(int i = 0; i < taille; i++) {
			for(int j = 0; j < taille; j++) {
				boolean ennemi_ici = false;
				for(int k = 0; k < ennemis.size(); k++) {
					if (ennemis.get(k).estVivant()) {
						if (ennemis.get(k).x == i && ennemis.get(k).y == j) {
							System.out.print(ennemis.get(k).symbole);
							ennemi_ici = true;
						}
					}
					else {
						ennemis.remove(k);
					}
				}
				if (personnage.x == i && personnage.y == j) {
					System.out.print(personnage.symbole);
					ennemi_ici = true;
				}
				if (epee.x == i && epee.y == j) {
					System.out.print(epee.glyph);
					ennemi_ici = true;
				}
				else if (!ennemi_ici){
					System.out.print(tab[i][j]);
				}
			}
			System.out.println();
		}
	}
	// à appeller uniquement à la génération du terrain pour verifier que le nouvel ennemi ne va pas etre mis sur le precedent
	public boolean EnnemiEstLegal(int x, int y){
		boolean legal = true;
		for(int i = 0; i < ennemis.size(); i++){
			if(ennemis.get(i).x == x && ennemis.get(i).y == y){
				legal = false;
			}
		}
		if ((x == 0) || (x >= taille - 1) || (y == 0) || (y >= taille - 1) || (x == epee.x) || (y == epee.y)){
			legal = false;
		}
		return legal;
	}

	public void saveToFIle() throws Exception {
		// write object to file
		FileOutputStream fos = new FileOutputStream("terrain.sav");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(this);
		oos.close();
	}

	public Terrain readFromFile() throws Exception {
		FileInputStream fis = new FileInputStream("terrain.sav");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Terrain result = (Terrain) ois.readObject();
		ois.close();
		return result;
	}
}
