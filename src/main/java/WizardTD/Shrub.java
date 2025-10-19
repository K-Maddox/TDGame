package WizardTD;

import processing.core.PImage;

/**
 * extension of Game Object - towers can not be placed here
 */
public class Shrub extends GameObject {

    /**
     * Constructor for Shrub initialises the below attributes
     * @param x
     * @param y
     * @param sprite
     */
    public Shrub(int x, int y, PImage sprite){
        super(x, y, sprite);
    }
}