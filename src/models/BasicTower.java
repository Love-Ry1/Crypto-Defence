package models;

/**
 * This class represents a BasicTower, which is a type of tower
 */
public class BasicTower extends Tower {
    /**
     * This class initializes a BasicTower
     * @param posX the x-coordinate
     * @param posY the y-coordinate
     */
    protected BasicTower(int posX, int posY){
        super(posX, posY);
        setDamage(5);
        setRange(200);
        setCost(25);
        setAttackCoolDown(5);
        setTowerName(TowerName.BASIC);
    }

}
