package controllers;

import models.Block;
import models.GameModel;
import models.Tower;

import javax.swing.*;
import java.awt.*;

/**
 * This class draws the towers
 */
public class DrawTowers {
    private Tower[][] towers;
    private Image currentImage = null;
    private final Image basicImage = new ImageIcon(getClass().getResource("/basictower.png"), "models.BasicTower").getImage();

    public DrawTowers(Tower[][] towers){
        this.towers = towers;
    }

    /**
     * This method chooses the correct image for a tower
     * @param tower
     */
    public void chooseImage(Tower tower){
        Tower.TowerName name = tower.getTowerName();
        switch (name){
            case BASIC:
                currentImage = basicImage;
                break;

            default:
                currentImage = null;    // maybe add a white picture here to avoid errors?
                System.out.println("No image was found");
        }
    }

    /**
     * This method is used for drawing towers
     * @param g
     */
    public void draw(Graphics2D g){
        if(this.towers != null) {
            for (int i = 0; i < towers.length; i++) {
                for (int j = 0; j < towers[0].length; j++) {
                    Tower currentTower = towers[i][j];
                    if (currentTower != null) {
                        chooseImage(currentTower);
                        g.drawImage(currentImage, currentTower.getPosX() +
                                   ((Block.getWidth() - currentImage.getWidth(null)) / 2),
                                currentTower.getPosY() + ((Block.getHeight() - currentImage.getHeight(null)) / 2), null);
                    }
                }
            }
        }
    }
}
