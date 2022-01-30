import java.awt.*;

public class GrassBlock extends Block {
    private Color color = Color.green;

    protected GrassBlock(int posX, int posY) {
        super(posX, posY);
    }

    @Override
    public Color getColor() {
        return this.color;
    }

}
