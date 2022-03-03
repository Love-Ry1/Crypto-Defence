package models;

import javax.swing.*;

/**
 * This BasicBullet class that represents a basic bullet, which is a type of bullet
 */
public class BasicBullet extends Bullets {
    /**
     * This method is for drawing the basic bullet.
     * @param posX the X position of the bullet
     * @param posY the Y position of the bullet
     * @param direction the direction of the bullet
     * @param enemy the enemy that the bullet targets
     */
    protected BasicBullet(int posX, int posY, Bullets.Direction direction, Enemy enemy) {
        super(posX, posY, direction, enemy);
        setSpeed(2);
    }

}
