package models;

import javax.swing.*;

public class BasicBullet extends Bullets {

    protected BasicBullet(int posX, int posY, Bullets.Direction direction) {
        super(posX, posY, direction);
        setSpeed(2);
        setBulletImage(new ImageIcon(getClass().getResource("basicbullet.png"), "bascicBullet").getImage());
    }

}
