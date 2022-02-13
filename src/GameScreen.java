import javax.swing.*;
import java.awt.*;

public class GameScreen extends JPanel implements MouseMethods {
    private BottomBarFrame bottomBarFrame;
    private MyMouseListener mouseMouseListener;
    private GameFrame gameFrame;

    public GameScreen(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        bottomBarFrame = new BottomBarFrame(0, 800, 815, 185);

    }


    public void paintComponent(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;
        g.clearRect(0, 0, this.getWidth(), this.getHeight());   // Clears the screen

        //BasicMap basicMap = new BasicMap();     // just for testing move later
        //basicMap.drawMap(g);

        DrawBasicMap drawBasicMap = new DrawBasicMap();
        drawBasicMap.draw(g);

        GameModel gameModel = new GameModel();      // just for testing tower mechanics, remove later
        gameModel.addTower(250, 85, Tower.TowerName.BASIC);
        gameModel.drawTowerMap(g);


        gameModel.addEnemy(20, 20);
        gameModel.drawEnemies(g);

        bottomBarFrame.draw(g);

    }

    public void initInputs() {
        mouseMouseListener = new MyMouseListener(gameFrame);

        addMouseListener(mouseMouseListener);
        addMouseMotionListener(mouseMouseListener);
        requestFocus();
    }


    @Override
    public void mouseClicked(int x, int y) {
        bottomBarFrame.mouseClicked(x, y);
    }

    @Override
    public void mouseMoved(int x, int y) {
        bottomBarFrame.mouseMoved(x, y);
    }

    @Override
    public void mousePressed(int x, int y) {
        bottomBarFrame.mousePressed(x, y);
    }

    @Override
    public void mouseReleased(int x, int y) {
        bottomBarFrame.mouseReleased(x, y);
    }
}
