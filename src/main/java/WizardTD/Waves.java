package WizardTD;

/**
 * this stores all the wave settings from the configuation file
 */
public class Waves {
    
    protected int duration;
    protected float preWavePause;
    protected String monster;
    protected int hp;
    protected float speed;
    protected float armour;
    protected int manaGained;
    protected int quantity;

    /**
     * Constructor for Wave objects initialises the below attributes as per the config file
     * @param duration
     * @param preWavePause
     * @param monster
     * @param hp
     * @param speed
     * @param armour
     * @param manaGained
     * @param quantity
     */
    public Waves (int duration, float preWavePause, String monster, int hp, float speed, float armour, int manaGained, int quantity){
        this.duration = duration;
        this.preWavePause = preWavePause;
        this.monster = monster;
        this.hp = hp;
        this.speed = speed;
        this.armour = armour;
        this.manaGained = manaGained;
        this.quantity = quantity;
    }

    /**
     * returns duration of wave
     * @return duration of wave
     */
    public int getDuration(){
        return this.duration;
    }

    /**
     * returns pre wave pause
     * @return pre wave pause of wave
     */
    public float getPreWavePause(){
        return this.preWavePause;
    }

    /**
     * returns monster type used in wave
     * @return monster name
     */
    public String getMonster(){
        return this.monster;
    }

    /**
     * returns monster hp
     * @return hp
     */
    public int getHp(){
        return this.hp;
    }

    /**
     * returns monster speed
     * @return speed
     */
    public float getSpeed(){
        return this.speed;
    }

    /**
     * returns monster armour
     * @return armour
     */
    public float getArmour(){
        return this.armour;
    }

    /**
     * returns mana gained from monster kill
     * @return mana gained
     */
    public int getManaGained(){
        return this.manaGained;
    }

    /**
     * returns the quantity of monsters spawned for the round
     * @return quantity
     */
    public int getQuantity(){
        return this.quantity;
    }
}
