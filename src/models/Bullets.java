package models;

import javax.swing.*;
import java.awt.*;

public abstract class Bullets {
    private int posX;
    private int posY;
    protected enum Direction{
        NORTH, NORTHEAST, EAST, SOUTHEAST, SOUTH, SOUTHWEST, WEST, NORTHWEST
    }
    private Direction direction;
    private int speed;
    private Image bulletImage;
    Enemy enemy;

    protected Bullets(int posX, int posY, Direction dir, Enemy enemy){
        this.posX = posX;
        this.posY = posY;
        this.direction = dir;
        this.enemy = enemy;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Image getBulletImage() {
        return bulletImage;
    }

    public void setBulletImage(Image bulletImage) {
        this.bulletImage = bulletImage;
    }

    // this method could merge with updatePos? Need to add border cases
    public void updateDirection(){
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

        // TODO if the bullet hits a target it should get removed



    }

    public void update(){
        updateDirection();
        updatePos();
    }

}
