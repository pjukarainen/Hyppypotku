/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyppypotku.hyppypotku.gameframework;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {

    private Game game;

    public GameTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.game = new Game("Hyppypotku", 1024, 768);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void gameHasCorrectNameAndSize() {
        assertEquals("Hyppypotku 1024 x 768", this.game.toString());
    }

    @Test
    public void startMethodSetsBooleanRunningToTrue() {
        assertEquals(false, this.game.isRunning());
        this.game.start();
        assertEquals(true, this.game.isRunning());
    }

    @Test
    public void stopMethodSetsBooleanRunningToFalse() {
        this.game.stop();
        assertEquals(false, this.game.isRunning());
    }

    @Test
    public void initMethodCreatesAProperSizedWindow() {
        this.game.run();
        assertEquals(game.getHeight(), this.game.getWindow().getHeight());
        assertEquals(game.getWidth(), this.game.getWindow().getWidht());
    }

    @Test
    public void runMethodStopsEventually() {
        this.game.run();
        assertEquals(false, this.game.isRunning());
    }
    
    
}
