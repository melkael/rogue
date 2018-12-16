package Joran_Maxime_Joseph.Projet_Rogue;

public enum Actions {

	HAUT("h")
	{
		@Override
		public void deplace(Creature c,Terrain t) throws ExceptionDeplacementIllegal, ExceptionMarcheSurObjet, ExceptionOuvrePorte
		{
			// verification des collisions avec le mur
			if(c.x < 2 || t.tab[c.x-1][c.y] == Decor.MUR) {
				throw new ExceptionDeplacementIllegal();
			}
			//verification des collisions avec la porte
			if(t.tab[c.x-1][c.y].estOuverte(t)) {
				c.x--;
				throw new ExceptionOuvrePorte();
			}
			//verification des collisions avec les ennemis
			for(int i = 0; i < t.ennemis.size(); i++) {
				Creature en = t.ennemis.get(i);
				if(c.x - 1 == en.x && c.y == en.y) {
					throw new ExceptionDeplacementIllegal();
				}
			}
			//verification des collisions avec le joueurs
			if(c.x -1 == t.personnage.x && c.y == t.personnage.y) {
				throw new ExceptionDeplacementIllegal();
			}
			//verification de collision avec l'epee
			if(c.x -1 == t.epee.x && c.y == t.epee.y) {
				c.x--;
				throw new ExceptionMarcheSurObjet();
			}

			c.x--;
		}
		
		@Override 
		public void attaque(Creature c,Terrain t) throws ExceptionAttaqueImpossible{
			boolean aAttaque = false;
			if(c.equals(t.personnage))
			{	
				for(int i = 0;i<t.ennemis.size();i++)
				{
					if(t.ennemis.get(i).x == c.x -1 && t.ennemis.get(i).y == c.y) {
						t.ennemis.get(i).pv = t.ennemis.get(i).pv- c.degat ; 
						System.out.println(t.ennemis.get(i).nom + " a moins de pv : " + + t.ennemis.get(i).pv);
						aAttaque = true;
					}
				}
			}
			else
			{
				if(t.personnage.x == c.x-1 && t.personnage.y == c.y) {
					 t.personnage.pv = t.personnage.pv - c.degat;
					 System.out.println(c.nom + " Vous a infligé : " + + c.degat);
					 aAttaque = true;
				}
			}
			if(aAttaque == false) {
				throw new ExceptionAttaqueImpossible();
			}
		}	
	},
	
	BAS("b")
	{
		@Override
		public void deplace(Creature c,Terrain t) throws ExceptionDeplacementIllegal, ExceptionMarcheSurObjet, ExceptionOuvrePorte
		{
			if(c.x > t.taille - 3 || t.tab[c.x+1][c.y] == Decor.MUR) {
				throw new ExceptionDeplacementIllegal();
			}
			if(t.tab[c.x+1][c.y].estOuverte(t)) {
				c.x++;
				throw new ExceptionOuvrePorte();
			}
			for(int i = 0; i < t.ennemis.size(); i++) {
				Creature en = t.ennemis.get(i);
				if(c.x + 1 == en.x && c.y == en.y) {
					throw new ExceptionDeplacementIllegal();
				}
			}
			if(c.x + 1 == t.personnage.x && c.y == t.personnage.y) {
				throw new ExceptionDeplacementIllegal();
			}
			if(c.x +1 == t.epee.x && c.y == t.epee.y) {
				c.x++;
				throw new ExceptionMarcheSurObjet();
			}
			c.x++;
		}
		@Override 
		public void attaque(Creature c,Terrain t) throws ExceptionAttaqueImpossible{
			boolean aAttaque = false;
			if(c.equals(t.personnage))
			{	
				for(int i = 0;i<t.ennemis.size();i++)
				{
					if(t.ennemis.get(i).x == c.x +1 && t.ennemis.get(i).y == c.y) {
						t.ennemis.get(i).pv = t.ennemis.get(i).pv- c.degat ; 
						System.out.println(t.ennemis.get(i).nom + " a moins de pv : " + t.ennemis.get(i).pv);
						aAttaque = true;
					}
				}
			}
			else
			{
				if(t.personnage.x == c.x+1 && t.personnage.y == c.y) {
					 t.personnage.pv = t.personnage.pv - c.degat;
					 System.out.println(c.nom + " Vous a infligé : " + + c.degat);
					 aAttaque = true;
				}
			}
			if(aAttaque == false) {
				throw new ExceptionAttaqueImpossible();
			}
		}
	},
	
	GAUCHE("g")
	{
		@Override
		public void deplace(Creature c,Terrain t) throws ExceptionDeplacementIllegal, ExceptionMarcheSurObjet, ExceptionOuvrePorte
		{
			if(c.y < 2 || t.tab[c.x][c.y-1] == Decor.MUR) {
				throw new ExceptionDeplacementIllegal();
			}
			if(t.tab[c.x][c.y-1].estOuverte(t)) {
				c.y--;
				throw new ExceptionOuvrePorte();
			}
			for(int i = 0; i < t.ennemis.size(); i++) {
				Creature en = t.ennemis.get(i);
				if(c.x == en.x && c.y - 1 == en.y) {
					throw new ExceptionDeplacementIllegal();
				}
			}
			if(c.x == t.personnage.x && c.y - 1 == t.personnage.y) {
				throw new ExceptionDeplacementIllegal();
			}
			if(c.x == t.epee.x && c.y - 1 == t.epee.y) {
				c.y--;
				throw new ExceptionMarcheSurObjet();
			}
			c.y--;
		}
		@Override 
		public void attaque(Creature c,Terrain t) throws ExceptionAttaqueImpossible{
			boolean aAttaque = false;
			if(c.equals(t.personnage))
			{	
				for(int i = 0;i<t.ennemis.size();i++)
				{
					if(t.ennemis.get(i).x == c.x && t.ennemis.get(i).y == c.y -1) {
						t.ennemis.get(i).pv = t.ennemis.get(i).pv- c.degat ; 
						System.out.println(t.ennemis.get(i).nom + " a moins de pv : " + + t.ennemis.get(i).pv);
						aAttaque = true;
					}
				}
			}
			else
			{
				if(t.personnage.x == c.x && t.personnage.y == c.y-1) {
					 t.personnage.pv = t.personnage.pv - c.degat;
					 System.out.println(c.nom + " Vous a infligé : " + + c.degat);
					 aAttaque = true;
				}
			}
			if(aAttaque == false) {
				throw new ExceptionAttaqueImpossible();
			}
		}
	},
	
	DROITE("d")
	{
		@Override
		public void deplace(Creature c,Terrain t) throws ExceptionDeplacementIllegal, ExceptionMarcheSurObjet, ExceptionOuvrePorte
		{
			if(c.y > t.taille - 3 || t.tab[c.x][c.y+1] == Decor.MUR) {
				throw new ExceptionDeplacementIllegal();
			}
			if(t.tab[c.x][c.y+1].estOuverte(t)) {
				c.y++;
				throw new ExceptionOuvrePorte();
			}
			for(int i = 0; i < t.ennemis.size(); i++) {
				Creature en = t.ennemis.get(i);
				if(c.x == en.x && c.y + 1 == en.y) {
					throw new ExceptionDeplacementIllegal();
				}
			}
			if(c.x == t.personnage.x && c.y + 1 == t.personnage.y) {
				throw new ExceptionDeplacementIllegal();
			}
			if(c.x == t.epee.x && c.y + 1 == t.epee.y) {
				c.y++;
				throw new ExceptionMarcheSurObjet();
			}
			c.y++;
		}
		@Override 
		public void attaque(Creature c,Terrain t) throws ExceptionAttaqueImpossible{
			boolean aAttaque = false;
			if(c.equals(t.personnage))
			{	
				for(int i = 0;i<t.ennemis.size();i++)
				{
					if(t.ennemis.get(i).x == c.x  && t.ennemis.get(i).y == c.y + 1) {
						t.ennemis.get(i).pv = t.ennemis.get(i).pv- c.degat ;
						System.out.println(t.ennemis.get(i).nom + " a moins de pv : " + + t.ennemis.get(i).pv);
						aAttaque = true;
					} 
				}
			}
			else
			{
				if(t.personnage.x == c.x && t.personnage.y == c.y+1) {
					 t.personnage.pv = t.personnage.pv - c.degat;
					 System.out.println(c.nom + " Vous a infligé : " + + c.degat);
					 aAttaque = true;
				}
			}
			if(aAttaque == false) {
				throw new ExceptionAttaqueImpossible();
			}
		}
	};
	
	private String s;
	
	private Actions(String str)
	{
		this.s=str;
	}
	
	public abstract void deplace(Creature c,Terrain t) throws ExceptionDeplacementIllegal, ExceptionMarcheSurObjet, ExceptionOuvrePorte;
	public abstract void attaque(Creature c,Terrain t) throws ExceptionAttaqueImpossible;
}
