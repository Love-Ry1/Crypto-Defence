package models;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

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
     * @param posX
     * @param posY
     */
    protected Tower(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }

    /**
     * This method sets the damage
     * @param damage
     */
    public void setDamage(int damage){
        this.damage = damage;
    }

    /**
     * This method return the damage
     * @return
     */
    public int getDamage(){
        return this.damage;
    }

    /**
     * this method sets the range
     * @param range
     */
    public void setRange(int range){
        this.range = range;
    }

    /**
     * This method returns the range
     * @return
     */
    public int getRange(){
        return this.range;
    }

    /**
     * This method sets ................
     * @param coolDown
     */
    public void setAttackCoolDown(int coolDown){
        attackCoolDown = coolDown;
    }

    /**
     * This method set the cost
     * @param cost
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * This method return the cost
     * @return
     */
    public int getCost(){
        return this.cost;
    }

    /**
     * This method return the position x
     * @return
     */
    public int getPosX(){
        return this.posX;
    }

    /**
     * This method return the position Y
     * @return
     */
    public int getPosY(){
        return this.posY;
    }

    /**
     * This method return name of the tower
     * @return
     */
    public TowerName getTowerName() {
        return towerName;
    }

    /**
     * This method sets a name to the tower
     * @param towerName
     */
    public void setTowerName(TowerName towerName) {
        this.towerName = towerName;
    }

    /**
     * This method shoot the bullet toward the enemy by seting a specific coordinates
     * @param enemy
     */
    public void shoot(Enemy enemy){    // Do this abstract or use bullet type so different towers can use different bullets
        // also need a method to calculate the direction
        bullets.add(new BasicBullet(posX + Block.getWidth()/2, posY, Bullets.Direction.NORTH, enemy));
    }

    /**
     * This method return the first enemy which is in the range,
     * @param enemyList
     * @return
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
     * @return
     */
    public ArrayList<Bullets> getBullets(){
        return bullets;
    }

    /**
     * This method update the state of the bullet and shooting the first enemy
     * @param enemyList
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
