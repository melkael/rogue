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
