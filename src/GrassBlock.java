import javax.swing.*;
import java.awt.*;

public class GrassBlock extends Block {
    private Color color = Color.green;      // move color to abstract class?
    Image gras;

    protected GrassBlock(int posX, int posY) {
        super(posX, posY);
        gras = new ImageIcon("img\\grass.png").getImage(); //
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public void drawBlock(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.drawImage(gras,this.getPosX(),this.getPosY(),null);


        g.setColor(this.getColor());
        //g.fillRect(this.getPosX(), this.getPosY(), getWidth(), getHeight());
    }

}
