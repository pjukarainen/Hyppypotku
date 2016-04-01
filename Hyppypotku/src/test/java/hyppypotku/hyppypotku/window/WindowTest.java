/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyppypotku.hyppypotku.window;

import java.awt.Dimension;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pete
 */
public class WindowTest {
    
    Window window;
    
    public WindowTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.window = new Window("Hyppypotku", 1920, 1080);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void constructorSetsSizeAndNameRight() {
        assertEquals("Hyppypotku 1920 x 1080", window.toString());
    }
    
    @Test
    public void windowIsNotResizable() {
        assertEquals(false,this.window.getFrame().isResizable());
    }
    
    @Test
    public void windowIsVisible() {
        assertEquals(true,this.window.getFrame().isVisible());
    }
    
   @Test
   public void canvasHasMinimumSize() {
       Dimension dimension = new Dimension(this.window.getWidht(), this.window.getHeight());
       assertEquals(dimension, this.window.getCanvas().getMinimumSize());
   }
   
   @Test
   public void canvasHasMaximumSize() {
       Dimension dimension = new Dimension(this.window.getWidht(), this.window.getHeight());
       assertEquals(dimension, this.window.getCanvas().getMaximumSize());
   }
}
