package models;

import java.io.Serializable;
import java.util.ArrayList;

public class GameInfo implements Serializable {
    private Tower[][] towerMap;
    private ArrayList<Enemy> enemyList;
    private MobWave mobWave;
    private Player player;
    private int gameTick;

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

    public int getGameTick() {
        return gameTick;
    }
}
