package controllers;

import models.Block;
import models.Enemy;

import java.awt.*;
import java.util.ArrayList;

public class DrawEnemies {
    ArrayList<Enemy> enemies;

    public DrawEnemies(ArrayList<Enemy> enemies){
        this.enemies = enemies;
    }

    public void draw(Graphics2D g) {
        if (enemies != null) {
            for (int i = 0; i < enemies.size(); i++) {
                Enemy enemy = enemies.get(i);
                g.drawImage(enemy.getEnemyImage(), enemy.getPosX() - enemy.getEnemyImage().getWidth(null)/2,
                        enemy.getPosY() - enemy.getEnemyImage().getHeight(null) / 2, null);
                Color oldColor = g.getColor();
                g.setColor(Color.white);
                String string = "hp: " + enemy.getHealth();
                FontMetrics metrics = g.getFontMetrics(g.getFont());
                int x = enemy.getPosX() + enemy.getEnemyImage().getWidth(null) / 2 - metrics.stringWidth(string);
                g.drawString("hp: " + enemy.getHealth(), x, enemy.getPosY() + 25);
                g.setColor(oldColor);
            }
        }
    }
}
