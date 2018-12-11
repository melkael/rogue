package Joran_Maxime_Joseph.Projet_Rogue;

import java.util.Random;
import java.util.ArrayList;

public class Terrain {
	
	Creature personnage;
	Decor[][] tab;
	int taille;
	
	public Terrain(int taille, Creature personnage) 
	{
		this.taille = taille;
		this.tab = new Decor[taille][taille];
		this.personnage = personnage;
		Init();
	}
	
	public void Init()
	{
		Random rand = new Random();
		
		for(int i = 0; i < taille; i++) {
			for(int j = 0; j < taille; j++) {
				if (rand.nextInt(10) == 0 && (personnage.x != i || personnage.y != j)) {
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
				if (personnage.x == i && personnage.y == j) {
					System.out.print(personnage.symbole);
				}
				else {
					System.out.print(tab[i][j]);
				}
			}
			System.out.println();
		}
	}	
	
	public void deplacerPersonnage(Actions a) {
		a.deplace(personnage, this);
	}
}
