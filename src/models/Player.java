package models;

public class Player {
    private int health;
    private int gold;
    // Todo add a gold image and maybe a health image.

    public Player(){

         this.gold = 50;
         this.health = 100;


    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int AddGold(int Add){
        gold += Add;
        return gold;
    }

    public void takeDamage(int damage){
        health -= damage;
    }




}
