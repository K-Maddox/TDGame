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

    /**
     * Initialise the setting of the window size.
     */
	@Override
    public void settings() {
        size(WIDTH, HEIGHT);
    }

    /**
     * Load all resources such as images. Initialise the elements such as the player, enemies and map elements.
     */
	@Override
    public void setup() {
        frameRate(FPS);

        // Load images during setup
        this.beetleImage = this.loadImage("src/main/resources/WizardTD/beetle.png");
        this.fireballImage = this.loadImage("src/main/resources/WizardTD/fireball.png");
        this.grassImage = this.loadImage("src/main/resources/WizardTD/grass.png");
        this.gremlinImage = this.loadImage("src/main/resources/WizardTD/gremlin.png");
        this.gremlin1Image = this.loadImage("src/main/resources/WizardTD/gremlin1.png");
        this.gremlin2Image = this.loadImage("src/main/resources/WizardTD/gremlin2.png");
        this.gremlin3Image = this.loadImage("src/main/resources/WizardTD/gremlin3.png");
        this.gremlin4Image = this.loadImage("src/main/resources/WizardTD/gremlin4.png");
        this.gremlin5Image = this.loadImage("src/main/resources/WizardTD/gremlin5.png");
        this.path0Image = this.loadImage("src/main/resources/WizardTD/path0.png");
        this.path0ImageRotate = this.loadImage("src/main/resources/WizardTD/path0.png");
        this.path1Image = this.loadImage("src/main/resources/WizardTD/path1.png");
        this.path1ImageRotate = this.loadImage("src/main/resources/WizardTD/path1.png");
        this.path2Image = this.loadImage("src/main/resources/WizardTD/path2.png");
        this.path2ImageRotate = this.loadImage("src/main/resources/WizardTD/path2.png");
        this.path3Image = this.loadImage("src/main/resources/WizardTD/path3.png");
        this.path3ImageRotate = this.loadImage("src/main/resources/WizardTD/path3.png");
        this.shrubImage = this.loadImage("src/main/resources/WizardTD/shrub.png");
        this.tower0Image = this.loadImage("src/main/resources/WizardTD/tower0.png");
        this.tower1Image = this.loadImage("src/main/resources/WizardTD/tower1.png");
        this.tower2Image = this.loadImage("src/main/resources/WizardTD/tower2.png");
        this.wizardHouseImage = this.loadImage("src/main/resources/WizardTD/wizard_house.png");
        this.wormImage = this.loadImage("src/main/resources/WizardTD/worm.png");

        //retieve all settings from config file
        json = loadJSONObject(this.configPath);
        
        //initialise game map
        gameLevel = json.getString("layout");

        //store each wave in waveObjects array
        JSONArray waves = json.getJSONArray("waves");
        for (int i = 0; i < waves.size(); i++){

            JSONObject objects = waves.getJSONObject(i);

            duration = objects.getInt("duration");
            preWavePause = objects.getFloat("pre_wave_pause");
            JSONArray monsters = objects.getJSONArray("monsters");

            for (int j = 0; j < monsters.size(); j++){
                JSONObject monsterAttributes = monsters.getJSONObject(j);

                type = monsterAttributes.getString("type");
                hp = monsterAttributes.getInt("hp");
                speed = monsterAttributes.getFloat("speed");
                armour = monsterAttributes.getInt("armour");
                manaGained = monsterAttributes.getInt("mana_gained_on_kill");
                quantity = monsterAttributes.getInt("quantity");

                waveObjects.add(wave = new Waves(duration, preWavePause, type, hp, speed, armour, manaGained, quantity));
            }
        }

        //initialise tower attributes
        towerRange = json.getInt("initial_tower_range");
        towerFiringSpeed = json.getFloat("initial_tower_firing_speed");
        towerDamage = json.getInt("initial_tower_damage");
        towerCost = json.getInt("tower_cost");

        //initialise player attributes
        mana = json.getInt("initial_mana");
        manaCap = json.getInt("initial_mana_cap");
        manaPerSecond = json.getInt("initial_mana_gained_per_second");
        manaSpellCost = json.getInt("mana_pool_spell_initial_cost");
        manaSpellCostIncrease = json.getInt("mana_pool_spell_cost_increase_per_use");
        manaSpellCapMultiplier = json.getFloat("mana_pool_spell_cap_multiplier");
        manaSpellGainedMultiplier  = json.getFloat("mana_pool_spell_mana_gained_multiplier");

        //initial starting conditions for the waves
        waveCount = 0;
        wave = waveObjects.get(0);
        duration = wave.getDuration();
        preWavePause = wave.getPreWavePause();
        quantity = wave.getQuantity();
        preWavePauseComplete = false;
        waveComplete = false;
        waveTotal = FPS * (duration + preWavePause);
        releaseRate = FPS * duration / quantity;
        monsterCount = releaseRate;
        manaCount = FPS;
        fireBallCount = towerFiringSpeed * FPS;
        timer = (int)preWavePause * FPS;
        manaKillMultiplier = 1;

        //create buttons
        int largeText = 22; //text size
        int smallText = 12;
        int centre = 3; //text alignment
        int right = 39;
        int left = 37;
        int edge1 = 40; //text with boxes
        int edge2 = 40; //text no boxes
        int line1 = 660; //first column of text boxes
        int line2 = 735; //710 second column of text boxes
        boolean box = true;
        boolean noBox = false;

        buttonObjects.add(button = new Button(5, 5, 200, 30, largeText, centre, "Wave 2 starts: 9" + duration, noBox, false, false, true, false, false));
        buttonObjects.add(button = new Button(350, 10, 50, 20, largeText, centre, "MANA: ", noBox));
        buttonObjects.add(button = new Button(420, 10, 300, 20, smallText, centre, "Graphic Bar", box, false, false, false, true, false));
        buttonObjects.add(button = new Button(line1, 50, edge1, edge1, largeText, centre, "FF", box));
        buttonObjects.add(button = new Button(line2, 50, edge2, edge2, smallText, right, "2x speed", noBox));
        buttonObjects.add(button = new Button(line1, 110, edge1, edge1, largeText, right, "P", box));
        buttonObjects.add(button = new Button(line2, 110, edge2, edge2, smallText, right, "PAUSE", noBox));
        buttonObjects.add(button = new Button(line1, 170, edge1, edge1, largeText, right, "T", box, true, false, false, false, false));
        buttonObjects.add(button = new Button(line2, 170, edge2, edge2, smallText, right,  "Build\ntower", noBox));
        buttonObjects.add(button = new Button(line1, 230, edge1, edge1, largeText, centre, "U1", box));
        buttonObjects.add(button = new Button(line2, 230, edge2, edge2, smallText, right, "Upgrade\nrange", noBox));
        buttonObjects.add(button = new Button(line1, 290, edge1, edge1, largeText, centre, "U2", box));
        buttonObjects.add(button = new Button(line2, 290, edge2, edge2, smallText, right, "Upgrade \nspeed", noBox));
        buttonObjects.add(button = new Button(line1, 350, edge1, edge1, largeText, centre, "U3", box));
        buttonObjects.add(button = new Button(line2, 350, edge2, edge2, smallText, right, "Upgrade\ndamage", noBox));
        buttonObjects.add(button = new Button(line1, 410, edge1, edge1, largeText, right, "M", box, false, true, false, false, false));
        buttonObjects.add(button = new Button(line2, 410, edge2, edge2, smallText, right, "Mana pool\ncost: ", noBox,false, false, false, false, true));


        //create grass game board
        for (int x = 0; x < WIDTH - SIDEBAR; x += BOARD_WIDTH){
            for (int y = TOPBAR; y < HEIGHT; y += BOARD_WIDTH){
                allObjects.add(this.grass = new Grass(x, y, grassImage));
            }
        }

        //create rest of game board via matrix array
        int numRows = BOARD_WIDTH;
        int numCols = BOARD_WIDTH;
        char[][] matrix = new char[numRows][numCols];

        //find positions of path, shrub and wizard house
        try (BufferedReader reader = new BufferedReader(new FileReader(gameLevel))){
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null){
                char[] chars = line.toCharArray();
                for (int col = 0; col < chars.length; col++){
                    matrix[row][col] = chars[col];
                }
                row++;
            }
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        //traverse matrix to print objects
        int x = 0;
        int y = TOPBAR;
        
        for (int row = 0; row < matrix.length; row++){
            for (int col= 0; col < matrix[row].length; col++){
                char character = matrix[row][col];

                //add shrub
                if (character == 'S'){
                    allObjects.add(this.shrub = new Shrub(x, y, shrubImage));
                }

                //add path
                if (character == 'X'){

                    //check positions of neighbours to determine which path image and rotation
                    double degrees = 0;
                    char neighbourUp = matrix[row][col]; //self
                    char neighbourDown = matrix[row][col]; //self
                    char neighbourRight = matrix[row][col]; //self
                    char neighbourLeft = matrix[row][col]; //self
                    
                    //check if at a border - borders are always paths hence declared as paths above
                    if (row != 0){
                        neighbourUp = matrix[row - 1][col];
                    }
                    if (row != matrix.length - 1){
                        neighbourDown = matrix[row + 1][col];
                    }
                    if (col != 0){
                        neighbourLeft = matrix[row][col - 1];
                    }
                    if (col != matrix[row].length - 1){
                        neighbourRight = matrix[row][col + 1];
                    }

                    //conditions on which image to use and which way to rotate

                    //1 neighbour
                    if (neighbourUp == 'X' && neighbourDown != 'X' && neighbourRight != 'X' && neighbourLeft != 'X'){
                        degrees = 90;
                        path0ImageRotate = rotateImageByDegrees(path0Image, degrees);
                        allObjects.add(this.path0 = new Path(x, y, path0ImageRotate));
                    }
                    else if (neighbourUp != 'X' && neighbourDown == 'X' && neighbourRight != 'X' && neighbourLeft != 'X'){
                        degrees = 90;
                        path0ImageRotate = rotateImageByDegrees(path0Image, degrees);
                        allObjects.add(this.path0 = new Path(x, y, path0ImageRotate));
                    }
                    else if (neighbourUp != 'X' && neighbourDown != 'X' && neighbourRight == 'X' && neighbourLeft != 'X'){
                        allObjects.add(this.path0 = new Path(x, y, path0Image));
                    }
                    else if (neighbourUp != 'X' && neighbourDown != 'X' && neighbourRight != 'X' && neighbourLeft == 'X'){
                        allObjects.add(this.path0 = new Path(x, y, path0Image));
                    }

                    //2 neighbours
                    else if (neighbourUp == 'X' && neighbourDown == 'X' && neighbourRight != 'X' && neighbourLeft != 'X'){
                        degrees = 90;
                        path0ImageRotate = rotateImageByDegrees(path0Image, degrees);
                        allObjects.add(this.path0 = new Path(x, y, path0ImageRotate));
                    }
                    else if (neighbourUp != 'X' && neighbourDown != 'X' && neighbourRight == 'X' && neighbourLeft == 'X'){
                        allObjects.add(this.path0 = new Path(x, y, path0Image));
                    }
                    else if (neighbourUp == 'X' && neighbourDown != 'X' && neighbourRight != 'X' && neighbourLeft == 'X'){
                        degrees = 90;
                        path1ImageRotate = rotateImageByDegrees(path1Image, degrees);
                        allObjects.add(this.path1 = new Path(x, y, path1ImageRotate));
                    }
                    else if (neighbourUp != 'X' && neighbourDown == 'X' && neighbourRight == 'X' && neighbourLeft != 'X'){
                        degrees = 270;
                        path1ImageRotate = rotateImageByDegrees(path1Image, degrees);
                        allObjects.add(this.path1 = new Path(x, y, path1ImageRotate));
                    }
                    else if (neighbourUp == 'X' && neighbourDown != 'X' && neighbourRight == 'X' && neighbourLeft != 'X'){
                        degrees = 180;
                        path1ImageRotate = rotateImageByDegrees(path1Image, degrees);
                        allObjects.add(this.path1 = new Path(x, y, path1ImageRotate));
                    }
                    else if (neighbourUp != 'X' && neighbourDown == 'X' && neighbourRight != 'X' && neighbourLeft == 'X'){
                        allObjects.add(this.path1 = new Path(x, y, path1Image));
                    }

                    //3 neighbours
                    else if (neighbourUp != 'X' && neighbourDown == 'X' && neighbourRight == 'X' && neighbourLeft == 'X'){
                        allObjects.add(this.path2 = new Path(x, y, path2Image));
                    }
                    else if (neighbourUp == 'X' && neighbourDown != 'X' && neighbourRight == 'X' && neighbourLeft == 'X'){
                        degrees = 180;
                        path2ImageRotate = rotateImageByDegrees(path2Image, degrees);
                        allObjects.add(this.path2 = new Path(x, y, path2ImageRotate));
                    }
                    else if (neighbourUp == 'X' && neighbourDown == 'X' && neighbourRight != 'X'  && neighbourLeft == 'X'){
                        degrees = 90;
                        path2ImageRotate = rotateImageByDegrees(path2Image, degrees);
                        allObjects.add(this.path2 = new Path(x, y, path2ImageRotate));
                    }
                    else if (neighbourUp == 'X' && neighbourDown == 'X' && neighbourRight == 'X'  && neighbourLeft != 'X'){
                        degrees = 270;
                        path2ImageRotate = rotateImageByDegrees(path2Image, degrees);
                        allObjects.add(this.path2 = new Path(x, y, path2ImageRotate));
                    }

                    //4 neighbours
                    else if (neighbourUp == 'X' && neighbourDown == 'X' && neighbourRight == 'X'  && neighbourLeft == 'X'){
                        allObjects.add(this.path3 = new Path(x, y, path3Image));
                    }
                }

                //add Wizard House
                if (character == 'W'){
                    double degrees = 0;

                    //check positions of neighbours to determine which rotation - wizard house already pointing left
                    char neighbourUp = matrix[row - 1][col];
                    char neighbourDown = matrix[row + 1][col];
                    char neighbourRight = matrix[row][col + 1];
                    
                    if (neighbourUp == 'X'){
                        degrees = 90;
                    }
                    if (neighbourDown == 'X'){
                        degrees = 270;
                    }
                    if (neighbourRight == 'X'){
                        degrees = 180;
                    }

                    wizardHouseImage = rotateImageByDegrees(wizardHouseImage, degrees);
                    allObjects.add(this.wizardHouse = new WizardHouse(x, y, wizardHouseImage));
                }

                x += CELLSIZE;
            }
            x = 0;
            y += CELLSIZE;
        }

        //find spawn points
        for (GameObject obj : allObjects){
            if (obj instanceof Path){
                allPaths.add(obj); //add to path list
                if (obj.getX() == 0 || obj.getX() == WIDTH - SIDEBAR - CELLSIZE || obj.getY() == TOPBAR || obj.getY() == HEIGHT - CELLSIZE){
                    spawnPoints.add(obj); //add to spawn point list
                }
            }
        }
    }

    /**
     * Receive key pressed signal from the keyboard.
     */
	@Override
    public void keyPressed(){
        //fast forward
        if (this.keyCode == 70) {
            pause = false;
            fastForward = !fastForward;

            //changes button yellow
            for (Button button : buttonObjects){
                if (button.getText() == "FF"){
                    button.setActiveFlag();
                }
                if (button.getText() == "P" && button.getActiveFlag()){
                    button.setActiveFlag();
                }
            }
        }
        //pause
        if (this.keyCode == 80) {
            fastForward = false;
            pause = !pause;

            //changes button yellow
            for (Button button : buttonObjects){
                if (button.getText() == "P"){
                    button.setActiveFlag();
                }
                if (button.getText() == "FF" && button.getActiveFlag()){
                    button.setActiveFlag();
                }
            }
        }

        //create tower
        if (this.keyCode == 84 && !pause){
            towerActive = !towerActive;
            
            //changes button yellow
            for (Button button : buttonObjects){
                if (button.getText() == "T"){
                    button.setActiveFlag();
                }
            }
        }

        //upgrade tower range
        if (this.keyCode == 49){
            upgradeRange = !upgradeRange;

            //changes button yellow
            for (Button button : buttonObjects){
                if (button.getText() == "U1"){
                    button.setActiveFlag();
                }
            }
        }
    }
}
