import javax.swing.*;
import java.awt.*;

public class BasicTower extends Tower{

    protected BasicTower(int posX, int posY){
        super(posX, posY);
        setDamage(5);
        setRange(50);
        setCost(25);
        setAttackSpeed(2);
        setTowerImage(new ImageIcon(getClass().getResource("basictower.png"), "BasicTower").getImage());
        setTowerName(TowerName.BASIC);
    }

}
