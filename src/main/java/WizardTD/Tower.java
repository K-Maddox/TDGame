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

    /**
     * returns cost of tower to build
     * @return cost
     */
    public int getCost(){
        return this.cost;
    }

    /**
     * increases the range when U1 is selected
     */
    @Override
    public void increaseRange(){
        if (this.increaseRangeCount < 3){
            this.range += 32; //upgrade increases range by 1 tile (32 pixels)
            increaseRangeCount++;
            if (this.rangeCost < 40){
                this.rangeCost = this.rangeCost + 10;
            }
        }
    }

    /**
     * increases the firing speed with U2 is selected
     */
    @Override
    public void increaseFiringSpeed(){
        if (this.increaseSpeedCount < 3){
            this.firingSpeed += 0.5; //upgrade increases fireball per second speed by 0.5
            increaseSpeedCount++;
            if (this.speedCost < 40){
                this.speedCost = this.speedCost + 10;
            }
        }
    }

    /**
     * increases the damage when U3 is selected
     */
    @Override
    public void increaseDamage(){
        if (increaseDamageCount < 3){
            this.damage += this.initial_damage * 0.5; //upgrade increases damage by half of initial_tower_damage
            increaseDamageCount++;
            if (this.damageCost < 40){
                this.damageCost = this.damageCost + 10;
            }
        }
    }

    /**
     * returns the number of range upgrades made
     * @return count of range upgrades
     */
    @Override
    public int getIncreaseRangeCount(){
        return this.increaseRangeCount;
    }

    /**
     * returns the number of firing speed upgrades made
     * @return count of firing speed upgrades
     */
    @Override
    public int getIncreaseSpeedCount(){
        return this.increaseSpeedCount;
    }

    /**
     * returns the number of damage upgrades made
     * @return count of damage upgrades
     */
    @Override
    public int getIncreaseDamageCount(){
        return this.increaseDamageCount;
    }

}