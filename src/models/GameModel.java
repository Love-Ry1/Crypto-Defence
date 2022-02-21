package models;

import controllers.GameScreen;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class GameModel implements Runnable{
    private final int width;
    private final int height;
    private Tower[][] towerMap;
    private int currentBlockX;
    private int currentBlockY;
    private ArrayList<Enemy> enemyList;
    private GameScreen gameScreen;
    private Player player;

    public GameModel(GameScreen gameScreen){
        this.width = BasicMap.getWidth();
        this.height = BasicMap.getHeight();
        this.towerMap = new Tower[width][height];
        this.enemyList = new ArrayList<>();
        this.gameScreen = gameScreen;
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

    public void addPlayer(){
        player = new Player();
    }

    public void run(){
        addPlayer();
        addEnemy(20, 40);
        addTower(250, 85, Tower.TowerName.BASIC);
        addTower(400, 100, Tower.TowerName.BASIC);    // just testing
        boolean running = true;
        while(running){

            for (Iterator<Enemy> it = enemyList.iterator(); it.hasNext();){
                Enemy enemy = it.next();
                enemy.enemyUpdate();
                if (enemy.isDead()){
                    it.remove();
                }
            }


            for (int i = 0; i < towerMap.length; i++){
                for (int j = 0; j < towerMap[0].length; j++){
                    if (towerMap[i][j] != null){
                        towerMap[i][j].update(enemyList);
                    }
                }
            }

            gameScreen.update(enemyList, towerMap, player);
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex){
            }
        }
    }
}
