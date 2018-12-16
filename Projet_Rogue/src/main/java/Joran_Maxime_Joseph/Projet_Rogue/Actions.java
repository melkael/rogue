package Joran_Maxime_Joseph.Projet_Rogue;

import Joran_Maxime_Joseph.Projet_Rogue.Creature.Creature;
import Joran_Maxime_Joseph.Projet_Rogue.Exception.ExceptionAttaqueImpossible;
import Joran_Maxime_Joseph.Projet_Rogue.Exception.ExceptionDeplacementIllegal;
import Joran_Maxime_Joseph.Projet_Rogue.Exception.ExceptionMarcheSurObjet;
import Joran_Maxime_Joseph.Projet_Rogue.Exception.ExceptionOuvrePorte;

public enum Actions {

	HAUT("h")
	{
		@Override
		public void deplace(Creature c,Terrain t) throws ExceptionDeplacementIllegal, ExceptionMarcheSurObjet, ExceptionOuvrePorte
		{
			// verification des collisions avec le mur
			if(c.getX() < 2 || t.getTab()[c.getX()-1][c.getY()] == Decor.MUR) {
				throw new ExceptionDeplacementIllegal();
			}
			//verification des collisions avec la porte
			if(t.getTab()[c.getX()-1][c.getY()].estOuverte(t)) {
				c.setX((c.getX()-1));
				throw new ExceptionOuvrePorte();
			}
			//verification des collisions avec les ennemis
			for(int i = 0; i < t.getEnnemis().size(); i++) {
				Creature en = t.getEnnemis().get(i);
				if(c.getX() - 1 == en.getX() && c.getY() == en.getY()) {
					throw new ExceptionDeplacementIllegal();
				}
			}
			//verification des collisions avec le joueurs
			if(c.getX() -1 == t.getPersonnage().getX() && c.getY() == t.getPersonnage().getY()) {
				throw new ExceptionDeplacementIllegal();
			}
			//verification de collision avec l'epee
			if(c.getX() -1 == t.getEpee().getX() && c.getY() == t.getEpee().getY()) {
				c.setX((c.getX()-1));
				throw new ExceptionMarcheSurObjet();
			}

			c.setX((c.getX()-1));
		}
		
		@Override 
		public void attaque(Creature c,Terrain t) throws ExceptionAttaqueImpossible{
			boolean aAttaque = false;
			if(c.equals(t.getPersonnage()))
			{	
				for(int i = 0;i<t.getEnnemis().size();i++)
				{
					if(t.getEnnemis().get(i).getX() == c.getX() -1 && t.getEnnemis().get(i).getY() == c.getY()) {
						t.getEnnemis().get(i).setPv(t.getEnnemis().get(i).getPv()- c.getDegat())  ; 
						System.out.println(t.getEnnemis().get(i).getNom() + " a moins de pv : " + + t.getEnnemis().get(i).getPv());
						aAttaque = true;
					}
				}
			}
			else
			{
				if(t.getPersonnage().getX() == c.getX()-1 && t.getPersonnage().getY() == c.getY()) {
					 t.getPersonnage().setPv(t.getPersonnage().getPv() - c.getDegat()) ;
					 System.out.println(c.getNom() + " Vous a infligé : " + + c.getDegat());
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
			if(c.getX() > t.getTaille() - 3 || t.getTab()[c.getX()+1][c.getY()] == Decor.MUR) {
				throw new ExceptionDeplacementIllegal();
			}
			if(t.getTab()[c.getX()+1][c.getY()].estOuverte(t)) {
				c.setX(c.getX()+1);
				throw new ExceptionOuvrePorte();
			}
			for(int i = 0; i < t.getEnnemis().size(); i++) {
				Creature en = t.getEnnemis().get(i);
				if(c.getX() + 1 == en.getX() && c.getY() == en.getY()) {
					throw new ExceptionDeplacementIllegal();
				}
			}
			if(c.getX() + 1 == t.getPersonnage().getX() && c.getY() == t.getPersonnage().getY()) {
				throw new ExceptionDeplacementIllegal();
			}
			if(c.getX() +1 == t.getEpee().getX() && c.getY() == t.getEpee().getY()) {
				c.setX(c.getX()+1);
				throw new ExceptionMarcheSurObjet();
			}
			c.setX(c.getX()+1);
		}
		@Override 
		public void attaque(Creature c,Terrain t) throws ExceptionAttaqueImpossible{
			boolean aAttaque = false;
			if(c.equals(t.getPersonnage()))
			{	
				for(int i = 0;i<t.getEnnemis().size();i++)
				{
					if(t.getEnnemis().get(i).getX() == c.getX() +1 && t.getEnnemis().get(i).getY() == c.getY()) {
						t.getEnnemis().get(i).setPv(t.getEnnemis().get(i).getPv()- c.getDegat())  ; 
						System.out.println(t.getEnnemis().get(i).getNom() + " a moins de pv : " + t.getEnnemis().get(i).getPv());
						aAttaque = true;
					}
				}
			}
			else
			{
				if(t.getPersonnage().getX() == c.getX()+1 && t.getPersonnage().getY() == c.getY()) {
					 t.getPersonnage().setPv(t.getPersonnage().getPv() - c.getDegat()) ;
					 System.out.println(c.getNom() + " Vous a infligé : " + + c.getDegat());
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
			if(c.getY() < 2 || t.getTab()[c.getX()][c.getY()-1] == Decor.MUR) {
				throw new ExceptionDeplacementIllegal();
			}
			if(t.getTab()[c.getX()][c.getY()-1].estOuverte(t)) {
				c.setY(c.getY()-1);
				throw new ExceptionOuvrePorte();
			}
			for(int i = 0; i < t.getEnnemis().size(); i++) {
				Creature en = t.getEnnemis().get(i);
				if(c.getX() == en.getX() && c.getY() - 1 == en.getY()) {
					throw new ExceptionDeplacementIllegal();
				}
			}
			if(c.getX() == t.getPersonnage().getX() && c.getY() - 1 == t.getPersonnage().getY()) {
				throw new ExceptionDeplacementIllegal();
			}
			if(c.getX() == t.getEpee().getX() && c.getY() - 1 == t.getEpee().getY()) {
				c.setY(c.getY()-1);
				throw new ExceptionMarcheSurObjet();
			}
			c.setY(c.getY()-1);
		}
		@Override 
		public void attaque(Creature c,Terrain t) throws ExceptionAttaqueImpossible{
			boolean aAttaque = false;
			if(c.equals(t.getPersonnage()))
			{	
				for(int i = 0;i<t.getEnnemis().size();i++)
				{
					if(t.getEnnemis().get(i).getX() == c.getX() && t.getEnnemis().get(i).getY() == c.getY() -1) {
						t.getEnnemis().get(i).setPv(t.getEnnemis().get(i).getPv()- c.getDegat())  ; 
						System.out.println(t.getEnnemis().get(i).getNom() + " a moins de pv : " + + t.getEnnemis().get(i).getPv());
						aAttaque = true;
					}
				}
			}
			else
			{
				if(t.getPersonnage().getX() == c.getX() && t.getPersonnage().getY() == c.getY()-1) {
					 t.getPersonnage().setPv(t.getPersonnage().getPv() - c.getDegat()) ;
					 System.out.println(c.getNom() + " Vous a infligé : " + + c.getDegat());
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
			if(c.getY() > t.getTaille() - 3 || t.getTab()[c.getX()][c.getY()+1] == Decor.MUR) {
				throw new ExceptionDeplacementIllegal();
			}
			if(t.getTab()[c.getX()][c.getY()+1].estOuverte(t)) {
				c.setY(c.getY()+1);
				throw new ExceptionOuvrePorte();
			}
			for(int i = 0; i < t.getEnnemis().size(); i++) {
				Creature en = t.getEnnemis().get(i);
				if(c.getX() == en.getX() && c.getY() + 1 == en.getY()) {
					throw new ExceptionDeplacementIllegal();
				}
			}
			if(c.getX() == t.getPersonnage().getX() && c.getY() + 1 == t.getPersonnage().getY()) {
				throw new ExceptionDeplacementIllegal();
			}
			if(c.getX() == t.getEpee().getX() && c.getY() + 1 == t.getEpee().getY()) {
				c.setY(c.getY()+1);
				throw new ExceptionMarcheSurObjet();
			}
			c.setY(c.getY()+1);
		}
		@Override 
		public void attaque(Creature c,Terrain t) throws ExceptionAttaqueImpossible{
			boolean aAttaque = false;
			if(c.equals(t.getPersonnage()))
			{	
				for(int i = 0;i<t.getEnnemis().size();i++)
				{
					if(t.getEnnemis().get(i).getX() == c.getX()  && t.getEnnemis().get(i).getY() == c.getY() + 1) {
						t.getEnnemis().get(i).setPv(t.getEnnemis().get(i).getPv()- c.getDegat())  ;
						System.out.println(t.getEnnemis().get(i).getNom() + " a moins de pv : " + + t.getEnnemis().get(i).getPv());
						aAttaque = true;
					} 
				}
			}
			else
			{
				if(t.getPersonnage().getX() == c.getX() && t.getPersonnage().getY() == c.getY()+1) {
					 t.getPersonnage().setPv(t.getPersonnage().getPv() - c.getDegat());
					 System.out.println(c.getNom() + " Vous a infligé : " + + c.getDegat());
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
