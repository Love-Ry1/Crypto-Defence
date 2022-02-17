package models;

import models.Enemy;

import javax.swing.*;

public class Enemy1 extends Enemy {


    public Enemy1(int posx, int posy) {
        super(posx, posy);
        setHealth(100);
        setSpeed(1);
        setDamage(10);
        setEnemySizeImage(new ImageIcon(getClass().getResource("/enemy.png"), "Monster").getImage());


    }

  /*  @Override
    public void drawEnemy(Graphics2D g) {
        g.drawImage(this.getEnemyImage(), 810, 900,null); // for setting the picture to the right position
    }*/
}
