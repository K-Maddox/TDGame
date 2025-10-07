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

    /**
     * Constructor for dynamic boxes
     * @param x
     * @param y
     * @param width
     * @param height
     * @param textSize
     * @param textAlign
     * @param textMessage
     * @param boxFlag
     * @param hoverFlagTower
     * @param hoverFlagMana
     * @param waveFlag
     * @param manaFlag
     * @param manaSpellFlag
     */
    public Button (int x, int y, int width, int height, int textSize, int textAlign, String textMessage, boolean boxFlag, boolean hoverFlagTower, boolean hoverFlagMana, boolean waveFlag, boolean manaFlag, boolean manaSpellFlag){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.textSize = textSize;
        this.textAlign = textAlign;
        this.textMessage = textMessage;
        this.boxFlag = boxFlag;
        this.hoverFlagTower = hoverFlagTower;
        this.hoverFlagMana = hoverFlagMana;
        this.waveFlag = waveFlag;
        this.manaFlag = manaFlag;
        this.manaSpellFlag = manaSpellFlag;
    }

    /**
     * Return if clicked
     * @param mouseX, mouseY
     * @return if mouse position is within the x and y coordinates of the box
     */
    public boolean isClicked(float mouseX, float mouseY){
        if (mouseX >= this.x && mouseX <= this.x + this.width && mouseY >= this.y && mouseY <= this.y + this.height){
            return true;
        } else {
            return false;
        }
    }

    /**
     * get x coordinate
     * @return x
     */
    public int getX(){
        return this.x;
    }

    /**
     * get Y coordinate
     * @return y
     */
    public int getY(){
        return this.y;
    }

    /**
     * get button width
     * @return width
     */
    public int getWidth(){
        return this.width;
    }

    /**
     * get button height
     * @return
     */
    public int getHeight(){
        return this.height;
    }

    /**
     * get text colour
     * @return text colour
     */
    public int getColour(){
        return this.textColour;
    }

    /**
     * get the string message for the buttton
     * @return message
     */
    public String getText(){
        return this.textMessage;
    }

    /**
     * get the size of the text
     * @return text size
     */
    public int getTextSize(){
        return this.textSize;
    }

    /**
     * get the alignment of the text in the box
     * @return align value
     */
    public int getTextAlign(){
        return this.textAlign;
    }

    /**
     * get if the button has a box around it
     * @return if has box
     */
    public boolean getFlag(){
        return this.boxFlag;
    }

    /**
     * get if the button is clicked or hovered over
     * @return activeFlag
     */
    public boolean getActiveFlag(){
        return this.activeFlag;
    }

    /**
     * used to determine if the button is clicked or hovered over
     */
    public void setActiveFlag(){
        this.activeFlag = !activeFlag;
    }


}
