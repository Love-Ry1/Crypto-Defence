package models;

import javax.swing.*;

public class BasicBullet extends Bullets {
    /**
     * This method is for drawing the basic bullet.
     * @param posX
     * @param posY
     * @param direction
     * @param enemy
     */
    protected BasicBullet(int posX, int posY, Bullets.Direction direction, Enemy enemy) {
        super(posX, posY, direction, enemy);
        setSpeed(2);
        setBulletImage(new ImageIcon(getClass().getResource("/basicbullet.png"), "bascicBullet").getImage());
    }

}
