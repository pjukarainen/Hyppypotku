package hyppypotku.hyppypotku.gfx;

import java.awt.image.BufferedImage;

/**
 * Luokan tehtävänä hallinnoida pelin objekteja.
 */
public class Assets {

    public static BufferedImage hpfull, hpzero, stickman, blockman, roundfull, roundempty, background, mainMenuBackground, tutorialBackground;

    /**
     * Metodi alustaa ja "leikkaa" spritesheetistä objektit omiksi olioikseen.
     */
    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
        SpriteSheet menu = new SpriteSheet(ImageLoader.loadImage("/textures/menuBackground.png"));
        SpriteSheet tutorial = new SpriteSheet(ImageLoader.loadImage("/textures/tutorialBackground.png"));
        SpriteSheet level = new SpriteSheet(ImageLoader.loadImage("/textures/background.png"));

        hpfull = sheet.crop(0, 0, 256, 48);
        hpzero = sheet.crop(0, 48, 256, 48);
        stickman = sheet.crop(0, 96, 96, 160);
        blockman = sheet.crop(256, 96, 96, 160);
        roundfull = sheet.crop(101, 97, 90, 79);
        roundempty = sheet.crop(102, 177, 89, 79);
        background = level.crop(0, 0, 1024, 768);
        mainMenuBackground = menu.crop(0, 0, 1024, 768);
        tutorialBackground = tutorial.crop(0, 0, 1024, 768);

    }
}
