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

    
}
