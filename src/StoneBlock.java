import javax.swing.*;
import java.awt.*;

public class StoneBlock extends Block {

    protected StoneBlock(int posX, int posY) {
        super(posX, posY);
        this.setBlockImage(new ImageIcon("img\\floor.png").getImage());
    }

    @Override
    public void drawBlock(Graphics2D g) {
        g.drawImage(this.getBlockImage(), this.getPosX(), this.getPosY(),null);
    }


}
