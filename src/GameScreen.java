import javax.swing.*;
import java.awt.*;

public class GameScreen extends JPanel {
    Image stoneBlock;
    Image gras;
    Image water;

    public GameScreen(){    // constructor (maybe needed later)

        stoneBlock = new ImageIcon("img\\floor.png").getImage(); // har ändrats till adress
        gras = new ImageIcon("img\\gras.png").getImage(); // har ändrats till adress
        water = new ImageIcon("img\\water.png").getImage(); // har ändrats till adress


    }



    @Override
    public void paintComponent(Graphics g){

        g.clearRect(0, 0, this.getWidth(), this.getHeight());   // Clears the screen

        BasicMap basicMap = new BasicMap();     // just for testing move later
        basicMap.drawMap(g);

        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.drawImage(stoneBlock,100,100,null);

    }

    //Image newImage = img.getScaledInstance(90, 154, Image.SCALE_DEFAULT); för resize



}
