package controllers;

import models.Block;
import models.GameModel;
import models.Tower;

import java.awt.*;

public class DrawTowers {
    private Tower[][] towers;

    public DrawTowers(Tower[][] towers){
        this.towers = towers;
    }

    /**
     * This method is used for drawing Towers on the map
     * @param g
     */
    public void draw(Graphics2D g){
        if(this.towers != null) {
            for (int i = 0; i < towers.length; i++) {
                for (int j = 0; j < towers[0].length; j++) {
                    Tower currentTower = towers[i][j];
                    if (currentTower != null) {
                        g.drawImage(currentTower.getTowerImage(), currentTower.getPosX() +
                                        ((Block.getWidth() - currentTower.getTowerImage().getWidth(null)) / 2),
                                currentTower.getPosY() + ((Block.getHeight() - currentTower.getTowerImage().getHeight(null)) / 2), null);
                    }
                }
            }
        }
    }
}
