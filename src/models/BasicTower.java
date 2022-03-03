package models;

import models.Tower;

import javax.swing.*;

/**
 * This class represents a basic tower, which is a type of tower
 */
public class BasicTower extends Tower {

    protected BasicTower(int posX, int posY){
        super(posX, posY);
        setDamage(5);
        setRange(200);
        setCost(25);
        setAttackCoolDown(5);
        setTowerName(TowerName.BASIC);
    }

}
