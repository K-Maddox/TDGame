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
}
