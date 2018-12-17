package Joran_Maxime_Joseph.Projet_Rogue;

/**
 * Decor est une enumération représentant le décor de la Map
 * 
 * @author Joran_Maxime_Joseph
 * @version 1.0
 */
import java.io.Serializable;


public enum Decor implements Serializable {
	
	/**
	 * Symbole Du MUR : #
	 */
	MUR("#"){
		
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
	LIMITE("X") {
		
		@Override
		public boolean estOuverte(Terrain t) {
			return false;
		}
	},
	/**
	 * Symbole De la PORTE : 0
	 */
	PORTE("0"){
		
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

	/**
	 * Attribut String s
	 */
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
	 * Fonction estOuverte de la classe Décor qui retourne le string attendu en fonction de la valeur de l'enum
	 * @param t Prend le Terrain en argument
	 * @return false Si la porte est fermée OU true si la porte est ouverte 
	 * 
	 */
	public abstract boolean estOuverte(Terrain t);
}
