package WizardTD;

import processing.core.PImage;

/**
 * extension of Game Object - enemies traverse the path to reach the wizard house
 */
public class Path extends GameObject {

    /**
     * Constructor for Paths initialises the below attributes
     * @param x
     * @param y
     * @param sprite
     */
    public Path(int x, int y, PImage sprite){
        super(x, y, sprite);
    }
}