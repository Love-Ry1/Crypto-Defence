package models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class has the essential info to set a GameModel state, and it is used to serializable the state of a GameModel
 */
public class GameInfo implements Serializable {
    private BasicMap basicMap;
    private Tower[][] towerMap;
    private ArrayList<Enemy> enemyList;
    private MobWave mobWave;
    private Player player;
    private int gameTick;

    /**
     * This method saves the information from the following parameters
     * @param towerMap the towerMap array that contains our towers
     * @param enemyList the enemyList list that contains our enemies
     * @param mobWave the mobWave class that contains the mob waves
     * @param player the player class that contains the players health and gold
     * @param gameTick the gameTick
     */
    public void saveGameInfo(Tower[][] towerMap, ArrayList<Enemy> enemyList, MobWave mobWave, Player player, BasicMap basicMap, int gameTick){
        this.towerMap = towerMap;
        this.enemyList = enemyList;
        this.mobWave = mobWave;
        this.player = player;
        this.basicMap = basicMap;
        this.gameTick = gameTick;
    }

    /**
     * this method returns towerMap
     * @return the towerMap
     */
    public Tower[][] getTowerMap() {
        return towerMap;
    }

    /**
     * this method returns enemyList
     * @return the enemyList
     */
    public ArrayList<Enemy> getEnemyList() {
        return enemyList;
    }

    /**
     * this method returns mobWave
     * @return the mobWave
     */
    public MobWave getMobWave() {
        return mobWave;
    }

    /**
     * this method returns player
     * @return the player
     */
    public Player getPlayer(){
        return player;
    }

    public BasicMap getBasicMap(){
        return basicMap;
    }

    /**
     * This method is used to keep track of the time in the game
     * @return the gameTick
     */
    public int getGameTick() {      // Gametick used to keep track of the in-game time
        return gameTick;
    }

}
