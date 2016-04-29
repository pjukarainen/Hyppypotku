package hyppypotku.hyppypotku.states;

import hyppypotku.hyppypotku.gameframework.Game;
import hyppypotku.hyppypotku.gfx.Assets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Valikko-tila, jossa toiminnallisuus päävalikkoon liittyen.
 */
public class MenuState extends State {

    private BufferedImage menuBackground;

    /**
     * Konstruktori.
     *
     * @param game peli-objekti
     */
    public MenuState(Game game) {
        super(game);
        this.menuBackground = Assets.mainMenuBackground;
    }

    @Override
    public void tick() {
        if (this.game.getKeymanager().startGame) {
            State.setState(this.game.getGameState());
        }

        if (this.game.getKeymanager().showTutorial) {
            State.setState(this.game.getTutorialState());
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(menuBackground, 0, 0, null);
    }
}
