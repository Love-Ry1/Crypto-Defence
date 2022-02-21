package models;

import java.awt.*;
import java.util.ArrayList;

public abstract class Tower {
    private int posX;
    private int posY;
    private int range;
    private int damage;
    private int attackSpeed;
    private int cost;
    private Image towerImage;
    private ArrayList<Bullets> bullets = new ArrayList<>();
    public enum TowerName{
        BASIC
    }
    private TowerName towerName;

    protected Tower(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }

    public void setDamage(int damage){
        this.damage = damage;
    }

    public int getDamage(){
        return this.damage;
    }

    public void setRange(int range){
        this.range = range;
    }

    public int getRange(){
        return this.range;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public int getAttackSpeed(){
        return this.attackSpeed;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCost(){
        return this.cost;
    }

    public int getPosX(){
        return this.posX;
    }

    public int getPosY(){
        return this.posY;
    }

    public void setTowerImage(Image image){
        this.towerImage = image;
    }

    public Image getTowerImage(){
        return this.towerImage;
    }

    public TowerName getTowerName() {
        return towerName;
    }

    public void setTowerName(TowerName towerName) {
        this.towerName = towerName;
    }

    public void shoot(Enemy enemy){    // Do this abstract or use bullet type so different towers can use different bullets
        // also need a method to calculate the direction
        bullets.add(new BasicBullet(posX + Block.getWidth()/2, posY, Bullets.Direction.NORTH, enemy));
        System.out.println("shoot!");
    }

    public void removeBullet(Bullets bullet){
        bullets.remove(bullet);
    }

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

    public ArrayList<Bullets> getBullets(){
        return bullets;
    }

    public void update(ArrayList<Enemy> enemyList){
        Enemy firstEnemy = firstEnemyInRange(enemyList);
        if(firstEnemy != null){
            shoot(firstEnemy);
        }
        for (Bullets bullet : bullets){
            bullet.update();
        }
    }
}
