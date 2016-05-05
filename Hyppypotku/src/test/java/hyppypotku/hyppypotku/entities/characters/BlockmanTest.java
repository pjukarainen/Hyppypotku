/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyppypotku.hyppypotku.entities.characters;

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
public class BlockmanTest {

    private Blockman blockman;
    private Game game;

    public BlockmanTest() {
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
        this.blockman = new Blockman(game, 200, this.game.getHeight() - 100);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void constructorSetsHitboxActiveToFalse() {
        assertEquals(false, this.blockman.getHitboxActive());
    }

    @Test
    public void livesAreLost() {
        assertEquals(5, this.blockman.getLives());
        this.blockman.loseLives();
        assertEquals(4, this.blockman.getLives());
    }

    @Test
    public void isLeftMost() {
        assertEquals(false, this.blockman.isLeftmost());
        this.blockman.setX(0);
        assertEquals(true, this.blockman.isLeftmost());
    }
}
