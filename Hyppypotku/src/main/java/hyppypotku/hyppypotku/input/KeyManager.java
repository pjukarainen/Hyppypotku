package hyppypotku.hyppypotku.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Luokka määrittää mistä napeista pelaajat voivat hyppiä ja potkia.
 */
public class KeyManager implements KeyListener {

    private boolean[] keys;
    public boolean stickmanJump, stickmanKick, blockmanJump, blockmanKick, mainMenu, startGame, showTutorial;

    /**
     * Konstruktori.
     */
    public KeyManager() {
        keys = new boolean[256];
    }

    /**
     * Asettaa pelattavien hahmojen napit.
     */
    public void tick() {
        stickmanJump = keys[KeyEvent.VK_A];
        stickmanKick = keys[KeyEvent.VK_D];
        blockmanJump = keys[KeyEvent.VK_LEFT];
        blockmanKick = keys[KeyEvent.VK_RIGHT];
        mainMenu = keys[KeyEvent.VK_ESCAPE];
        startGame = keys[KeyEvent.VK_ENTER];
        showTutorial = keys[KeyEvent.VK_T];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;

    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;

    }

}
