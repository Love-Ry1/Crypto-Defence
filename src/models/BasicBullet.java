package models;

/**
 * This BasicBullet class that represents a basic bullet, which is a type of bullet
 */
public class BasicBullet extends Bullets {
    /**
     * This method is for drawing the basic bullet.
     * @param posX the X coordinate of the bullet
     * @param posY the Y coordinate of the bullet
     * @param enemy the enemy that the bullet targets when being shot
     */
    protected BasicBullet(int posX, int posY, Enemy enemy) {
        super(posX, posY, enemy);
        setSpeed(2);
    }

}
