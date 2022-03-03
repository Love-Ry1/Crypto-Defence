package models;

import models.Enemy;

import javax.swing.*;

/**
 * This class represents Enemy1
 */
public class Enemy1 extends Enemy {
    /**
     * This constructor initializes Enemy1
     * @param posx the x-coordinate
     * @param posy the y-coordinate
     */
    public Enemy1(int posx, int posy) {
        super(posx, posy);
        setHealth(100);
        setSpeed(1);
        setDamage(10);
        setWidth(42);
        setHeight(32);
    }

}
