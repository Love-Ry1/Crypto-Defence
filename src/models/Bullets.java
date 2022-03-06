package models;

import java.awt.*;
import java.io.Serializable;

/**
 * This class represents a bullet
 */
public abstract class Bullets implements Serializable {
    private int posX;
    private int posY;

    /**
     * an enum for having all direction
     */
    protected enum Direction{
        NORTH, NORTHEAST, EAST, SOUTHEAST, SOUTH, SOUTHWEST, WEST, NORTHWEST
    }
    private Direction direction;
    private int speed;
    Enemy enemy;

    protected Bullets(int posX, int posY, Enemy enemy){
        this.posX = posX;
        this.posY = posY;
        this.enemy = enemy;
        this.direction = null;
    }

    /**
     * This method returns the x-coordinate for the bullet
     * @return the x-coordinate for the bullet
     */
    public int getPosX() {
        return posX;
    }

    /**
     * This method sets the x-coordinate for the bullet
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * This method returns the y-coordinate for the bullet
     * @return the y-coordinate for the bullet
     */
    public int getPosY() {
        return posY;
    }

    /**
     * This method sets the y-coordinate for the bullet
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }

    /**
     * This method sets the integer speed value for the bullet
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * This method updates the directions for the bullet
     */
    public void updateDirection(){      // this method could merge with updatePos?
        int enemyPosX = enemy.getPosX();
        int enemyPosY = enemy.getPosY();

        if(enemyPosX > posX && enemyPosY > posY){
            direction = Direction.SOUTHEAST;
        } else if(enemyPosX < posX && enemyPosY > posY){
            direction = Direction.SOUTHWEST;
        } else if(enemyPosX < posX && enemyPosY < posY){
            direction = Direction.NORTHWEST;
        } else if(enemyPosX > posX && enemyPosY < posY){
            direction = Direction.NORTHEAST;
        } else if(enemyPosX > posX){
            direction = Direction.EAST;
        } else if(enemyPosX < posX){
            direction = Direction.WEST;
        } else if(enemyPosY > posY){
            direction = Direction.SOUTH;
        } else if(enemyPosY < posY){
            direction = Direction.NORTH;
        }
    }

    /**
     * This method moves the bullet
     */
    public void updatePos(){
        if(direction == Direction.NORTH){
            posY -= speed;
        } else if(direction == Direction.NORTHEAST){
            posY -= speed;
            posX += speed;
        } else if(direction == Direction.EAST){
            posX += speed;
        } else if(direction == Direction.SOUTHEAST){
            posY += speed;
            posX += speed;
        } else if(direction == Direction.SOUTH){
            posY += speed;
        } else if(direction == Direction.SOUTHWEST){
            posY += speed;
            posX -= speed;
        } else if(direction == Direction.WEST){
            posX -= speed;
        } else if(direction == Direction.NORTHWEST){
            posY -= speed;
            posX -= speed;
        }
    }

    /**
     * This method draws a rectangle around the enemy and returns true if bullet has hit its target, otherwise return false
     * @return true if the bullet is in the bounds (posX, posY) of the enemy
     */
    public boolean hitTarget(){
        Rectangle rect = new Rectangle();
        rect.setBounds(enemy.getPosX() - enemy.getWidth()/2,
                enemy.getPosY() - enemy.getHeight()/2, enemy.getWidth(),
                enemy.getHeight());
        return rect.contains(posX, posY);
    }

    /**
     * This method returns an enemy which bullet targets
     * @return returns the target enemy
     */
    public Enemy getEnemy(){
        return enemy;
    }

    /**
     * This method updates the state for the bullet
     */
    public void update(){
        updateDirection();
        updatePos();
    }

}
