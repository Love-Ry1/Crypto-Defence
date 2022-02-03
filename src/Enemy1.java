import javax.swing.*;
import java.awt.*;

public class Enemy1 extends Enemy {


    public Enemy1(int posx, int posy) {
        super(posx, posy);
        this.setEnimyImage(new ImageIcon("img\\water.png").getImage());
    }

    @Override
    public void drawEnemi(Graphics2D g) {
        g.drawImage(this.getEnimyImage(), 810, 900,null); // for sitting the picture to the right position
    }
}
