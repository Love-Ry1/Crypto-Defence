package models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class has the essential info to set a gamemodel state, and its used to serializable the state of a gamemodel
 */
public class GameInfo implements Serializable {
    private Tower[][] towerMap;
    private ArrayList<Enemy> enemyList;
    private MobWave mobWave;
    private Player player;
    private int gameTick;

    /**
     * ?????
     * @param towerMap
     * @param enemyList
     * @param mobWave
     * @param player
     * @param gameTick
     */
    public void saveGameInfo(Tower[][] towerMap, ArrayList<Enemy> enemyList, MobWave mobWave, Player player, int gameTick){
        this.towerMap = towerMap;
        this.enemyList = enemyList;
        this.mobWave = mobWave;
        this.player = player;
        this.gameTick = gameTick;
    }

    public Tower[][] getTowerMap() {
        return towerMap;
    }

    public ArrayList<Enemy> getEnemyList() {
        return enemyList;
    }

    public MobWave getMobWave() {
        return mobWave;
    }

    public Player getPlayer(){
        return player;
    }

    /**
     * This method is used to keep track of the time in the game
     * @return the gametick
     */
    public int getGameTick() {
        return gameTick;
    } // Gametick used to keep track of the time ingame
}
