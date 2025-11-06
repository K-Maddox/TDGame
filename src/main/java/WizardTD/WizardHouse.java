package WizardTD;

import processing.core.PImage;
import java.util.*;

/**
 * extension of Game Object - if enemies reach then mana decrease by remaining HP
 */
public class WizardHouse extends GameObject {

    protected Monster target;

    /**
     * Constructor for WizardHouse initialises the below attributes
     * @param x
     * @param y
     * @param sprite
     */
    public WizardHouse(int x, int y, PImage sprite){
        super(x, y, sprite);
    }

    /**
     * returns the monster which has reached the wizard house and has been banished
     * @return monster
     */
    public Monster getTarget(){
        return this.target;
    }

    /**
     * captures the monster that has reached the wizard house
     * @param monster
     */
    public void setTarget(Monster monster){
        this.target = monster;
    }

}