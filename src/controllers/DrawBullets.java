package controllers;

import models.Block;
import models.Bullets;
import models.Tower;

import java.awt.*;
import java.util.ArrayList;

public class DrawBullets {

        private Tower[][] towers;
        private ArrayList<Bullets> bullets;

        public DrawBullets(Tower[][] towers){
            this.towers = towers;
        }

        public void draw(Graphics2D g){
            if(this.towers != null) {
                for (int i = 0; i < towers.length; i++) {
                    for (int j = 0; j < towers[0].length; j++) {
                        Tower currentTower = towers[i][j];
                        if (currentTower != null) {
                            bullets = currentTower.getBullets();
                            for(Bullets bullet : bullets){
                                g.drawImage(bullet.getBulletImage(), bullet.getPosX(), bullet.getPosY(), null);
                            }
                        }
                    }
                }
            }
        }
    }

