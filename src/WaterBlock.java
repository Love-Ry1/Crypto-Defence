import javax.swing.*;
import java.awt.*;

public class WaterBlock extends Block {

    protected WaterBlock(int posX, int posY) {
        super(posX, posY);
        this.setBlockImage(new ImageIcon(getClass().getResource("water.png"), "WaterBlock").getImage());
    }

    @Override
    public void drawBlock(Graphics2D g) {
        g.drawImage(this.getBlockImage(), this.getPosX(), this.getPosY(),null); // for sitting the picture to the right position
    }

}

