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

    /**
     * method to change the game object sprite
     * @param sprite
     */
    public void setSprite(PImage sprite){
        this.sprite = sprite;
    }

    /**
     * draws every object to screen
     */
    public void draw(PApplet app){
        app.image(this.sprite, this.x, this.y);
        drawMethodCalled = true;
    }

    /**
     * returns if tower is active
     * @return default set to true
     */
    public boolean towerActive(){
        //handles tower recharge
        return true;
    }

    /**
     * returns tower range
     * @return default 0
     */
    public int getRange(){
        return 0;
    }

    /*
     * resets tower timer
     */
    public void resetTimer(){

    }

    /**
     * returns tower damage
     * @return damage
     */
    public int getDamage(){
        return 0;
    }

    /**
     * returns if monster is in death sequence
     * @return if in death sequence
     */
    public boolean getDeathSequence(){
        return false;
    }

    /**
     * handles logic of every object
     */
    public void tick(){

    }

    /**
     * handles collisions for every object
     */
    public void collide(){

    }

    /**
     * checks collisions for each object
     * @param allMonsters
     * @return default false
     */
    public boolean checkCollision(ArrayList<Monster> allMonsters){
        return false;
    }

    /**
     * checks collision of monster and fireball
     * @param allFireballs
     * @return default false
     */
    public boolean checkFireballCollision(ArrayList<Fireball> allFireballs){
        return false;
    }

    /**
     * returns the target monster
     * @return monster
     */
    public Monster getTarget(){
        return this.target;
    }

    /**
     * returns monster hp
     * @return hp
     */
    public int getHp(){
        return this.hp;
    }


}