package models;

/**
 * This BasicBullet class that represents a basic bullet, which is a type of bullet
 */
public class BasicBullet extends Bullets {
    /**
     * This method is for drawing the basic bullet.
     * @param posX the X coordinate of the bullet
     * @param posY the Y coordinate of the bullet
     * @param direction the direction of the bullet that is being shot
     * @param enemy the enemy that the bullet targets when being shot
     */
    protected BasicBullet(int posX, int posY, Bullets.Direction direction, Enemy enemy) {
        super(posX, posY, direction, enemy);
        setSpeed(2);
    }

}
