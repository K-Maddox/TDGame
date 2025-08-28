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
}
