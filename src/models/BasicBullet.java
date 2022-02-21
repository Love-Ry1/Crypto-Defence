package models;

import javax.swing.*;

public class BasicBullet extends Bullets {

    protected BasicBullet(int posX, int posY, Bullets.Direction direction, Enemy enemy) {
        super(posX, posY, direction, enemy);
        setSpeed(2);
        setBulletImage(new ImageIcon(getClass().getResource("/basicbullet.png"), "bascicBullet").getImage());
    }

}
