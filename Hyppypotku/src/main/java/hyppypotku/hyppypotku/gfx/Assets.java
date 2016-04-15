package hyppypotku.hyppypotku.gfx;

import java.awt.image.BufferedImage;

/**
 * Luokan tehtävänä hallinnoida pelin objekteja
 */
public class Assets {

    public static BufferedImage hpfull, hpzero, player, roundfull, roundempty;

    /**
     * Metodi alustaa ja "leikkaa" spritesheetistä objektit omiksi olioikseen
     */
    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));

        hpfull = sheet.crop(0, 0, 256, 48);
        hpzero = sheet.crop(0, 48, 256, 48);
        player = sheet.crop(0, 96, 96, 160);
        roundfull = sheet.crop(101, 97, 90, 79);
        roundempty = sheet.crop(102, 177, 89, 79);

    }
}
