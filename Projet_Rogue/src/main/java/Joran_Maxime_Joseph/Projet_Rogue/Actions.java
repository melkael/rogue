package Joran_Maxime_Joseph.Projet_Rogue;

public enum Actions {

	HAUT("h")
	{
		@Override
		public void deplace(Creature c,Terrain t) throws ExceptionDeplacementIllegal
		{
			// verification des collisions avec le mur
			if(c.x < 2 || t.tab[c.x-1][c.y] == Decor.MUR) {
				throw new ExceptionDeplacementIllegal();
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
			c.x--;
		}
		
		@Override 
		public void attaque(Creature c,Terrain t) {
			if(c == t.personnage)
			{	
				for(int i = 0;i<t.ennemis.size();i++)
				{
					if(t.ennemis.get(i).x == c.x -1 && t.ennemis.get(i).y == c.y)
						t.ennemis.get(i).pv = t.ennemis.get(i).pv- c.degat ; 
				}
			}
			else
			{
				if(t.personnage.x-1 == c.x && t.personnage.y == c.y)
					 t.personnage.pv = t.personnage.pv - c.degat;
			}
		}	
	},
	
	BAS("b")
	{
		@Override
		public void deplace(Creature c,Terrain t) throws ExceptionDeplacementIllegal
		{
			if(c.x > t.taille - 3 || t.tab[c.x+1][c.y] == Decor.MUR) {
				throw new ExceptionDeplacementIllegal();
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
			c.x++;
		}
		@Override 
		public void attaque(Creature c,Terrain t) {
			if(c == t.personnage)
			{	
				for(int i = 0;i<t.ennemis.size();i++)
				{
					if(t.ennemis.get(i).x == c.x +1 && t.ennemis.get(i).y == c.y)
						t.ennemis.get(i).pv = t.ennemis.get(i).pv- c.degat ; 
				}
			}
			else
			{
				if(t.personnage.x+1 == c.x && t.personnage.y == c.y)
					 t.personnage.pv = t.personnage.pv - c.degat;
			}
		}
	},
	
	GAUCHE("g")
	{
		@Override
		public void deplace(Creature c,Terrain t) throws ExceptionDeplacementIllegal
		{
			if(c.y < 2 || t.tab[c.x][c.y-1] == Decor.MUR) {
				throw new ExceptionDeplacementIllegal();
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
			c.y--;
		}
		@Override 
		public void attaque(Creature c,Terrain t) {
			if(c == t.personnage)
			{	
				for(int i = 0;i<t.ennemis.size();i++)
				{
					if(t.ennemis.get(i).x == c.x && t.ennemis.get(i).y-1 == c.y)
						t.ennemis.get(i).pv = t.ennemis.get(i).pv- c.degat ; 
				}
			}
			else
			{
				if(t.personnage.x == c.x && t.personnage.y-1 == c.y)
					 t.personnage.pv = t.personnage.pv - c.degat;
			}
		}
	},
	
	DROITE("d")
	{
		@Override
		public void deplace(Creature c,Terrain t) throws ExceptionDeplacementIllegal
		{
			if(c.y > t.taille - 3 || t.tab[c.x][c.y+1] == Decor.MUR) {
				throw new ExceptionDeplacementIllegal();
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
			c.y++;
		}
		@Override 
		public void attaque(Creature c,Terrain t) {
			if(c == t.personnage)
			{	
				for(int i = 0;i<t.ennemis.size();i++)
				{
					if(t.ennemis.get(i).x == c.x  && t.ennemis.get(i).y+1 == c.y)
						t.ennemis.get(i).pv = t.ennemis.get(i).pv- c.degat ; 
				}
			}
			else
			{
				if(t.personnage.x == c.x && t.personnage.y+1 == c.y)
					 t.personnage.pv = t.personnage.pv - c.degat;
			}
		}
	};
	
	private String s;
	
	private Actions(String str)
	{
		this.s=str;
	}
	
	public abstract void deplace(Creature c,Terrain t) throws ExceptionDeplacementIllegal;
	public abstract void attaque(Creature c,Terrain t);
}
