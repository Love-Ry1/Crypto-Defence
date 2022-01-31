import java.awt.*;

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
        g.drawRect(this.getPosX(), this.getPosY(), getWidth(), getHeight());
        g.fillRect(this.getPosX(), this.getPosY(), getWidth(), getHeight());
    }

}

