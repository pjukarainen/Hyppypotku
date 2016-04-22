package hyppypotku.hyppypotku.states;

import hyppypotku.hyppypotku.gameframework.Game;
import java.awt.Graphics;

/**
 * Luokka on muiden tila-luokkien yliluokka.
 */
public abstract class State {

    private static State currentState = null;

    public static void setState(State state) {
        currentState = state;
    }

    public static State getState() {
        return currentState;
    }

    protected Game game;

    /**
     * Konstruktori.
     *
     * @param game peli-objekti
     */
    public State(Game game) {
        this.game = game;
    }

    /**
     * Periville luokille päivitys-metodi.
     */
    public abstract void tick();

    /**
     * Periville luokille piirtämis-metodi.
     *
     * @param g grafiikka-objekti
     */
    public abstract void render(Graphics g);
}
