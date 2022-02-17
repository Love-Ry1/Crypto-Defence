package models;

import java.awt.*;
import java.util.ArrayList;

public class GameModel {
    private final int width;
    private final int height;
    private Tower[][] towerMap;
    private int currentBlockX;
    private int currentBlockY;
    private ArrayList<Enemy> enemyList;

    public GameModel(){
        this.width = BasicMap.getWidth();
        this.height = BasicMap.getHeight();
        this.towerMap = new Tower[width][height];
        this.enemyList = new ArrayList<>();
    }

    // The idea is that we get the position of the mouse and the functions uses it to find the current "models.Block"
    // There is probably a better way to this lol
    public void posToBlock(int posX, int posY){
        currentBlockX = posX / Block.getHeight();
        currentBlockY = posY / Block.getWidth();
    }

    public void addTower(int posX, int posY, Tower.TowerName towerName) {
        posToBlock(posX, posY);
        BasicTower newTower = null;
        if (towerName == Tower.TowerName.BASIC) {
            newTower = new BasicTower(currentBlockX * Block.getWidth(), currentBlockY * Block.getHeight());
        }
        towerMap[currentBlockX][currentBlockY] = newTower;
    }

    public Tower[][] getTowerMap(){
        return towerMap;
    }

    public void addEnemy(int posX, int posY){
        Enemy enemy = new Enemy1(posX, posX);
        enemyList.add(enemy);
    }

    public void moveEnemies(){
        for (Enemy enemy : enemyList){
            enemy.move(1, 1);
        }
    }

    public void drawEnemies(Graphics2D g){
        for (Enemy enemy : enemyList){
            enemy.drawEnemy(g);
        }
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

}
