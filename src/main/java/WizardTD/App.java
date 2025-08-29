package WizardTD;

import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;
import processing.data.JSONArray;
import processing.data.JSONObject;
import processing.event.MouseEvent;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import java.io.*;
import java.nio.file.Path;
import java.util.*;

public class App extends PApplet {

public static final int CELLSIZE = 32;
    public static final int SIDEBAR = 120;
    public static final int TOPBAR = 40;
    public static final int BOARD_WIDTH = 20;

    public static int WIDTH = CELLSIZE*BOARD_WIDTH+SIDEBAR;
    public static int HEIGHT = BOARD_WIDTH*CELLSIZE+TOPBAR;

    public static final int FPS = 60;

    public String configPath;

    public Random random = new Random();

    public int timer;

    //initialise images
    public PImage beetleImage;
    public PImage fireballImage;
    public PImage grassImage;
    public PImage gremlinImage;
    public PImage gremlin1Image;
    public PImage gremlin2Image;
    public PImage gremlin3Image;
    public PImage gremlin4Image;
    public PImage gremlin5Image;
    public PImage path0Image;
    public PImage path0ImageRotate;
    public PImage path1Image;
    public PImage path1ImageRotate;
    public PImage path2Image;
    public PImage path2ImageRotate;
    public PImage path3Image;
    public PImage path3ImageRotate;
    public PImage shrubImage;
    public PImage tower0Image;
    public PImage tower1Image;
    public PImage tower2Image;
    public PImage wizardHouseImage;
    public PImage wormImage;

    //initialise game objects
    public Monster beetle;
    public Monster gremlin;
    public Monster worm;
    public Fireball fireball;
    public Grass grass;
    public Path path0;
    public Path path1;
    public Path path2;
    public Path path3;
    public Shrub shrub;
    public Tower tower0;
    public Tower tower1;
    public Tower tower2;
    public WizardHouse wizardHouse;
    public Button button;
    public Waves wave;

    //game attributes
    public JSONObject json;
    public String gameLevel;
    public int duration;
    public float waveTotal;
    public float preWavePause;
    public boolean preWavePauseComplete;
    public boolean waveComplete;
    public float releaseRate;
    public float monsterCount;
    public int waveCount;
    public float fireBallCount;
    public boolean fastForward;
    public boolean pause;
    public boolean gameOver;

    //monster attributes
    public String type;
    public int hp;
    public float speed;
    public float armour;
    public int manaGained;
    public int quantity;

    //tower attributes
    public int towerRange;
    public float towerFiringSpeed;
    public int towerDamage;
    public int towerCost;
    public boolean towerActive;
    public boolean upgradeRange;
    public boolean upgradeSpeed;
    public boolean upgradeDamage;

    //player attributes
    public int mana;
    public int manaCap;
    public int manaPerSecond;
    public int manaCount;
    public int manaSpellCost;
    public int manaSpellCostIncrease;
    public float manaSpellCapMultiplier;
    public float manaSpellGainedMultiplier;
    public float manaKillMultiplier;

    //lists of objects
    public ArrayList<GameObject> allObjects = new ArrayList<GameObject>();
    public ArrayList<GameObject> spawnPoints = new ArrayList<GameObject>();
    public ArrayList<GameObject> allPaths = new ArrayList<GameObject>();
    public ArrayList<Monster> allMonsters = new ArrayList<Monster>();
    public ArrayList<Fireball> allFireballs = new ArrayList<Fireball>();
    public ArrayList<Button> buttonObjects = new ArrayList<Button>();
    public ArrayList<Waves> waveObjects = new ArrayList<Waves>();

    /**
     * Store the config path
     */
    public App() {
        this.configPath = "config.json";
    }
}
