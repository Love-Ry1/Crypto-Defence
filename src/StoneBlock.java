import java.awt.*;

public class StoneBlock extends Block {
    Color color = Color.lightGray;

    protected StoneBlock(int posX, int posY) {
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
    }
}
