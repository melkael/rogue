package Joran_Maxime_Joseph.Projet_Rogue;

import java.io.Serializable;


/**
 * Decor est une enumération représentant le décor de la Map
 * 
 * @author Joran_Maxime_Joseph
 * @version 1.0
 */
public enum Decor implements Serializable {
	
	/**
	 * Symbole Du MUR : #
	 */
	MUR("\uD83D\uDD6F️"){
		
		@Override
		public boolean estOuverte(Terrain t){
			return false;
		}
	},
	/**
	 * Symbole Du SOL : caractère vide
	 */
	SOL(" "){
		
		@Override
		public boolean estOuverte(Terrain t){
			return false;
		}
	},
	/**
	 * Symbole De la LIMITE : X
	 */
	LIMITE(".") {
		
		@Override
		public boolean estOuverte(Terrain t) {
			return false;
		}
	},
	/**
	 * Symbole De la PORTE : 0
	 */
	PORTE("\uD83D\uDEAA"){
		
		@Override
		public boolean estOuverte(Terrain t){
			if (t.getEnnemis().isEmpty()){
				return true;
			}
			else{
				return false;
			}
		}
	};

	private String s;
	
	/**
	 * Constructeur Décor
	 * @param str Symbole du Décor
	 */
	private Decor(String str)
	{
		this.s=str;
	}
	/**
	 * Fonction toString de la classe Décor qui retourne le string attendu en fonction de la valeur de l'enum
	 * @return s retourne le symbole du décor
	 */
	public String toString() {
		return s;
	}
	/**
	 * Fonction estOuverte de la classe Décor qui permet de savoir si la porte est ouverte ou non
	 * @param t Prend le Terrain en argument
	 * @return false Si la porte est fermée OU true si la porte est ouverte 
	 * 
	 */
	public abstract boolean estOuverte(Terrain t);
}
