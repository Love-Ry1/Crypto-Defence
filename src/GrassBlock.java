import javax.swing.*;
import java.awt.*;

public class GrassBlock extends Block {

    protected GrassBlock(int posX, int posY) {
        super(posX, posY);
        this.setBlockImage(new ImageIcon("img\\grass.png").getImage());
    }

    @Override
    public void drawBlock(Graphics2D g) {
        g.drawImage(this.getBlockImage(), this.getPosX(), this.getPosY(),null);
    }

}
