package WizardTD;

import processing.core.PImage;

/**
 * extension of Game Object - towers can be placed here
 */
public class Grass extends GameObject {

    /**
     * Constructor for Grass initialises the below attributes
     * @param x
     * @param y
     * @param sprite
     */
    public Grass(int x, int y, PImage sprite){
        super(x, y, sprite);
    }
}