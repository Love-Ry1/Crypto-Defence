import javax.swing.*;
import java.awt.*;

public class Enemy1 extends Enemy {


    public Enemy1(int posx, int posy) {
        super(posx, posy);
        setHealth(100);
        setSpeed(1);
        setDamage(10);
      // funkar inte för int värde på posx och posy?? varför?  super(posx, posy);
        this.setEnemySizeImage(new ImageIcon("img\\water.png").getImage());
    }

    @Override
    public void drawEnemy(Graphics2D g) {
        g.drawImage(this.getEnemyImage(), 810, 900,null); // for setting the picture to the right position
    }
}
