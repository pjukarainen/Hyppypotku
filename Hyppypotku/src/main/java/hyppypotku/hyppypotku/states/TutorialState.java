package hyppypotku.hyppypotku.states;

import hyppypotku.hyppypotku.gameframework.Game;
import hyppypotku.hyppypotku.gfx.Assets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Opastus-tila, jossa toiminnallisuus pelin ohjeisiin.
 */
public class TutorialState extends State {

    private BufferedImage tutorialBackground;

    /**
     * Konstruktori.
     *
     * @param game
     */
    public TutorialState(Game game) {
        super(game);
        this.tutorialBackground = Assets.tutorialBackground;
    }

    @Override
    public void tick() {
        if (this.game.getKeymanager().startGame) {
            State.setState(this.game.getGameState());
        }

        if (this.game.getKeymanager().mainMenu) {
            State.setState(this.game.getMenuState());
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(tutorialBackground, 0, 0, null);

    }

}
