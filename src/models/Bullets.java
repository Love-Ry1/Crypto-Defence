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

    protected Bullets(int posX, int posY, Direction dir){
        this.posX = posX;
        this.posY = posY;
        this.direction = dir;
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

    public void updatePos(){
        if(direction == Direction.NORTH){
            posY -= 1;
        } else if(direction == Direction.NORTHEAST){
            posY -= 1;
            posX += 1;
        } else if(direction == Direction.EAST){
            posX += 1;
        } else if(direction == Direction.SOUTHEAST){
            posY += 1;
            posX += 1;
        } else if(direction == Direction.SOUTH){
            posY += 1;
        } else if(direction == Direction.SOUTHWEST){
            posY += 1;
            posX -= 1;
        } else if(direction == Direction.WEST){
            posX -= 1;
        } else if(direction == Direction.NORTHWEST){
            posY -= 1;
            posX -= 1;
        }

        // TODO if the bullet hits a target it should get removed



    }

}
