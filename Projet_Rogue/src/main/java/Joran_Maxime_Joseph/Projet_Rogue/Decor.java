package Joran_Maxime_Joseph.Projet_Rogue;

public enum Decor{
	
	MUR("#"),SOL(" "),PORTE("0"),LIMITE("X");
	
	private String s;
	
	private Decor(String str)
	{
		this.s=str;
	}
	
	public String toString() {
		return s;
	}

}
