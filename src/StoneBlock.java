import javax.swing.*;
import java.awt.*;

public class StoneBlock extends Block {
    Color color = Color.black;
    Image stoneBlock;
    protected StoneBlock(int posX, int posY) {
        super(posX, posY);
        stoneBlock = new ImageIcon("img\\floor.png").getImage(); // har ändrats till adress
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public void drawBlock(Graphics g) {
        GameScreen game = new GameScreen();
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.drawImage(stoneBlock,this.getPosX(),this.getPosY(),null);

        g.setColor(this.getColor());
        //g.fillRect(this.getPosX(), this.getPosY(), getWidth(), getHeight());

    }


}
