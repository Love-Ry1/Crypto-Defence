package controllers;

import models.Enemy;
import models.GameModel;
import models.Player;
import models.Tower;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameScreen extends JPanel implements MouseMethods {
    private BottomBarFrame bottomBarFrame;
    private MyMouseListener mouseMouseListener;
    private GameFrame gameFrame;
    private ArrayList<Enemy> enemyList;
    private Tower[][] towerMap;
    private GameModel gameModel;
    private Player player;

    public GameScreen(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        bottomBarFrame = new BottomBarFrame(0, 800, 815, 185);
    }

    /**
     * This method is for painting all components in the screen
     * @param gr
     */
    public void paintComponent(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;
        g.clearRect(0, 0, this.getWidth(), this.getHeight());   // Clears the screen

        DrawBasicMap drawBasicMap = new DrawBasicMap();
        drawBasicMap.draw(g);

        DrawTowers drawTowers = new DrawTowers(this.towerMap);
        drawTowers.draw(g);

        DrawBullets drawBullets = new DrawBullets(towerMap);
        drawBullets.draw(g);

        DrawEnemies drawEnemies = new DrawEnemies(enemyList);
        drawEnemies.draw(g);

        DrawPlayer drawPlayer = new DrawPlayer(player);
        drawPlayer.draw(g);

        bottomBarFrame.draw(g);
    }

    public void setGameModel(GameModel gameModel){
        this.gameModel = gameModel;
    }

    public void update(ArrayList<Enemy> enemyList, Tower[][] towerMap, Player player){
        this.player = player;
        this.enemyList = enemyList;
        this.towerMap = towerMap;
        repaint();
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
