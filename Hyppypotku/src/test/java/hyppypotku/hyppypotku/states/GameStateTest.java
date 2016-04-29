/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyppypotku.hyppypotku.states;

import com.sun.glass.events.KeyEvent;
import hyppypotku.hyppypotku.gameframework.Game;
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
public class GameStateTest {

    private GameState gameState;
    private Game game;

    public GameStateTest() {
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
        this.gameState = new GameState(this.game, this.game.getStickman(), this.game.getBlockman());
    }

    @After
    public void tearDown() {
    }

    @Test
    public void roundResetsCorrectlyForStickman() {
        this.game.getStickman().setX(500);
        this.game.getStickman().setY(0);
        this.gameState.resetRound();
        assertEquals(200, (int) this.game.getStickman().getX());
        assertEquals(this.game.getHeight() - 100, (int) this.game.getStickman().getY());
    }

    @Test
    public void roundResetsCorrectlyForBlockman() {
        this.game.getBlockman().setX(100);
        this.game.getBlockman().setY(1000);
        this.gameState.resetRound();
        assertEquals(800, (int) this.game.getBlockman().getX());
        assertEquals(this.game.getHeight() - 100, (int) this.game.getBlockman().getY());
    }

 

}
