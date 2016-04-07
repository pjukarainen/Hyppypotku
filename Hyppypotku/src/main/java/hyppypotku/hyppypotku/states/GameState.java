/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyppypotku.hyppypotku.states;

import hyppypotku.hyppypotku.entities.characters.Blockman;
import hyppypotku.hyppypotku.entities.characters.Stickman;
import hyppypotku.hyppypotku.gameframework.Game;
import hyppypotku.hyppypotku.gfx.Assets;
import java.awt.Graphics;

/**
 *
 * @author Pete
 */
public class GameState extends State {
    
    private Stickman stickman;
    private Blockman blockman;
    
    public GameState(Game game) {
        super(game);
        stickman = new Stickman(game, 100, 100);
        blockman = new Blockman(game, 300, 100);
    }
    
    @Override
    public void tick() {
        stickman.tick();
        blockman.tick();
        
    }
    
    @Override
    public void render(Graphics g) {
        stickman.render(g);
        blockman.render(g);
        
    }
    
}
