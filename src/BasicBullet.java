import javax.swing.*;

public class BasicBullet extends Bullets {

    protected BasicBullet(int posX, int posY, int direction) {
        super(posX, posY, direction);
        setSpeed(2);
        setBulletImage(new ImageIcon(getClass().getResource("basicbullet.png"), "bascicBullet").getImage());
    }

}
