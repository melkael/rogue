package Joran_Maxime_Joseph.Projet_Rogue;

import java.util.Random;
import java.util.ArrayList;

public class Terrain {
	
	ArrayList<Creature> ennemis;
	Creature personnage;
	Decor[][] tab;
	int taille;
	
	public Terrain(int taille, Creature personnage, ArrayList<Creature> ennemis) 
	{
		this.ennemis = ennemis;
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
				boolean mur_legal = true;
				for (int k = 0 ; k < ennemis.size() ; k++) {
					if (ennemis.get(k).x == i && ennemis.get(k).y == j) {
						mur_legal = false;
					}
					if (personnage.x == i && personnage.y == j) {
						mur_legal = false;
					}
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
					if (ennemis.get(k).x == i && ennemis.get(k).y == j) {
						System.out.print(ennemis.get(k).symbole);
						ennemi_ici = true;
					}
				}
				
				if (personnage.x == i && personnage.y == j) {
					System.out.print(personnage.symbole);
				}
				else if (!ennemi_ici){
					System.out.print(tab[i][j]);
				}
			}
			System.out.println();
		}
	}	
	
	public void deplacerPersonnage(Actions a) throws ExceptionDeplacementIllegal{
			a.deplace(personnage, this);
	}
	
	public void deplacerEnnemis() throws ExceptionDeplacementIllegal{
		Actions a;
		Random rand = new Random();
		int r = rand.nextInt();
		for(int i = 0; i < ennemis.size(); i++) {
			r = rand.nextInt(4);
			if(r == 0) {
				a = Actions.HAUT;
			}
			else if(r == 1) {
				a = Actions.BAS;
			}
			else if(r == 2) {
				a = Actions.GAUCHE;
			}
			else {
				a = Actions.DROITE;
			}
			a.deplace(ennemis.get(i), this);
		}
	}
	public void attaquerPersonnage(Actions a)
	{
		a.attaque(personnage,this);
	}
	
}
