package hyppypotku.hyppypotku;

import hyppypotku.hyppypotku.dom.Pelaaja;
import hyppypotku.hyppypotku.gameframework.Game;
import hyppypotku.hyppypotku.window.Window;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String args[]) {
        Game game = new Game("Hyppypotku", 1024, 768);
        game.start();

    }
}
