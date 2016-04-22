package hyppypotku.hyppypotku.gfx;

import java.awt.image.BufferedImage;

/**
 * Tehtävänä käsitellä spritesheetia, josta voi leikata useita kuvia.
 */
public class SpriteSheet {

    private BufferedImage sheet;

    /**
     * Konstruktori.
     *
     * @param sheet kuva
     */
    public SpriteSheet(BufferedImage sheet) {
        this.sheet = sheet;
    }

    /**
     * Leikkaa palan spritesheetistä.
     *
     * @param x kuvan x-koordinaatti
     * @param y kuvan y-koordinaatti
     * @param widht kuvan leveys
     * @param height kuvan korkeus
     * @return pala
     */
    public BufferedImage crop(int x, int y, int widht, int height) {
        return sheet.getSubimage(x, y, widht, height);
    }
}
