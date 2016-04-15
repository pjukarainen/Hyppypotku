package hyppypotku.hyppypotku.gfx;

import java.awt.image.BufferedImage;

/**
 * Tehtävänä käsitellä spritesheetia, josta voi leikata useita kuvia
 */
public class SpriteSheet {

    private BufferedImage sheet;

    public SpriteSheet(BufferedImage sheet) {
        this.sheet = sheet;
    }

    /**
     * Leikkaa palan spritesheetistä
     *
     * @param x
     * @param y
     * @param widht
     * @param height
     * @return kuva, joka on parametrien mukainen
     */
    public BufferedImage crop(int x, int y, int widht, int height) {
        return sheet.getSubimage(x, y, widht, height);
    }
}
