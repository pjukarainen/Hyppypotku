package hyppypotku.hyppypotku.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Luokka, jonka tehtävänä on ladata kuvia.
 */
public class ImageLoader {

    /**
     * Metodi lataa kuvan.
     *
     * @param path tiedostopolku haluttuun kuvaan
     *
     * @return kuva
     */
    public static BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(ImageLoader.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

}
