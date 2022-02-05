import java.awt.*;

public abstract class Tower {
    private int posX;
    private int posY;
    private int damage;
    private int range;
    private int attackSpeed;
    private int cost;
    private Image towerImage;
    private Bullets[] bullets;

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

    public void shoot(){
        // TODO when turret is shooting add bullet to the bullet array
    }

    public abstract void drawTower(Graphics2D g);

}
