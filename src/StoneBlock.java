import javax.swing.*;
import java.awt.*;

public class StoneBlock extends Block {

    protected StoneBlock(int posX, int posY) {
        super(posX, posY);
        this.setBlockImage(new ImageIcon(getClass().getResource("stone.png"), "StoneBlock").getImage());   // maybe move to a method
    }

    //public Image getBlockImage(){
    //    return new ImageIcon(getClass().getResource("stoneblock.png"), "hej").getImage();
    //}
}
