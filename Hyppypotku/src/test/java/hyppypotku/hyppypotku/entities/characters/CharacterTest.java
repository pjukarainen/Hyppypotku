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
public class CharacterTest {

    private Character character;
    private Game game;

    public CharacterTest() {
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
        this.character = new Stickman(game, 500, 100);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void isGroundedReturnsFalse() {
        assertEquals(false, this.character.isGrounded());
    }

    @Test
    public void isGroundedReturnsTrue() {
        this.character.setY(780);
        assertEquals(true, this.character.isGrounded());
    }

    @Test
    public void isAirborneReturnTrue() {
        this.character.setY(610);
        assertEquals(true, this.character.isAirborne());
    }

    @Test
    public void isAirborneReturnFalse() {
        this.character.setY(750);
        assertEquals(false, this.character.isAirborne());
    }

    @Test
    public void isGroundedFalseMeansAirborneTrue() {
        this.character.setY(200);
        assertEquals(!this.character.isGrounded(), this.character.isAirborne());
    }

    @Test
    public void isGroundedTrueMeansAirborneFalse() {
        this.character.setY(780);
        assertEquals(character.isGrounded(), !this.character.isAirborne());
    }

    @Test
    public void jumpingBackReturnsFalseByDefault() {
        assertEquals(false, this.character.isJumpingBack());
    }

    @Test
    public void isKickingReturnFalseByDefault() {
        assertEquals(false, this.character.isKicking());
    }

    @Test
    public void characterDoesNotGoOffTheScreenLeftSide() {
        this.character.setX(-50);
        this.character.checkOutOfBounds();
        assertEquals(0, (int) this.character.getX());
    }

    @Test
    public void characterDoesNotGoOffTheScreenRightSide() {
        this.character.setX(3000);
        this.character.checkOutOfBounds();
        assertEquals(1024 - this.character.getWidht(), (int) this.character.getX());
    }

    @Test
    public void characterDoesNotGoOffTheScreenFromTop() {
        this.character.setY(-100);
        this.character.checkOutOfBounds();
        assertEquals(0, (int) this.character.getY());
    }

    @Test
    public void characterDoesNotGoOffTheScreenFromBottom() {
        this.character.setY(1000);
        this.character.checkOutOfBounds();
        assertEquals(697 - this.character.getHeight(), (int) this.character.getY());
    }
    
   

}
