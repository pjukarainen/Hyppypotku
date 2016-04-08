/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyppypotku.hyppypotku.gfx;

import java.awt.image.BufferedImage;

/**
 *
 * @author Pete
 */
public class Assets {
    
    public static BufferedImage hpfull, hpzero, player, roundfull, roundempty;
    
    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
        
        hpfull = sheet.crop(0, 0, 256, 48);
        hpzero = sheet.crop(0, 48, 256, 48);
        player = sheet.crop(0, 96, 96, 160);
        roundfull = sheet.crop(101, 97, 90, 79);
        roundempty = sheet.crop(102, 177, 89, 79);
        
    }
}
