package Joran_Maxime_Joseph.Projet_Rogue.Divers;

import java.util.Arrays;

/**
 * Correcteur est une classe qui permet de corriger les mauvaises commandes de l'utilisateur
 * 
 * @author Joran_Maxime_Joseph
 * @version 1.0
 */

public class Correcteur {
	
	/**
	 * Fonction qui calcule la distance d'édition entre 2 strings
	 * @param x String x
	 * @param y String y
	 * @return renvoie la distance d'edition
	 */
    public static int calculate(String x, String y) {
        int[][] dp = new int[x.length() + 1][y.length() + 1];

        for (int i = 0; i <= x.length(); i++) {
            for (int j = 0; j <= y.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                }
                else if (j == 0) {
                    dp[i][j] = i;
                }
                else {
                    dp[i][j] = min(dp[i - 1][j - 1]
                                    + costOfSubstitution(x.charAt(i - 1), y.charAt(j - 1)),
                            dp[i - 1][j] + 1,
                            dp[i][j - 1] + 1);
                }
            }
        }
        return dp[x.length()][y.length()];
    }

    /**
     * Fonction costOfSubstitution
     * @param a char a
     * @param b char b
     * @return 0 si a et b sont egaux et 1 sinon
     */
    public static int costOfSubstitution(char a, char b) {
        return a == b ? 0 : 1;
    }

    /**
     * Fonction min
     * @param numbers nombres de modifications
     * @return qui renvoie un entier
     */
    public static int min(int... numbers) {
        return Arrays.stream(numbers)
                .min().orElse(Integer.MAX_VALUE);
    }

    /**
     * Fonction corriger qui corrige les mauvaises commandes
     * @param x String qui doit etre corriger
     * @return qui renvoie le bon String
     */
    public String corriger(String x){
        if (calculate(x, "go gauche") <= 2){
            return "go gauche";
        }
		else if(calculate(x, "go droite") <= 2){
            return "go droite";
        }
        else if(calculate(x, "go bas") <= 2){
            return "go bas";
        }
        else if(calculate(x, "go haut") <= 2){
            return "go haut";
        }
        else if(calculate(x, "atk droite") <= 2){
            return "atk droite";
        }
        else if(calculate(x, "atk gauche") <= 2){
            return "atk gauche";
        }
        else if(calculate(x, "atk bas") <= 2){
            return "atk bas";
        }
        else if(calculate(x, "atk haut") <= 2){
            return "atk haut";
        }
        else if(calculate(x, "save") == 1){
            return "save";
        }
        else if(calculate(x, "load") == 1){
            return "load";
        }
        return "";
    }
}
