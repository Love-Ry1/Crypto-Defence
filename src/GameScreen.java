import javax.swing.*;
import java.awt.*;

public class GameScreen extends JPanel {

    public GameScreen(){    // constructor (maybe needed later)
    }

    public void paintComponent(Graphics gr){
        Graphics2D g = (Graphics2D) gr;
        g.clearRect(0, 0, this.getWidth(), this.getHeight());   // Clears the screen

        BasicMap basicMap = new BasicMap();     // just for testing move later
        basicMap.drawMap(g);
    }
    //Image newImage = img.getScaledInstance(90, 154, Image.SCALE_DEFAULT); för resize
}
