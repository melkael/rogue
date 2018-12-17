package Joran_Maxime_Joseph.Projet_Rogue.Divers;

import java.util.Arrays;

public class Correcteur {
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

    public static int costOfSubstitution(char a, char b) {
        return a == b ? 0 : 1;
    }

    public static int min(int... numbers) {
        return Arrays.stream(numbers)
                .min().orElse(Integer.MAX_VALUE);
    }

    public String corriger(String x){
        if (calculate(x, "go gauche") == 1){
            return "go gauche";
        }
		else if(calculate(x, "go droite") == 1){
            return "go droite";
        }
        else if(calculate(x, "go bas") == 1){
            return "go bas";
        }
        else if(calculate(x, "go haut") == 1){
            return "go haut";
        }
        else if(calculate(x, "atk droite") == 1){
            return "atk droite";
        }
        else if(calculate(x, "atk gauche") == 1){
            return "atk gauche";
        }
        else if(calculate(x, "atk bas") == 1){
            return "atk bas";
        }
        else if(calculate(x, "atk haut") == 1){
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
