package models;

import java.io.*;
import java.util.LinkedList;

/**
 * This class is for generating different waves of enemies
 */
public class MobWave implements Serializable {
    private LinkedList<Enemy> wave = new LinkedList<>();
    private int level = 0;
    private int oldLevel = 0;
    private transient InputStream is;
    private transient BufferedReader bf;
//    private GameModel gameModel;
    private BasicMap basicMap;

    public MobWave(BasicMap basicMap){
        this.basicMap = basicMap;
        try {
            is = getClass().getClassLoader().getResourceAsStream("waves.txt");
            bf = new BufferedReader(new InputStreamReader(is));       // change to getResource
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * This method returns basicMap
     * @return the basicMap
     */
    public BasicMap getBasicMap(){
        return basicMap;
    }

    /**
     * This method reads the proper wave from a text file
     */
    public void loadWave(){
        if (is == null ||bf == null){
            try {
                is = getClass().getClassLoader().getResourceAsStream("waves.txt");
                bf = new BufferedReader(new InputStreamReader(is));       // change to getResource
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        if (level > oldLevel) {
            try {
                String levelString = "level" + level;
                String line = bf.readLine();
                if (line != null && line.contains(levelString)) {
                    line = bf.readLine();

                    while (line != null && !line.contains(";")) {

                        if (line.contains("enemy1")) {
                            String[] splitLine = line.split(": ", 2);
                            int quantity = Integer.parseInt(splitLine[1]);
                            addToArray(quantity, "Enemy1");
                        }
                        line = bf.readLine();
                    }
                    oldLevel++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * This method adds enemies to the enemy list
     * @param quantity the amount of enemies that needs to be created
     * @param enemy the enemy
     */
    public void addToArray(int quantity, String enemy){      // should use polymorphism.. this breaks OCP
        for(int i = 0; i < quantity; i++){                  // if we have time we change it
            if (enemy.equals("Enemy1")){
                Enemy1 newEnemy = new Enemy1(20, 20, this);
                wave.add(newEnemy);
            }
        }
    }

    /**
     * This method returns the next enemy in the linked list and removes it
     * @return the next enemy in the linked list and removes it
     */
    public Enemy nextMob(){
        return wave.pollFirst();
    }

    /**
     * This method goes to the next level
     */
    public void nextLevel(){
        oldLevel = level;
        level++;
        System.out.println("level: " + level);
    }

}
