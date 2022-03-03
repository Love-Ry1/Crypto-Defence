package models;

import java.awt.*;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * This class represents an enemy
 */
public abstract class Enemy implements Serializable {

    private int width;
    private int height;
    private int speed;
    private int damage;
    private int health;
    private int posX;
    private int posY;
    private BasicMap basicMap = new BasicMap();
    BasicMap.direction oldDir = null;

    public Enemy(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }

    /**
     * This method returns the health for the enemy
     * @return the health for the enemy
     */
    public int getHealth() {
        return health;
    }

    /**
     * This method sets the health for the enemy
     * @param health the health for the enemy
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * This method sets the damage that the enemy does
     * @param damage the damage that the enemy
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * This method sets the speed for the enemy
     * @param speed the speed for the enemy
     */
    public void setSpeed(int speed){this.speed = speed;}

    /**
     * This method changes the player health depending on the damage that the enemy does
     * @param damage the damage that the enemy does
     */
    public void takeDamage(int damage){health-=damage;}

    /**
     * This method returns the damage that the enemy does
     * @return the damage that the enemy does
     */
    public int getDamage(){return damage;}

    /**
     * Thos method returns the X position of the enemy
     * @return the x-coordinate for the enemy
     */
    public int getPosX(){
        return this.posX;
    }

    /**
     * This method returns the Y position of the enemy
     * @return the y-coordinate for the enemy
     */
    public int getPosY(){
        return this.posY;
    }

    /**
     * This method sets the X-position for the enemy
     * @param posX the x-coordinate for the enemy
     */
    public void setPosX(int posX) { this.posX = posX; }

    /**
     * This method sets the Y-position for the enemy
     * @param posY the y-coordinate for the enemy
     */
    public void setPosY(int posY) { this.posY = posY; }

    /**
     * This method checks if the enemy is dead
     * @return returns a true boolean value of enemy health is equal to or less than zero
     */
    public boolean isDead(){
        return health <= 0;
    }

    /**
     * This method sets the width for the enemy
     * @param width the width for the enemy
     */
    public void setWidth(int width){
        this.width = width;
    }

    /**
     * This method returns the width for the enemy
     * @return the width for the enemy
     */
    public int getWidth(){
        return width;
    }

    /**
     * This method sets the height for the enemy
     * @param height the height for the enemy
     */
    public void setHeight(int height){
        this.height = height;
    }

    /**
     * This method returns the height for the enemy
     * @return the height for the enemy
     */
    public int getHeight(){
        return height;
    }

    /**
     * This method updates the position of an enemy
     */
    public void move() {
        BasicMap.direction dir = basicMap.nextDirection(posX, posY);
        if (((oldDir == BasicMap.direction.EAST && (dir == BasicMap.direction.SOUTH || dir == BasicMap.direction.NORTH)) && posX % 80 < 45)
        || ((oldDir == BasicMap.direction.WEST && (dir == BasicMap.direction.SOUTH || dir == BasicMap.direction.NORTH)) && posX % 80 > 45)
        || ((oldDir == BasicMap.direction.SOUTH && (dir == BasicMap.direction.WEST || dir == BasicMap.direction.EAST)) && posY % 80 < 45)
        || ((oldDir == BasicMap.direction.NORTH && (dir == BasicMap.direction.WEST || dir == BasicMap.direction.EAST)) && posY % 80 > 45)){
            dir = oldDir;
        }

        if (dir == BasicMap.direction.NORTH){
            posY -= speed;
        } else if (dir == BasicMap.direction.EAST){
            posX += speed;
        } else if (dir == BasicMap.direction.SOUTH){
            posY += speed;
        } else if (dir == BasicMap.direction.WEST){
            posX -= speed;
        }
        oldDir = dir;
    }

    /**
     * This method checks if the enemy is on the last block, and returns true if it is -----
     * @return
     */
    public boolean isOnEndBlock(){
        return posX/80 == basicMap.getEndColumn() && posY/80 == basicMap.getEndRow();
    }

    /**
     * This method updates the state of the enemy
     */
    public void enemyUpdate(){
        move();
    }
}
