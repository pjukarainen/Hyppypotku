/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyppypotku.hyppypotku.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Pete
 */
public class KeyManager implements KeyListener {

    private boolean[] keys;
    public boolean stickmanJump, stickmanKick, blockmanJump, blockmanKick;

    public KeyManager() {
        keys = new boolean[256];
    }

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
        System.out.println("toimii");

    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;

    }

}
