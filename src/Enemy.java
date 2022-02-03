import java.awt.*;


public abstract class Enemy  {

    private int enemySize= 80;
    private int speed;
    private int damage;
    private Image enimyImage;
    private int posX;
    private int posY;



    public Enemy(int posx, int posy){
        this.posX = posx;
        this.posY = posy;
    }

    public void setSpeed(int speed){this.speed = speed;}

    public int getSpeed(){return this.speed;}

    public void setDamage(int damage){this.damage=damage;}

    public int getDamage(){return damage;}

    public int getPosX(){
        return this.posX;
    }

    public int getPosY(){
        return this.posY;
    }

    public abstract void drawEnemi(Graphics2D g);

    public void setEnimyImage(Image image){
        this.enimyImage = image;
    }

    public Image getEnimyImage(){
        return this.enimyImage;
    }


}
