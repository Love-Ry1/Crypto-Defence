import javax.swing.*;
import java.awt.*;

public class GameScreen extends JPanel {

    public GameScreen(){    // constructor (maybe needed later)
    }

    @Override
    public void paintComponent(Graphics g){
        g.clearRect(0, 0, this.getWidth(), this.getHeight());   // Clears the screen
        BasicMap basicMap = new BasicMap();     // just for testing move later
        basicMap.drawMap(g);

    }

}
