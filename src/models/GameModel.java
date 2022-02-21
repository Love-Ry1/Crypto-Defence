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

    //

    /**
     * The idea is that we get the position of the mouse and the functions uses it to find the current "models.Block"
     *  There is probably a better way to this lol
     * @param posX
     * @param posY
     */
    public void posToBlock(int posX, int posY){
        currentBlockX = posX / Block.getHeight();
        currentBlockY = posY / Block.getWidth();
    }

    /**
     * This method is for adding a Tower to the game
     * @param posX
     * @param posY
     * @param towerName
     */
    public void addTower(int posX, int posY, Tower.TowerName towerName) {
        posToBlock(posX, posY);
        BasicTower newTower = null;
        if (towerName == Tower.TowerName.BASIC) {
            newTower = new BasicTower(currentBlockX * Block.getWidth(), currentBlockY * Block.getHeight());
        }
        towerMap[currentBlockX][currentBlockY] = newTower;
    }

    /**
     * This method returns the Tower
     * @return
     */
    public Tower[][] getTowerMap(){
        return towerMap;
    }

    /**
     * addEnemy is for adding a new Enemy in the game
     * @param posX
     * @param posY
     */
    public void addEnemy(int posX, int posY){
        Enemy enemy = new Enemy1(posX, posX);
        enemyList.add(enemy);
    }

    /**
     * This method is for adding a player
     */
    public void addPlayer(){
        player = new Player();
    }

    /**
     * This method is for running the game "gameloops"
     */
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
