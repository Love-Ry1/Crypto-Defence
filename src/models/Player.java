package models;

import java.io.Serializable;

public class Player implements Serializable {
    private int health;
    private int gold;
    // Todo add a gold image and maybe a health image.

    public Player() {
        this.gold = 50;
        this.health = 100;
    }

    /**
     * This method return health
     * @return
     */
    public int getHealth() {
        return health;
    }

    /**
     * This method is for setting a health
     * @param health
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * This method returns gold
     * @return
     */
    public int getGold() {
        return gold;
    }

    /**
     * This method sets gold
     * @param gold
     */
    public void setGold(int gold) {
        this.gold = gold;
    }

    /**
     * This methods is for adding the gold and return it
     * @param add
     * @return
     */
    public int addGold(int add) {
        return gold += add;
    }

    /**
     * This method is for decreasing damage
     * @param damage
     */
    public void takeDamage(int damage) {
        health -= damage;
    }


}
