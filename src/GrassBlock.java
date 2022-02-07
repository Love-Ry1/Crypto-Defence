import javax.swing.*;
import java.awt.*;

public class GrassBlock extends Block {

    protected GrassBlock(int posX, int posY) {
        super(posX, posY);
        this.setBlockImage(new ImageIcon(getClass().getResource("grass.png"), "GrassBlock").getImage());
    }
}
