/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyppypotku.hyppypotku.entities;

import java.awt.Graphics;

/**
 *
 * @author Pete
 */
public abstract class Entity {

    protected float x, y;
    protected int widht, height;

    public Entity(float x, float y, int widht, int height) {
        this.x = x;
        this.y = y;
        this.widht = widht;
        this.height = height;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public int getHeight() {
        return height;
    }

    public int getWidht() {
        return widht;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidht(int widht) {
        this.widht = widht;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }
    
    
}
