package controllers;

import models.Block;
import models.Enemy;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * This class draws the enemies on the map
 */
public class DrawEnemies {
    ArrayList<Enemy> enemies;
    Image image = new ImageIcon(getClass().getResource("/enemy.png"), "Monster").getImage();

    /**
     *
     * @param enemies
     */
    public DrawEnemies(ArrayList<Enemy> enemies){
        this.enemies = enemies;
    }

    /**
     * This method is used for drawing the enemies
     * @param g
     */
    public void draw(Graphics2D g) {
        if (enemies != null) {
            for (int i = 0; i < enemies.size(); i++) {
                Enemy enemy = enemies.get(i);
                g.drawImage(image, enemy.getPosX() - image.getWidth(null)/2,
                        enemy.getPosY() - image.getHeight(null) / 2, null);
                Color oldColor = g.getColor();
                g.setColor(Color.white);
                String string = "hp: " + enemy.getHealth();
                FontMetrics metrics = g.getFontMetrics(g.getFont());
                int x = enemy.getPosX() + image.getWidth(null) / 2 - metrics.stringWidth(string);
                g.drawString("hp: " + enemy.getHealth(), x, enemy.getPosY() + 25);
                g.setColor(oldColor);
            }
        }
    }
}
