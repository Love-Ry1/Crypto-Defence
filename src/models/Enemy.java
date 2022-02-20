package models;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public abstract class Enemy  {

    private int enemySize= 80;
    private int speed;
    private int damage;
    private int health;
    private int posX;
    private int posY;
    private ArrayList<Enemy> enemies;
    private  Image  enemyUp;
    private  Image  enemyDown;
    private  Image  enemyRight;
    private  Image enemyLeft;
    private String path = "images" + File.separator;
    private Image enemyImage;
    private pathfinding start;
    private pathfinding enddirection;
    private BasicMap basicMap = new BasicMap();

    private enum pathfinding{
        UP,DOWN,LEFT,RIGHT
    }

    public Enemy(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
        this.start = pathfinding.RIGHT;
        this.enddirection = pathfinding.RIGHT;

       /*
       try {
           this.enemyUp = ImageIO.read(new File(path + ""));  //PS i "" Så är det tänkt att vi ska ha bilderna
           this.enemyDown = ImageIO.read(new File(path + "")); //För upp/ner höger/vänster
           this.enemyLeft = ImageIO.read(new File(path + ""));
           this.enemyRight = ImageIO.read(new File(path + ""));

       } catch(IOException e){
           e.printStackTrace();
       }

        */

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

    public int getSpeed(){return this.speed;}

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

    public void setEnemySizeImage(Image image){
        this.enemyImage = image;
    }

    public Image getEnemyImage(){
        return this.enemyImage;
    }

    public void move() {
        BasicMap.direction dir = basicMap.nextDirection(posX, posY);
        System.out.println(dir);
        if (dir == BasicMap.direction.NORTH){
            posY += speed;
        } else if (dir == BasicMap.direction.EAST){
            posX += speed;
        } else if (dir == BasicMap.direction.SOUTH){
            posY += speed;
        } else if (dir == BasicMap.direction.WEST){
            posX -= speed;
        }
    }

    public void enemyUpdate(){

    }
}
