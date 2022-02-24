package models;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class MobWave {
    private LinkedList<Enemy> wave = new LinkedList<>();
    private int level = 1;
    private int oldLevel = 0;
    InputStream is;
    BufferedReader bf;

    public MobWave(){
        try {
            is = getClass().getClassLoader().getResourceAsStream("waves.txt");
            bf = new BufferedReader(new InputStreamReader(is));       // change to getResource
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadWave(){
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
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void addToArray(int quantity, String enemy){      // should use polymorphism.. this breaks OCP
        for(int i = 0; i < quantity; i++){                  // if we have time we change it
            if (enemy.equals("Enemy1")){
                Enemy1 newEnemy = new Enemy1(20, 20);
                wave.add(newEnemy);
            }
        }
    }

    public Enemy nextMob(){
        return wave.pollFirst();
    }

    public void nextLevel(){
        oldLevel = level;
        level++;
        System.out.println("level: " + level);
    }


}
