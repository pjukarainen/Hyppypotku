/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyppypotku.hyppypotku.gameframework;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * @author Pete
 */
public abstract class Canvas extends JPanel implements KeyListener, MouseListener {

    private static boolean[] keyboardState = new boolean[525]; //onko nappi alhaalla vai ei
    private static boolean[] mouseState = new boolean[3]; //onko hiiren nappi alhaalla vai ei

    public Canvas() {
        this.setDoubleBuffered(true);
    }

    
    
}
