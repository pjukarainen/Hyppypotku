package hyppypotku.hyppypotku.entities.characters;

import hyppypotku.hyppypotku.gameframework.Game;
import hyppypotku.hyppypotku.gfx.Assets;
import java.awt.Graphics;

/**
 * Pelin oikealta puolelta aloittava hahmo
 */
public class Blockman extends Character {

    private Game game;

    public Blockman(Game game, float x, float y) {
        super(x, y, Character.DEFAULT_WIDHT, Character.DEFAULT_HEIGHT);
        this.game = game;
    }

    /**
     * Metodi päivittää käyttäjän antamat syötteet ja liikuttaa hahmoa niiden
     * mukaan
     */
    @Override
    public void tick() {
        getInput();
        move();
    }

    /**
     * Määrittää mitä tapahtuu kun hahmo hyppää tai potkii
     */
    public void getInput() {

        if (game.getKeymanager().blockmanJump) {
            yMove = -speed;

        }
        if (game.getKeymanager().blockmanKick) {
            yMove = speed;
            xMove = speed;
        }
    }

    /**
     * Piirtää ruudulle hahmon
     *
     * @param grafiikkaobjekti
     */
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, (int) x, (int) y, widht, height, null);
    }
}
