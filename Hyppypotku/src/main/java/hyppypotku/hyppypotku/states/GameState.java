package hyppypotku.hyppypotku.states;

import hyppypotku.hyppypotku.entities.characters.Blockman;
import hyppypotku.hyppypotku.entities.characters.Stickman;
import hyppypotku.hyppypotku.gameframework.Game;
import hyppypotku.hyppypotku.gfx.Assets;
import java.awt.Graphics;

/**
 * Peli-tila, jossa asetetaan hahmojen aloitussijainti sekä päivitetään ja
 * piirretään hahmot ruudulle
 */
public class GameState extends State {

    private Stickman stickman;
    private Blockman blockman;

    public GameState(Game game) {
        super(game);
        stickman = new Stickman(game, 200, this.game.getHeight() - 80);
        blockman = new Blockman(game, 800, this.game.getHeight() - 80);
    }

    @Override
    public void tick() {
        stickman.tick();
        blockman.tick();

    }

    @Override
    public void render(Graphics g) {
        stickman.render(g);
        blockman.render(g);

    }

}
