import javax.swing.*;
import java.awt.*;

public class StoneBlock extends Block {

    protected StoneBlock(int posX, int posY) {
        super(posX, posY);
        this.setBlockImage(new ImageIcon(getClass().getResource("stoneblock.png"), "hej").getImage());
    }

    @Override
    public void drawBlock(Graphics2D g) {
        g.drawImage(this.getBlockImage(), this.getPosX(), this.getPosY(),null);
    }


    //public Image getBlockImage(){
    //    return new ImageIcon(getClass().getResource("stoneblock.png"), "hej").getImage();
    //}


}
