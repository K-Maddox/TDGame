package WizardTD;

import processing.core.PImage;

/**
 * Extension of MovableObject - they are shot from towers and can damage or kill monsters
*/
public class Fireball extends MovableObject {
    
    protected int speed = 5; //fireball moves at 5 pixels per tick
    protected int damage;
    
    protected Monster target;
    
    protected int destX;
    protected int destY;
    protected int xVel = this.speed;
    protected int yVel = this.speed;

    /**
     * Constructor for Fireballs initialises the below attributes
     * @param x
     * @param y
     * @param sprite
     * @param damage
     * @param target
     */
    public Fireball(int x, int y, PImage sprite, int damage, Monster target){
        super(x, y, sprite);
        this.target = target;
        this.damage = damage;
        this.destX = target.getX();
        this.destY = target.getY();
    }

    
}