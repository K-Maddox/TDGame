package WizardTD;

import processing.core.PImage;
import java.util.*;

/**
 * extension of Game Object - shoots fireballs at enemy within its range
*/
public class Tower extends GameObject {

    protected int range;
    protected float firingSpeed;
    protected int damage;
    protected int initial_damage;
    protected int cost;
    protected Monster target;
    protected int increaseRangeCount = 0;
    protected int increaseSpeedCount = 0;
    protected int increaseDamageCount = 0;
    protected int rangeCost = 20;
    protected int speedCost = 20;
    protected int damageCost = 20;

    protected int timer = 0;
    protected float rechargeTime;

    /**
     * Constructor for Tower initialises the below attributes as per the config file
     * @param x
     * @param y
     * @param sprite
     * @param range
     * @param firingSpeed
     * @param damage
     * @param cost
     */
    public Tower(int x, int y, PImage sprite, int range, float firingSpeed, int damage, int cost){
        super(x, y, sprite);
        this.range = range;
        this.firingSpeed = firingSpeed;
        this.damage = damage;
        this.initial_damage = damage;
        this.cost = cost;
        this.rechargeTime = firingSpeed * 60;
    }

    
}