import javax.swing.*;
import java.awt.*;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;

public class WaterBlock extends Block {
    private Color color = Color.blue;      // move color to abstract class?
    Image water;

    protected WaterBlock(int posX, int posY) {
        super(posX, posY);
        water = new ImageIcon("img\\water.png").getImage(); //
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public void drawBlock(Graphics g) {

        GameScreen game = new GameScreen();
        Graphics2D graphics2D = (Graphics2D) g;  // for 2D graphic
        graphics2D.drawImage(water,this.getPosX(),this.getPosY(),null); // for sitting the picture to the right position

        g.setColor(this.getColor());
        //g.fillRect(this.getPosX(), this.getPosY(), getWidth(), getHeight());

    }

}

