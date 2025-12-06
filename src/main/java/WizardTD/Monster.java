package WizardTD;

import processing.core.PImage;
import java.awt.Point;
import java.util.*;

/**
 * Extension of MovableObject - this stores all attributes for enemy objects
 */
public class Monster extends MovableObject {

    protected int hp;
    protected int startHp;
    protected float speed;
    protected float armour;
    protected int manaGained;
    protected boolean deathSequence = false;
    protected int timer;
    protected int timerEnd = 20; //5 images for 4 frames each

    protected WizardHouse target;
    protected Fireball fireball;
    protected ArrayList<GameObject> allPaths; //for pathfinding

    /**
     * Constructor for each monster initalises the below attributes
     * @param x
     * @param y
     * @param sprite
     * @param target
     * @param hp
     * @param speed
     * @param armour
     * @param manaGained
     * @param allPaths
     */
    public Monster(int x, int y, PImage sprite, WizardHouse target, int hp, float speed, float armour, int manaGained, ArrayList<GameObject> allPaths){
        super(x, y, sprite);
        this.target = target;
        this.hp = hp;
        this.startHp = hp;
        this.speed = speed;
        this.armour = armour;
        this.manaGained = manaGained;
        this.allPaths = allPaths;
    }

    
}
