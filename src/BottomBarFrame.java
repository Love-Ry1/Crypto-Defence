import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class BottomBarFrame {
    private int x, y, width, height;
    private BottomBarButtons tower1, tower2, tower3, tower4;

    public BottomBarFrame(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        Buttons();
    }

    public void draw(Graphics2D g) {
        g.setColor(Color.ORANGE);
        g.fillRect(x, y, width, height);
        tower1.draw(g);
        tower2.draw(g);
        tower3.draw(g);
        tower4.draw(g);
    }


    public void Buttons() {
        tower1 = new BottomBarButtons("tower1", 110, 850, 100, 70);
        tower2 = new BottomBarButtons("tower2", 270, 850, 100, 70);
        tower3 = new BottomBarButtons("tower3", 430, 850, 100, 70);
        tower4 = new BottomBarButtons("tower4", 590, 850, 100, 70);
    }


    public void mouseClicked(int x, int y) {
        if (tower1.getInitialBound().contains(x, y)) {  //checks if tower1 bounds are pressed (so if the button is pressed)
            System.out.println("You pressed tower 1!");
            //tower1.setMousePressed(true);  - If button is pressed then mousePressed = true
        }
        if (tower2.getInitialBound().contains(x, y)) {
            System.out.println("You pressed tower2!");

        }
        if (tower3.getInitialBound().contains(x, y)) {
            System.out.println("You pressed tower3!");

        }
        if (tower4.getInitialBound().contains(x, y)) {
            System.out.println("You pressed tower4!");

        }

    }


    public void mouseMoved(int x, int y) {  // checks if the mouse is hovering over the bounds of tower1
        tower1.setMouseOver(false);
        if (tower1.getInitialBound().contains(x, y)) {
            tower1.setMouseOver(true);
            System.out.println("Your hovering over button 1");
        }

    }

    public void mousePressed(int x, int y) {
    }

    public void mouseReleased(int x, int y) {
    }





}
