package Joran_Maxime_Joseph.Projet_Rogue;

public enum Actions {

	HAUT("h")
	{
		@Override
		public void deplace(Creature c,Terrain t) throws ExceptionDeplacementIllegal
		{
			if(c.x < 2) {
				throw new ExceptionDeplacementIllegal();
			}
			c.x--;
		}
	},
	
	BAS("b")
	{
		@Override
		public void deplace(Creature c,Terrain t) throws ExceptionDeplacementIllegal
		{
			if(c.x > t.taille - 3) {
				throw new ExceptionDeplacementIllegal();
			}
			c.x++;
		}
	},
	
	GAUCHE("g")
	{
		@Override
		public void deplace(Creature c,Terrain t) throws ExceptionDeplacementIllegal
		{
			if(c.y < 2) {
				throw new ExceptionDeplacementIllegal();
			}
			c.y--;
		}
	},
	
	DROITE("d")
	{
		@Override
		public void deplace(Creature c,Terrain t) throws ExceptionDeplacementIllegal
		{
			if(c.y > t.taille - 3) {
				throw new ExceptionDeplacementIllegal();
			}
			c.y++;
		}
	};
	
	private String s;
	
	private Actions(String str)
	{
		this.s=str;
	}
	
	public abstract void deplace(Creature c,Terrain t) throws ExceptionDeplacementIllegal;
}
