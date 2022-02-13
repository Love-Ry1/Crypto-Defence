import java.awt.*;

public class DrawBlock {
    private final Block block;

    public DrawBlock(Block block){
        this.block = block;
    }

    public void draw(Graphics2D g){
        g.drawImage(block.getBlockImage(), block.getPosX(), block.getPosY(), null);
    }

}
