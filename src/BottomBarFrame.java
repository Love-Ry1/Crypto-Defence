import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class BottomBarFrame {
    private int x, y, width, height;
    private BottomBarButtons buttons;
    public BottomBarFrame(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        Buttons();
    }

    public void draw(Graphics g) {
        buttons.draw(g);
        g.setColor(Color.ORANGE);
        g.fillRect(x, y, width, height);
    }

    public void test(Graphics g) {
        g.drawRect(x, y, width, height);
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);

    }

    public void Buttons() {
        buttons = new BottomBarButtons("test", 150, 900, 200, 20);
        //TowerButtons.add(new BottomBarButtons("test",140,900,50,50));

    }


    public void mouseClicked(int x, int y) {
    }

    public void mouseMoved(int x, int y) {
    }

    public void mousePressed(int x, int y) {
    }

    public void mouseReleased(int x, int y) {
    }


}
