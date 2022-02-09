import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


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

    public  void drawEnemy(Graphics2D g){
        g.drawImage(this.getEnemyImage(), this.getPosX() + ((Block.getWidth() - getEnemyImage().getWidth(null)) / 2),
                this.getPosY() + ((Block.getHeight() - getEnemyImage().getHeight(null)) / 2),null);

    }

    public void setEnemySizeImage(Image image){
        this.enemyImage = image;
    }

    public Image getEnemyImage(){
        return this.enemyImage;
    }
    public void move(int turnTile, int threshold) {
        //setDirection(turnTile, threshold);
        switch (start) {
            case UP:
                posY -= speed ;
                break;
            case LEFT:
                posX -= speed;
                break;
            case RIGHT:
                posX += speed ;
                break;
            case DOWN:
                posY += speed ;
                break;
        }

    }



}
