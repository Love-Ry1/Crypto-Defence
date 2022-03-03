package controllers;

import models.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * This class creates a Jpanel
 */
public class GameScreen extends JPanel implements MouseMethods {
    private BottomBarFrame bottomBarFrame;
    private MyMouseListener mouseMouseListener;
    private GameFrame gameFrame;
    private ArrayList<Enemy> enemyList;
    private Tower[][] towerMap;
    private Player player;
    private int posX, posY;
    private DrawBasicMap drawBasicMap = new DrawBasicMap();
    public GameScreen(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        bottomBarFrame = new BottomBarFrame(0, 800, 815, 185, this);
    }

    /**
     * This method is for painting all components in the screen
     * @param gr
     */
    public void paintComponent(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;
        g.clearRect(0, 0, this.getWidth(), this.getHeight());   // Clears the screen

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

    public BottomBarFrame getBottomBarFrame(){
        return bottomBarFrame;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY(){
        return posY;
    }

    public void update(ArrayList<Enemy> enemyList, Tower[][] towerMap, Player player, BasicMap basicMap){
        this.player = player;
        this.enemyList = enemyList;
        this.towerMap = towerMap;
        this.posX = -1;
        this.posY = -1;
        this.drawBasicMap.setBasicMap(basicMap);
        repaint();
    }

    public void initInputs() {
        mouseMouseListener = new MyMouseListener(gameFrame);

        addMouseListener(mouseMouseListener);
        addMouseMotionListener(mouseMouseListener);
        requestFocus();
    }

    @Override
    public void mouseMoved(int x, int y) {
        bottomBarFrame.mouseMoved(x, y);
    }

    @Override
    public void mousePressed(int x, int y) {
        bottomBarFrame.mousePressed(x, y);
        if (y < bottomBarFrame.getY()) {
            this.posX = x;
            this.posY = y;
        }
    }
}
