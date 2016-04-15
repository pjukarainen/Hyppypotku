package hyppypotku.hyppypotku.states;

import hyppypotku.hyppypotku.entities.characters.Blockman;
import hyppypotku.hyppypotku.entities.characters.Stickman;
import hyppypotku.hyppypotku.gameframework.Game;
import hyppypotku.hyppypotku.gfx.Assets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Peli-tila, jossa asetetaan hahmojen aloitussijainti sekä päivitetään ja
 * piirretään hahmot ruudulle
 */
public class GameState extends State {

    private Stickman stickman;
    private Blockman blockman;
    private BufferedImage background;

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
        stickman.tick();
        blockman.tick();

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(background, 0, 0, null);
        stickman.render(g);
        blockman.render(g);

    }

}
