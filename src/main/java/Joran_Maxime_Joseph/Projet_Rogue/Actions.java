package Joran_Maxime_Joseph.Projet_Rogue;

import Joran_Maxime_Joseph.Projet_Rogue.Creature.Creature;
import Joran_Maxime_Joseph.Projet_Rogue.Exception.ExceptionAttaqueImpossible;
import Joran_Maxime_Joseph.Projet_Rogue.Exception.ExceptionDeplacementIllegal;
import Joran_Maxime_Joseph.Projet_Rogue.Exception.ExceptionMarcheSurObjet;
import Joran_Maxime_Joseph.Projet_Rogue.Exception.ExceptionOuvrePorte;

/**
 * Action est une enumération représentant les actions des creatures
 * 
 * @author Joran_Maxime_Joseph
 * @version 1.0
 */
public enum Actions {

	/**
	 * Action HAUT
	 */
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
			String ANSI_RED_BACKGROUND = "\u001B[41m";
			String ANSI_BLUE_BACKGROUND = "\u001B[44m";
			String ANSI_RESET = "\u001B[0m";
			String ANSI_BLACK = "\u001B[30m";

			boolean aAttaque = false;
			if(c.equals(t.getPersonnage()))
			{	
				for(int i = 0;i<t.getEnnemis().size();i++)
				{
					if(t.getEnnemis().get(i).getX() == c.getX() -1 && t.getEnnemis().get(i).getY() == c.getY()) {
						t.getEnnemis().get(i).setPv(t.getEnnemis().get(i).getPv()- c.getDegat())  ; 
						System.out.println(ANSI_BLUE_BACKGROUND + ANSI_BLACK + t.getEnnemis().get(i).getNom() + " a moins de pv : " + + t.getEnnemis().get(i).getPv() + ANSI_RESET);
						aAttaque = true;
					}
				}
			}
			else
			{
				if(t.getPersonnage().getX() == c.getX()-1 && t.getPersonnage().getY() == c.getY()) {
					 t.getPersonnage().setPv(t.getPersonnage().getPv() - c.getDegat()) ;
					 System.out.println(ANSI_RED_BACKGROUND + ANSI_BLACK  + c.getNom() + " Vous a infligé : " + + c.getDegat() + ANSI_RESET);
					 aAttaque = true;
				}
			}
			if(aAttaque == false) {
				throw new ExceptionAttaqueImpossible();
			}
		}	
	},
	
	/**
	 * Action BAS
	 */
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

			String ANSI_RED_BACKGROUND = "\u001B[41m";
			String ANSI_BLUE_BACKGROUND = "\u001B[44m";
			String ANSI_RESET = "\u001B[0m";
			String ANSI_BLACK = "\u001B[30m";

			boolean aAttaque = false;
			if(c.equals(t.getPersonnage()))
			{	
				for(int i = 0;i<t.getEnnemis().size();i++)
				{
					if(t.getEnnemis().get(i).getX() == c.getX() +1 && t.getEnnemis().get(i).getY() == c.getY()) {
						t.getEnnemis().get(i).setPv(t.getEnnemis().get(i).getPv()- c.getDegat())  ; 
						System.out.println(ANSI_BLUE_BACKGROUND + ANSI_BLACK + t.getEnnemis().get(i).getNom() + " a moins de pv : " + t.getEnnemis().get(i).getPv() + ANSI_RESET);
						aAttaque = true;
					}
				}
			}
			else
			{
				if(t.getPersonnage().getX() == c.getX()+1 && t.getPersonnage().getY() == c.getY()) {
					 t.getPersonnage().setPv(t.getPersonnage().getPv() - c.getDegat()) ;
					 System.out.println(ANSI_RED_BACKGROUND + ANSI_BLACK + c.getNom() + " Vous a infligé : " + + c.getDegat() + ANSI_RESET);
					 aAttaque = true;
				}
			}
			if(aAttaque == false) {
				throw new ExceptionAttaqueImpossible();
			}
		}
	},
	
	/**
	 * Action GAUCHE
	 */
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
			String ANSI_RED_BACKGROUND = "\u001B[41m";
			String ANSI_BLUE_BACKGROUND = "\u001B[44m";
			String ANSI_RESET = "\u001B[0m";
			String ANSI_BLACK = "\u001B[30m";

			boolean aAttaque = false;
			if(c.equals(t.getPersonnage()))
			{	
				for(int i = 0;i<t.getEnnemis().size();i++)
				{
					if(t.getEnnemis().get(i).getX() == c.getX() && t.getEnnemis().get(i).getY() == c.getY() -1) {
						t.getEnnemis().get(i).setPv(t.getEnnemis().get(i).getPv()- c.getDegat())  ; 
						System.out.println(ANSI_BLUE_BACKGROUND + ANSI_BLACK + t.getEnnemis().get(i).getNom() + " a moins de pv : " + + t.getEnnemis().get(i).getPv() + ANSI_RESET);
						aAttaque = true;
					}
				}
			}
			else
			{
				if(t.getPersonnage().getX() == c.getX() && t.getPersonnage().getY() == c.getY()-1) {
					 t.getPersonnage().setPv(t.getPersonnage().getPv() - c.getDegat()) ;
					 System.out.println(ANSI_RED_BACKGROUND + ANSI_BLACK + c.getNom() + " Vous a infligé : " + + c.getDegat() + ANSI_RESET);
					 aAttaque = true;
				}
			}
			if(aAttaque == false) {
				throw new ExceptionAttaqueImpossible();
			}
		}
	},
	
	/**
	 * Action DROITE
	 */
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
			String ANSI_RED_BACKGROUND = "\u001B[41m";
			String ANSI_BLUE_BACKGROUND = "\u001B[44m";
			String ANSI_RESET = "\u001B[0m";
			String ANSI_BLACK = "\u001B[30m";

			boolean aAttaque = false;
			if(c.equals(t.getPersonnage()))
			{	
				for(int i = 0;i<t.getEnnemis().size();i++)
				{
					if(t.getEnnemis().get(i).getX() == c.getX()  && t.getEnnemis().get(i).getY() == c.getY() + 1) {
						t.getEnnemis().get(i).setPv(t.getEnnemis().get(i).getPv()- c.getDegat())  ;
						System.out.println(ANSI_BLUE_BACKGROUND + ANSI_BLACK + t.getEnnemis().get(i).getNom() + " a moins de pv : " + + t.getEnnemis().get(i).getPv() + ANSI_RESET);
						aAttaque = true;
					} 
				}
			}
			else
			{
				if(t.getPersonnage().getX() == c.getX() && t.getPersonnage().getY() == c.getY()+1) {
					 t.getPersonnage().setPv(t.getPersonnage().getPv() - c.getDegat());
					 System.out.println(ANSI_RED_BACKGROUND + ANSI_BLACK + c.getNom() + " Vous a infligé : " + + c.getDegat() + ANSI_RESET);
					 aAttaque = true;
				}
			}
			if(aAttaque == false) {
				throw new ExceptionAttaqueImpossible();
			}
		}
	};

	private String s;
	
	/**
	 * Constructeur Action
	 * @param str Le symbole de l'Action
	 */
	private Actions(String str)
	{
		this.s=str;
	}
	
	/**
	 * Fonction qui permet aux creatures de se deplacer
	 * @param c qui represente les creatures
	 * @param t qui represente le terrain
	 * @throws ExceptionDeplacementIllegal qui envoie un message lors d'un deplacement illegal
	 * @throws ExceptionMarcheSurObjet qui envoie un message lorsque le joueur marche sur un objet
	 * @throws ExceptionOuvrePorte qui envoie un message lorsque le joueur ouvre une porte
	 */
	public abstract void deplace(Creature c,Terrain t) throws ExceptionDeplacementIllegal, ExceptionMarcheSurObjet, ExceptionOuvrePorte;
	/**
	 * Fonction qui permet aux creatures d'attaquer
	 * @param c qui represente les creatures
	 * @param t qui represente le terrain
	 * @throws ExceptionAttaqueImpossible qui renvoie un message lors d'une attaque impossible
	 */
	public abstract void attaque(Creature c,Terrain t) throws ExceptionAttaqueImpossible;
}
