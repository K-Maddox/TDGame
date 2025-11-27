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

    
}
