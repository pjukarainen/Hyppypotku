/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyppypotku.hyppypotku.entities.characters;

import hyppypotku.hyppypotku.gameframework.Game;
import hyppypotku.hyppypotku.gfx.Assets;
import java.awt.Graphics;

/**
 *
 * @author Pete
 */
public class Blockman extends Character {

    private Game game;

    public Blockman(Game game, float x, float y) {
        super(x, y, Character.DEFAULT_WIDHT, Character.DEFAULT_HEIGHT);
        this.game = game;
    }

    @Override
    public void tick() {
        if (game.getKeymanager().blockmanJump) {
            y -= 5;
        }
        if (game.getKeymanager().blockmanKick) {
            y += 5;
            x -= 5;
        }

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, (int) x, (int) y, null);
    }
}
