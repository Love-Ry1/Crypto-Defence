package models;

import models.Enemy;

import javax.swing.*;

/**
 * This class represents Enemy1
 */
public class Enemy1 extends Enemy {

    public Enemy1(int posx, int posy, MobWave mobWave) {
        super(posx, posy, mobWave);
        setHealth(100);
        setSpeed(1);
        setDamage(10);
        setWidth(42);
        setHeight(32);
    }

}
