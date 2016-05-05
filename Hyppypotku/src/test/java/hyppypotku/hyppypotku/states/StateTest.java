/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyppypotku.hyppypotku.states;

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
public class StateTest {

    private State menuState;
    private State tutorialState;
    private Game game;

    public StateTest() {
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
        this.menuState = new MenuState(game);
        this.tutorialState = new TutorialState(game);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void statesReturnProperly() {
        State.setState(menuState);
        assertEquals(menuState, State.getState());
    }

    @Test
    public void statesSwitchProperly() {
        State.setState(menuState);
        assertEquals(menuState, State.getState());
        State.setState(tutorialState);
        assertEquals(tutorialState, State.getState());
    }
}
