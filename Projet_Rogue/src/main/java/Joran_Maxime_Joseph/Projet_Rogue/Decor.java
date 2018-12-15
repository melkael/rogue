package Joran_Maxime_Joseph.Projet_Rogue;

public enum Decor{
	
	MUR("\uD83D\uDDFB"),SOL(" "),PORTE("\uD83D\uDEAA"),LIMITE("\uD83D\uDEA7");
	
	private String s;
	
	private Decor(String str)
	{
		this.s=str;
	}
	
	public String toString() {
		return s;
	}

}
