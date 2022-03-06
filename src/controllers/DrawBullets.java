package controllers;

import models.Bullets;
import models.Tower;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * This class draws the bullets
 *  @author Basem Ali
 *  @version 2022-03-06
 */
public class DrawBullets {
    private Tower[][] towers;
    private ArrayList<Bullets> bullets;
    Image image = new ImageIcon(getClass().getResource("/basicbullet.png"), "bascicBullet").getImage();

    /**
     *  This is the constructor for initiating the towers
     * @param towers the Tower in the Tower array
     */
    public DrawBullets(Tower[][] towers){
            this.towers = towers;
        }

    /**
     * This method draws the bullets for each tower
     * @param g
     */
    public void draw(Graphics2D g){
        if(this.towers != null) {
            for (int i = 0; i < towers.length; i++) {
                for (int j = 0; j < towers[0].length; j++) {
                    Tower currentTower = towers[i][j];
                    if (currentTower != null) {
                        bullets = currentTower.getBullets();
                        for(Bullets bullet : bullets){
                            g.drawImage(image, bullet.getPosX(), bullet.getPosY(), null);
                        }
                    }
                }
            }
        }
    }

}

