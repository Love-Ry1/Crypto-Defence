package models;

import java.io.Serializable;

/**
 * This class represents a player
 */
public class Player implements Serializable {
    private int health;
    private int gold;


    /**
     * This constructure initiats health and gold for the player
     */
    public Player() {
        this.gold = 50;
        this.health = 100;
    }

    /**
     * This method return health
     * @return the health
     */
    public int getHealth() {
        return health;
    }

    /**
     * This method is for setting a health
     * @param health the health for the player
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * This method returns gold
     * @return the amount of gold the player have
     */
    public int getGold() {
        return gold;
    }

    /**
     * This method sets gold
     * @param gold the amount of gold for the player
     */
    public void setGold(int gold) {
        this.gold = gold;
    }

    /**
     * This method is for adding the gold and return it
     * @param add the amount of gold that wants to be added
     * @return the amount of gold added
     */
    public int addGold(int add) {
        return gold += add;
    }

    /**
     * This method is for decreasing the health of the player depending on the damage
     * @param damage the amount of damage that is being dealt to the player
     */
    public void takeDamage(int damage) {
        health -= damage;
    }

}
