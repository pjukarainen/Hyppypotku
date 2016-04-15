package hyppypotku.hyppypotku.entities.characters;

import hyppypotku.hyppypotku.entities.Entity;

/**
 * Luokka toimii pelin pelattavien hahmojen yliluokkana
 */
public abstract class Character extends Entity {

    public static final int DEFAULT_LIVES = 5;
    public static final int DEFAULT_WIDHT = 48;
    public static final int DEFAULT_HEIGHT = 80;
    public static final float DEFAULT_SPEED = 10.0f;

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
        gravity = 0.15f;
    }

    /**
     * Metodin tehtävänä liikuttaa hahmoa ja määrittää painovoiman vaikutus
     */
    public void move() {
        x += xMove;
        y += yMove;
        yMove += gravity;
        checkOutOfBounds();
    }

    protected boolean isGrounded() {
        if (y >= 697 - this.height) {
            return true;
        }

        return false;
    }

    protected boolean isAirborne() {
        if (y <= 696 - this.height) {
            return true;
        }
        return false;
    }

    protected boolean isJumpingBack() {
        if (yMove == (-speed / 2) || xMove == (-speed / 2)) {
            return true;
        }

        if (yMove == (speed / 2) || xMove == (speed / 2)) {
            return true;
        }

        return false;
    }

    protected boolean isKicking() {
        if (xMove == speed || xMove == -speed) {
            return true;
        }
        return false;
    }

    private void checkOutOfBounds() {
        if (x <= 0) {
            x = 0;
        }

        if (x >= 1024 - this.widht) {
            x = 1024 - this.widht;
        }

        if (y <= 0) {
            y = 0;
        }

        if (y >= 697 - this.height) {
            y = 697 - this.height;
        }
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
