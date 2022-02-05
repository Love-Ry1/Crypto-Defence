import java.awt.*;

public abstract class Tower {
    private int posX;
    private int posY;
    private int range;
    private int damage;
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

    //Metod för range om tornet är i "range"
    public boolean Range(int xCordinate, int yCordinate){

        double x2 = Math.pow((xCordinate - posX), 2);
        double y2 = Math.pow((yCordinate - posY), 2);
        double distance = Math.sqrt((y2 + x2));
        boolean Inrange = false;

         if(distance < range) {   //Range är en instansvariabel inget värde ännu men tror principen är rätt

             Inrange = true;
         }
         return Inrange;
    }

    public abstract void drawTower(Graphics2D g);

}
