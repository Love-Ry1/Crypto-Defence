import java.awt.*;

public abstract class Block {
    private int posX;
    private int posY;
    private int width = 50;     // width is 50 for all blocks (temp value)
    private int height = 50;    // height is 50 for all blocks (temp value)

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

    public int getWidth(){
        return this.width;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public int getHeight(){
        return height;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public abstract Color getColor();   // returns the color of a block (maybe change to color to image later?)
}
