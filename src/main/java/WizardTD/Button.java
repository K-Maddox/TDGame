package WizardTD;

/**
 * Button class used for each button object created in setup
 */
public class Button {
    
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected int textSize;
    protected int textColour = 0; //default black
    protected String textMessage;
    protected int textAlign = 3;

    public boolean clicked;
    public boolean activeFlag = false;
    public boolean boxFlag;
    public boolean hoverFlagTower = false;
    public boolean hoverFlagMana = false;
    public boolean waveFlag = false;
    public boolean manaFlag = false;
    public boolean manaSpellFlag = false;

    /**
     * Constructor for non-dynamic boxes
     * @param x
     * @param y
     * @param width
     * @param height
     * @param textSize
     * @param textAlign
     * @param textMessage
     * @param boxFlag
     */
    public Button (int x, int y, int width, int height, int textSize, int textAlign, String textMessage, boolean boxFlag){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.textSize = textSize;
        this.textAlign = textAlign;
        this.textMessage = textMessage;
        this.boxFlag = boxFlag;
    }

}
