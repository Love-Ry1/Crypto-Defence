import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public abstract class Enemy  {

    private int enemySize= 80;
    private int speed;
    private int damage;
    private int health;
    private int posX;
    private int posY;
    private  Image  enemyUp;
    private  Image  enemyDown;
    private  Image  enemyRight;
    private  Image enemyLeft;
    private String path = "images" + File.separator;
    private Image enemyImage;


    private enum pathfinding{
        UP,DOWN,LEFT,RIGHT
    }

    private pathfinding start;
    private pathfinding enddirection;

    public Enemy(){
       this.health = 100;
       this.speed = 1;
       this.posX = 1;
       this.posY = 1;
       this.damage = 10;
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

    public abstract void drawEnemy(Graphics2D g);

    public void setEnemySizeImage(Image image){
        this.enemyImage = image;
    }

    public Image getEnemyImage(){
        return this.enemyImage;
    }


}
