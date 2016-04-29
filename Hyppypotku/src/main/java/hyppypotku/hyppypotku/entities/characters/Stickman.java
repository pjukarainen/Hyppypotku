package hyppypotku.hyppypotku.entities.characters;

import hyppypotku.hyppypotku.gameframework.Game;
import hyppypotku.hyppypotku.gfx.Assets;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Pelin vasemmalta puolelta aloittava hahmo.
 */
public class Stickman extends Character {

    private Game game;
    private Boolean hitboxActive;

    /**
     * Konstruktori.
     *
     * @param game peli-objekti
     * @param x x-koordinaatti
     * @param y y-koordinaatti
     */
    public Stickman(Game game, float x, float y) {
        super(x, y, Character.DEFAULT_WIDHT, Character.DEFAULT_HEIGHT);
        this.game = game;
        this.hitboxActive = false;

    }

    /**
     * Metodi päivittää käyttäjän antamat syötteet ja liikuttaa hahmoa niiden
     * mukaan.
     */
    @Override
    public void tick() {
        getInput();
        move();

    }

    /**
     * Määrittää mitä tapahtuu kun hahmo hyppää tai potkii.
     */
    public void getInput() {
        if (!isAirborne()) {
            this.hitboxActive = false;
            yMove = 0;
            xMove = 0;
        }

        if (game.getKeymanager().stickmanJump) {
            if (!isAirborne()) {
                this.hitboxActive = false;
                yMove = -speed;
            }

        }
        if (game.getKeymanager().stickmanKick) {
            if (isAirborne() && !isJumpingBack() && !isKicking()) {
                this.hitboxActive = true;
                yMove = speed;
                xMove = posOrNeg() * speed;
            }
            if (isGrounded()) {
                this.hitboxActive = false;
                yMove = -speed / 5;
                xMove = posOrNeg() * (-speed / 2);

            }
        }
    }

    /**
     * Selvittää onko pelihahmo vasemmanpuolimmaisin.
     *
     * @return boolean
     */
    public boolean isLeftmost() {
        if (this.x < this.game.getBlockman().getX()) {
            return true;
        }
        return false;
    }

    private int posOrNeg() {
        if (isLeftmost()) {
            return 1;
        }
        return -1;
    }

    public Boolean getHitboxActive() {
        return hitboxActive;
    }

    /**
     * Vähentää hahmon elämiä.
     */
    public void loseLives() {
        this.lives--;
    }

    @Override
    public int getLives() {
        return this.lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
    
    

    /**
     * Asettaa hahmon aloituspaikan.
     *
     * @param coordX hahmon x-koordinaatti
     * @param coordY hahmon y-koordinaatti
     */
    public void setStartPos(int coordX, int coordY) {
        this.x = coordX;
        this.y = coordY;
    }

    /**
     * Piirtää ruudulle hahmon.
     *
     * @param grafiikkaobjekti
     */
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.stickman, (int) x, (int) y, widht, height, null);
    }

    @Override
    public String toString() {
        return "Stickman";
    }

}
