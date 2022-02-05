import javax.swing.*;
import java.awt.*;

public abstract class Bullets {
    private int posX;
    private int posY;
    private int direction;      // should probably be an Enum?
    private int speed;
    private Image bulletImage;

    protected Bullets(int posX, int posY, int direction){
        this.posX = posX;
        this.posY = posY;
        this.direction = direction;
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

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public Image getBulletImage() {
        return bulletImage;
    }

    public void setBulletImage(Image bulletImage) {
        this.bulletImage = bulletImage;
    }

    public void updatePos(){
        // TODO updates the position of the bullet
        // TODO if the bullet hits a target it should get removed
    }

}
