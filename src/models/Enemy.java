package models;

import java.awt.*;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

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

    private enum pathfinding{
        UP,DOWN,LEFT,RIGHT
    }

    public Enemy(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setSpeed(int speed){this.speed = speed;}

    public void takeDamage(int damage){health-=damage;}

    public int getDamage(){return damage;}

    public int getPosX(){
        return this.posX;
    }

    public int getPosY(){
        return this.posY;
    }

    public void setPosX(int posX) { this.posX = posX; }

    public void setPosY(int posY) { this.posY = posY; }

    public boolean isDead(){
        return health <= 0;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public int getWidth(){
        return width;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public int getHeight(){
        return height;
    }

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

    public boolean isOnEndBlock(){
        return posX/80 == basicMap.getEndColumn() && posY/80 == basicMap.getEndRow();
    }

    public void enemyUpdate(){
        move();
    }
}
