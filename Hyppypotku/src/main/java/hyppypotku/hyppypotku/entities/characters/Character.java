/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyppypotku.hyppypotku.entities.characters;

import hyppypotku.hyppypotku.entities.Entity;

/**
 *
 * @author Pete
 */
public abstract class Character extends Entity {
    
    public static final int DEFAULT_LIVES = 5;
    public static final int DEFAULT_WIDHT = 96;
    public static final int DEFAULT_HEIGHT = 160;
    
    protected int lives;

    public Character(float x, float y, int widht, int height) {
        super(x, y, widht, height);
        lives = DEFAULT_LIVES;
    }

}
