package models;

import models.Tower;

import javax.swing.*;

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
