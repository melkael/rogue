package Joran_Maxime_Joseph.Projet_Rogue;

public enum Actions {

	HAUT("h")
	{
		@Override
		public void deplace(Creature c,Terrain t)
		{
			c.x--;
		}
	},
	
	BAS("b")
	{
		@Override
		public void deplace(Creature c,Terrain t)
		{
			c.x++;
		}
	},
	
	GAUCHE("g")
	{
		@Override
		public void deplace(Creature c,Terrain t)
		{
			c.y++;
		}
	},
	
	DROITE("d")
	{
		@Override
		public void deplace(Creature c,Terrain t)
		{
			c.y--;
		}
	};
	
	private String s;
	
	private Actions(String str)
	{
		this.s=str;
	}
	
	public abstract void deplace(Creature c,Terrain t);
}
