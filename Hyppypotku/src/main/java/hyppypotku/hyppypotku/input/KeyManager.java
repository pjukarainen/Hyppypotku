package hyppypotku.hyppypotku.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Luokka määrittää mistä napeista pelaajat voivat hyppiä ja potkia.
 */
public class KeyManager implements KeyListener {

    private boolean[] keys;
    public boolean stickmanJump, stickmanKick, blockmanJump, blockmanKick;

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
        blockmanJump = keys[KeyEvent.VK_NUMPAD4];
        blockmanKick = keys[KeyEvent.VK_NUMPAD6];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
//        System.out.println("toimii");

    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;

    }

}
