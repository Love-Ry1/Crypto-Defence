package models;

import controllers.GameScreen;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class GameModel implements Runnable, Serializable {
    private final int width;
    private final int height;
    private Tower[][] towerMap;
    private int currentBlockX;
    private int currentBlockY;
    private ArrayList<Enemy> enemyList;
    private transient GameScreen gameScreen;
    private Player player;
    private transient Shop shop;
    private MobWave mobWave = new MobWave();
    private int gameTick;
    private transient boolean saveGameFlag = false;
    private boolean loadGameFlag = false;
    private GameInfo gameInfo = new GameInfo();


    public GameModel(GameScreen gameScreen){
        this.width = BasicMap.getWidth();
        this.height = BasicMap.getHeight();
        this.towerMap = new Tower[width][height];
        this.enemyList = new ArrayList<>();
        this.gameScreen = gameScreen;
        this.shop = new Shop(this);

    }

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
        if (currentBlockX < 10 && currentBlockY < 10) {       // change so not hard coded
            if (towerName == Tower.TowerName.BASIC) {
                newTower = new BasicTower(currentBlockX * Block.getWidth(), currentBlockY * Block.getHeight());
            }
            towerMap[currentBlockX][currentBlockY] = newTower;
        }
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

    public Shop getShop(){
        return shop;
    }

    public MobWave getMobWave(){
        return mobWave;
    }

    public GameModel getGameModel(){
        return this;
    }

    public void setSaveGameFlag(Boolean value){
        this.saveGameFlag = value;
    }

    public void setLoadGameFlag(Boolean value){
        this.loadGameFlag = value;
    }

    public void saveGame(){
        // update GameInfo
        gameInfo.saveGameInfo(towerMap, enemyList, mobWave, player, gameTick);

        // serialize it
        try {
            FileOutputStream fileOut = new FileOutputStream("modelState.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(gameInfo);
            out.close();
            fileOut.close();
            System.out.println("saved!");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadGame(){
        // deserialize saved game
        try {
            FileInputStream fileIn = new FileInputStream("modelState.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            gameInfo = (GameInfo) in.readObject();
            in.close();
            fileIn.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        // change current variables with the saved ones
        towerMap = gameInfo.getTowerMap();
        enemyList = gameInfo.getEnemyList();
        mobWave = gameInfo.getMobWave();
        gameTick = gameInfo.getGameTick();

        loadGameFlag = false;
    }

    /**
     * This method is for running the game "gameloops"
     */
    public void run(){
        addPlayer();
        mobWave.loadWave();

        boolean running = true;
        while(running){
            if (gameTick >= 1000000){
                gameTick = 0;
            } else {
                gameTick++;
            }

            mobWave.loadWave();
            if (gameTick % 80 == 1){       // maybe move this into mobwave.update()?
                Enemy nextEnemy = mobWave.nextMob();
                if(nextEnemy != null) {
                    enemyList.add(nextEnemy);
                }
            }

            for (Iterator<Enemy> it = enemyList.iterator(); it.hasNext();){
                Enemy enemy = it.next();
                enemy.enemyUpdate();
                if (enemy.isDead()){
                    it.remove();
                    PlaySound playSound = new PlaySound();
                    playSound.playDeath1();
                }
                if (enemy.isOnEndBlock()){
                    player.takeDamage(enemy.getDamage());
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

            if (shop.addTower()){
                addTower(shop.getPosX(), shop.getPosY(), Tower.TowerName.BASIC);
                shop.reset();
            }
            gameScreen.update(enemyList, towerMap, player);

            if(saveGameFlag){
                saveGame();
                saveGameFlag = false;
            }

            if (loadGameFlag){
                loadGame();
            }

            try {
                Thread.sleep(20);
            } catch (InterruptedException ex){
            }
        }
    }
}
