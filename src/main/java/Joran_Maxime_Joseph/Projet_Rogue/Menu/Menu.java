package Joran_Maxime_Joseph.Projet_Rogue.Menu;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Menu est une classe qui représente le menu
 * 
 * @author Joran_Maxime_Joseph
 * @version 1.0
 */
public class Menu {
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
	/**
	 * Fonction AsciiArt qui permet de créer un beau menu de départ
	 * @param str qui prend un string en entrée
	 */
    public void AsciiArt(String str){
        try {
            BufferedImage image = new BufferedImage(144, 32, BufferedImage.TYPE_INT_RGB);
            Graphics g = image.getGraphics();
            g.setFont(new Font("Dialog", Font.PLAIN, 24));
            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                    RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            graphics.drawString(str, 6, 24);
            ImageIO.write(image, "png", new File("text.png"));

            for (int y = 0; y < 32; y++) {
                StringBuilder sb = new StringBuilder();
                for (int x = 0; x < 144; x++)
                    sb.append(image.getRGB(x, y) == -16777216 ? " " : image.getRGB(x, y) == -1 ? "#" : "*");
                if (sb.toString().trim().isEmpty()) continue;
                System.out.println(sb);
            }

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Fonction padding() qui permet de structurer le menu
     */
    public void padding(){
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 120; i++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }
}
