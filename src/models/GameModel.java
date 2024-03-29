package models;

import controllers.GameScreen;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This GameModel class is for handling of all logic which the model of the game has.
 *  @author Love Rymo
 *  @version 2022-03-06
 */
public class GameModel implements Runnable, Serializable {
    private final int width;
    private final int height;
    private Tower[][] towerMap;
    private int currentBlockX;
    private int currentBlockY;
    private ArrayList<Enemy> enemyList;
    private GameScreen gameScreen;
    private Player player;
    private Shop shop;
    private MobWave mobWave;
    private int gameTick;
    private boolean saveGameFlag = false;
    private boolean loadGameFlag = false;
    private boolean nextLevelFlag = false;
    private boolean mapChangeFlag = false;
    private GameInfo gameInfo = new GameInfo();
    private BasicMap basicMap = new BasicMap();

    /**
     * This constructor initializes the GameModel
     * @param gameScreen the GameScreen
     */
    public GameModel(GameScreen gameScreen){
        this.width = BasicMap.getWidth();
        this.height = BasicMap.getHeight();
        this.towerMap = new Tower[width][height];
        this.enemyList = new ArrayList<>();
        this.gameScreen = gameScreen;
        this.shop = new Shop();
        this.mobWave = new MobWave(basicMap);
    }

    /**
     * The idea is that we get the position of the mouse and the functions uses it to find the current "models.Block"
     * @param posX the x-coordinate
     * @param posY the y-coordinate
     */
    public void posToBlock(int posX, int posY){
        currentBlockX = posX / Block.getHeight();
        currentBlockY = posY / Block.getWidth();
    }

    /**
     * Returns what block a X coordinate represents
     * @return the block which the X coordinate represents.
     */
    public int getCurrentBlockX(){
        return currentBlockX;
    }

    /**
     * Returns what block an Y coordinate represents
     * @return the block which the Y coordinate represents.
     */
    public int getCurrentBlockY(){
        return currentBlockY;
    }

    /**
     * This method is for adding a Tower to the game
     * @param posX the x-coordinate
     * @param posY the y-coordinate
     * @param towerName the towerName for the tower
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
     * This method is for creating a player
     */
    public void addPlayer(){
        player = new Player();
    }

    /**
     * this method is for setting of different flags
     */
    public void setButtonsPressed(){
        saveGameFlag = gameScreen.getBottomBarFrame().isButtonSave();
        loadGameFlag = gameScreen.getBottomBarFrame().isButtonLoad();
        nextLevelFlag = gameScreen.getBottomBarFrame().isButtonNextLevel();
        shop.setButton1(gameScreen.getBottomBarFrame().isButtonTower1());
        mapChangeFlag = gameScreen.getBottomBarFrame().isButtonChangeMap();
    }

    /**
     * This method saves the games state
     */
    public void saveGame(){
        // update GameInfo
        gameInfo.saveGameInfo(towerMap, enemyList, mobWave, player, basicMap, gameTick);

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
        saveGameFlag = false;
    }

    /**
     * This method loads the games last saved state
     */
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
        player = gameInfo.getPlayer();
        basicMap = gameInfo.getBasicMap();
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

            setButtonsPressed();
            if(mapChangeFlag){
                basicMap.changeMap();
            }

            if(nextLevelFlag){
                mobWave.nextLevel();
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
                    if (player.getHealth() <= 0){
                        JOptionPane.showMessageDialog(null, "YOU LOST");
                        System.exit(0);
                    }
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

            if (gameScreen.getPosX() >= 0 && gameScreen.getPosY() >= 0){
                shop.setCoordinates(gameScreen.getPosX(), gameScreen.getPosY());
            }

            if (shop.addTower()){
                addTower(shop.getPosX(), shop.getPosY(), Tower.TowerName.BASIC);
                shop.reset();
                gameScreen.getBottomBarFrame().setButtonTower1(false);
            }

            if(saveGameFlag){
                saveGame();
            }

            if (loadGameFlag){
                loadGame();
            }

            gameScreen.getBottomBarFrame().resetButtons();
            gameScreen.update(enemyList, towerMap, player, basicMap);
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }

}
