import javax.swing.*;
import java.awt.*;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;

public class WaterBlock extends Block {
    private Color color = Color.blue;      // move color to abstract class?

    protected WaterBlock(int posX, int posY) {
        super(posX, posY);
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public void drawBlock(Graphics g) {
        g.setColor(this.getColor());
        g.fillRect(this.getPosX(), this.getPosY(), getWidth(), getHeight());
    }

}

