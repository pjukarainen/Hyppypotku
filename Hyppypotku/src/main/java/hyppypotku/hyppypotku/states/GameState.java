package hyppypotku.hyppypotku.states;

import hyppypotku.hyppypotku.entities.characters.Character;
import hyppypotku.hyppypotku.entities.characters.Blockman;
import hyppypotku.hyppypotku.entities.characters.Stickman;
import hyppypotku.hyppypotku.gameframework.Game;
import hyppypotku.hyppypotku.gfx.Assets;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 * Peli-tila, jossa asetetaan hahmojen aloitussijainti sekä päivitetään ja
 * piirretään hahmot ruudulle.
 */
public class GameState extends State {

    private Stickman stickman;
    private Blockman blockman;
    private BufferedImage background;

    /**
     * Konstruktori.
     *
     * @param game peli
     * @param stickman ykköspelaajan hahmo
     * @param blockman kakkospelaajan hahmo
     */
    public GameState(Game game, Stickman stickman, Blockman blockman) {
        super(game);
        background = Assets.background;
        this.stickman = stickman;
        this.blockman = blockman;

    }

    public BufferedImage getBackground() {
        return background;
    }

    @Override
    public void tick() {
        this.stickman.tick();
        this.blockman.tick();
        checkCollisions();

        if (this.game.getKeymanager().startGame) {
            this.stickman.setLives(5);
            this.blockman.setLives(5);
            resetRound();
        }

        if (this.game.getKeymanager().mainMenu) {
            State.setState(this.game.getMenuState());
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(background, 0, 0, null);
        this.stickman.render(g);
        this.blockman.render(g);
        drawLives(g, stickman, 15, 20);
        drawLives(g, blockman, 920, 20);

        if (this.stickman.getLives() == 0) {
            drawWinner(g, this.blockman);
        }

        if (this.blockman.getLives() == 0) {
            drawWinner(g, this.stickman);
        }

    }

    private void drawWinner(Graphics g, Character c) {
        String msg = c.toString() + " wins!";
        String restart = "ENTER: start a new game";
        String menu = "ESCAPE: go back to Main Menu";
        Font small = new Font("Helvetica", Font.BOLD, 18);

        g.setColor(Color.RED);
        g.setFont(small);
        g.drawString(msg, 465, 100);
        g.drawString(restart, 433, 150);
        g.drawString(menu, 409, 200);
    }

    private void drawLives(Graphics g, Character c, int x, int y) {
        String msg = c.toString() + ": " + c.getLives();
        Font lives = new Font("Helvetica", Font.BOLD, 16);

        g.setColor(Color.BLACK);
        g.setFont(lives);
        g.drawString(msg, x, y);
    }

    /**
     * Tehtävänä tarkistaa törmääkö hahmot toisiinsa.
     */
    public void checkCollisions() {
        Rectangle playerOne = stickman.getHitbox();
        Rectangle playerTwo = blockman.getHitbox();

        if (playerOne.intersects(playerTwo) && this.stickman.getHitboxActive() && this.stickman.getY() <= this.blockman.getY()) {
            this.blockman.loseLives();
            resetRound();
        } else if (playerOne.intersects(playerTwo) && this.blockman.getHitboxActive() && this.blockman.getY() <= this.stickman.getY()) {
            this.stickman.loseLives();
            resetRound();
        }
    }

    /**
     * Asettaa hahmot takaisin aloituspaikoilleen.
     */
    public void resetRound() {
        this.stickman.setX(200);
        this.stickman.setY(this.game.getHeight() - 100);

        this.blockman.setX(800);
        this.blockman.setY(this.game.getHeight() - 100);
    }

}
