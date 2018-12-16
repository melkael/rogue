package Joran_Maxime_Joseph.Projet_Rogue;

import java.io.Serializable;

public enum Decor implements Serializable {
	
	MUR("#"){
		@Override
		public boolean estOuverte(Terrain t){
			return false;
		}
	},
	SOL(" "){
		@Override
		public boolean estOuverte(Terrain t){
			return false;
		}
	},
	LIMITE("X") {
		@Override
		public boolean estOuverte(Terrain t) {
			return false;
		}
	},
	PORTE("0"){
		@Override
		public boolean estOuverte(Terrain t){
			if (t.ennemis.isEmpty()){
				return true;
			}
			else{
				return false;
			}
		}
	};

	private String s;
	
	private Decor(String str)
	{
		this.s=str;
	}
	
	public String toString() {
		return s;
	}

	public abstract boolean estOuverte(Terrain t);


}
