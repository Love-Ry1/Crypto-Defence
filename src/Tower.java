import java.awt.*;

public abstract class Tower {
    private int damage;
    private int range;
    private int attackSpeed;
    private int cost;
    private Image towerImage;
    private int posX;
    private int posY;

    protected Tower(){

    }

    public int getDamage(){
        return this.damage;
    }

    public int getRange(){
        return this.range;
    }
    public int getAttackSpeed(){
        return this.attackSpeed;
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

    public abstract void drawTower();

}
