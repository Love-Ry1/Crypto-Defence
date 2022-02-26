package models;

import models.Enemy;

import javax.swing.*;

public class Enemy1 extends Enemy {

    public Enemy1(int posx, int posy) {
        super(posx, posy);
        setHealth(100);
        setSpeed(1);
        setDamage(10);
        setWidth(42);
        setHeight(32);
    }

}
