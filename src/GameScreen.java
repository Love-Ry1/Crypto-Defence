import javax.swing.*;
import java.awt.*;

public class GameScreen extends JPanel implements MouseMethods {
    private BottomBarButtons tower1, tower2, tower3;
    private MyMouseListener mouseMouseListener;
    private GameFrame gameFrame;

    public GameScreen(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        initButtons();
    }

    private void initButtons() {
        tower1 = new BottomBarButtons("Tower1", 100, 100, 100, 30);
    }

    public void paintComponent(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;
        g.clearRect(0, 0, this.getWidth(), this.getHeight());   // Clears the screen

        BasicMap basicMap = new BasicMap();     // just for testing move later
        basicMap.drawMap(g);

        BottomBarFrame bottomBarFrame = new BottomBarFrame(0,800,800,200 ); // create the bottom bar
        bottomBarFrame.draw(g); //adding the bottom bar

        GameModel gameModel = new GameModel();      // just for testing tower mechanics, remove later
        BasicTower basicTower = new BasicTower(80, 80);
        gameModel.addTower(250, 85, Tower.TowerName.BASIC);
        gameModel.drawTowerMap(g);
        drawButtons(g);


        Enemy1 enm1 = new Enemy1(20,20);
        enm1.drawEnemy(g);

    }

    public void initInputs() {
        mouseMouseListener = new MyMouseListener(gameFrame);

        addMouseListener(mouseMouseListener);
        addMouseMotionListener(mouseMouseListener);

        //requestFocus();
    }

    private void drawButtons(Graphics2D g) {
        tower1.draw(g);  //draws button for tower1
    }

    @Override
    public void mouseClicked(int x, int y) {
        if (tower1.getInitialBound().contains(x, y)) {  //checks if tower1 bounds are pressed (so if the button is pressed)
            System.out.println("You pressed me!");
        }

    }

    @Override
    public void mouseMoved(int x, int y) {  // checks if the mouse is hovering over the bounds of tower1

    }
}
