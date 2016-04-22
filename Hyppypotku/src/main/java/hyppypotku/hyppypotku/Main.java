package hyppypotku.hyppypotku;

import hyppypotku.hyppypotku.gameframework.Game;
import hyppypotku.hyppypotku.window.Window;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Käynnistys-luokka.
 */
public class Main {

    /**
     * Main-metodi luo pelin ja käynnistää sen.
     * @param args main-juttuja
     */
    public static void main(String args[]) {
        Game game = new Game("Hyppypotku", 1024, 768);
        game.start();

    }
}
