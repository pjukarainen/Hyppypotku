package hyppypotku.hyppypotku.entities.characters;

import hyppypotku.hyppypotku.entities.Entity;

/**
 * Luokka toimii pelin pelattavien hahmojen yliluokkana
 */
public abstract class Character extends Entity {

    public static final int DEFAULT_LIVES = 5;
    public static final int DEFAULT_WIDHT = 48;
    public static final int DEFAULT_HEIGHT = 80;
    public static final float DEFAULT_SPEED = 5.0f;

    protected int lives;
    protected float xMove, yMove;
    protected float speed;
    protected boolean jumping = false;
    protected boolean falling = true;
    protected float vDelta; //vertical delta
    protected float gravity; //gravity, how much vDelta is reduced

    public Character(float x, float y, int widht, int height) {
        super(x, y, widht, height);
        lives = DEFAULT_LIVES;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
        gravity = 0.05f;
    }

    /**
     * Metodin tehtävänä liikuttaa hahmoa ja määrittää painovoiman vaikutus
     */
    public void move() {
        x += xMove;
        y += yMove;
        yMove += gravity;
    }

    public float getxMove() {
        return xMove;
    }

    public float getyMove() {
        return yMove;
    }

    @Override
    public int getHeight() {
        return super.getHeight();
    }

    public int getLives() {
        return lives;
    }

    @Override
    public int getWidht() {
        return super.getWidht();
    }

}
