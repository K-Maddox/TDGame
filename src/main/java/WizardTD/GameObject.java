package WizardTD;

import processing.core.PApplet;
import processing.core.PImage;
import java.util.*;

/**
 * Abstract super class for all objects
 */
public abstract class GameObject {
    
    protected int x;
    protected int y;
    protected PImage sprite;
    protected Monster target;
    protected int hp;
    protected boolean drawMethodCalled = false;

    /**
     * constructor for all objects that require being drawn
     * @param x
     * @param y
     * @param sprite
     */
    public GameObject(int x, int y, PImage sprite){
        this.x = x;
        this.y = y;
        this.sprite = sprite;
    }

    /**
     * returns x coordinate
     * @return x
     */
    public int getX(){
        return this.x;
    }

    /**
     * returns y coordinate
     * @return y
     */
    public int getY(){
        return this.y;
    }

    /**
     * returns sprite width
     * @return width
     */
    public int getWidth(){
        return this.sprite.width;
    }

    /**
     * returns sprite height
     * @return height
     */
    public int getHeight(){
        return this.sprite.height;
    }

    /**
     * returns sprite used
     * @return sprite
     */
    public PImage getSprite(){
        return this.sprite;
    }
}
