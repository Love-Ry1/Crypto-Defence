import java.awt.*;

public abstract class Block {
    private int posX;
    private int posY;
    private static final int width = 80;     // width is 50 for all blocks (temp value)
    private static final int height = 80;    // height is 50 for all blocks (temp value)

    protected Block(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }

    public int getPosX(){
        return posX;
    }

    public void setPosX(int posX){
        this.posX = posX;
    }

    public int getPosY(){
        return posY;
    }

    public void setPosY(int posY){
        this.posY = posY;
    }

    public static int getWidth(){
        return width;
    }

    public static int getHeight(){
        return height;
    }

    public abstract Color getColor();   // returns the color of a block (maybe change to color to image later?)

    public abstract void drawBlock(Graphics g);   // draws the block
}
