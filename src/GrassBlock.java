import java.awt.*;

public class GrassBlock extends Block {
    private Color color = Color.green;      // move color to abstract class?

    protected GrassBlock(int posX, int posY) {
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
