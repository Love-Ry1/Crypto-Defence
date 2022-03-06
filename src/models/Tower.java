package models;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This is an abstract class for having all information about Tower and their functionality
 */
public abstract class Tower implements Serializable {
    private int posX;
    private int posY;
    private int range;
    private int damage;
    private int attackCoolDown;
    private int attackCoolDownTick = 0;
    private int cost;
    private ArrayList<Bullets> bullets = new ArrayList<>();
    public enum TowerName{
        BASIC
    }
    private TowerName towerName;

    /**
     * This method sets the position x and y for the tower
     *
     * @param posX the x-coordinate
     * @param posY the y-coodinate
     */
    protected Tower(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }

    /**
     * This method sets the damage
     * @param damage the damage that we are setting
     */
    public void setDamage(int damage){
        this.damage = damage;
    }

    /**
     * This method return the damage
     * @return the damage
     */
    public int getDamage(){
        return this.damage;
    }

    /**
     * this method sets the range
     * @param range the range for the tower
     */
    public void setRange(int range){
        this.range = range;
    }

    /**
     * This method returns the range
     * @return the range for the towers
     */
    public int getRange(){
        return this.range;
    }

    /**
     * This method sets a cooldown for the towers so it does not constantly shoot bullets
     * @param coolDown the amount of time for the tower to wait before shooting again
     */
    public void setAttackCoolDown(int coolDown){
        attackCoolDown = coolDown;
    }

    /**
     * This method set the cost
     * @param cost the cost for the tower
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * This method return the cost
     * @return the cost for the tower
     */
    public int getCost(){
        return this.cost;
    }

    /**
     * This method return the x-coordinate
     * @return the x-coordinate
     */
    public int getPosX(){
        return this.posX;
    }

    /**
     * This method return the y-coordinate
     * @return the y-coordinate
     */
    public int getPosY(){
        return this.posY;
    }

    /**
     * This method return name of the tower
     * @return the name of the tower
     */
    public TowerName getTowerName() {
        return towerName;
    }

    /**
     * This method sets a name to the tower
     * @param towerName the name for the tower
     */
    public void setTowerName(TowerName towerName) {
        this.towerName = towerName;
    }

    /**
     * This method shoots the bullet toward the enemy by setting a specific coordinates
     * @param enemy the enemy
     */
    public void shoot(Enemy enemy){    // Do this abstract or use bullet type so different towers can use different bullets
        // also need a method to calculate the direction
        bullets.add(new BasicBullet(posX + Block.getWidth()/2, posY, Bullets.Direction.NORTH, enemy));
        PlaySound playSound = new PlaySound();
        playSound.playShot1();
    }

    /**
     * This method return the first enemy which is in the range,
     * @param enemyList the enemyList for enemies
     * @return the enemy that is first in range of the towers
     */
    // returnerar första enemyn som är i range, är inte perfekt implementerad eftersom models.Enemy klassen inte är klar än
    public Enemy firstEnemyInRange(ArrayList<Enemy> enemyList){
        for (int i = 0; i < enemyList.size(); i++){
            Enemy currentEnemy = enemyList.get(i);
            double x2 = Math.pow(currentEnemy.getPosX() - posX, 2);
            double y2 = Math.pow(currentEnemy.getPosY() - posY, 2);
            double distance = Math.sqrt(x2 + y2);
            if(distance < range){
                return currentEnemy;
            }
        }
        return null;
    }

    /**
     * This method return the bullets
     * @return the bullets
     */
    public ArrayList<Bullets> getBullets(){
        return bullets;
    }

    /**
     * This method update the state of the bullet and shooting the first enemy
     * @param enemyList the enemyList
     */
    public void update(ArrayList<Enemy> enemyList){
        Enemy firstEnemy = firstEnemyInRange(enemyList);
        if(firstEnemy != null && attackCoolDownTick > (attackCoolDown * 5)){
            shoot(firstEnemy);
            attackCoolDownTick = 0;
        } else{
            attackCoolDownTick++;
        }

        for (Iterator<Bullets> it = bullets.iterator(); it.hasNext();){
            Bullets bullet = it.next();

            bullet.update();
            if (bullet.hitTarget()){
                bullet.getEnemy().takeDamage(damage);
                it.remove();
            }
        }
    }
}
