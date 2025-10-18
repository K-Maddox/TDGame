package WizardTD;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * extension of Game Objects for all objects that move i.e. monsters and fireball
 */
public class MovableObject extends GameObject {

    protected int xVel = 0;
    protected int yVel = 0;
    protected boolean alive;

    /**
     * constructor for movable objects includes the attribute alive
     * @param x
     * @param y
     * @param sprite
     */
    public MovableObject(int x, int y, PImage sprite) {
        super(x, y, sprite);
        this.alive = true;
    }

    
}
