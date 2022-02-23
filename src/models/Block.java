package models;

import java.awt.*;

public abstract class Block {
    private int posX;
    private int posY;
    private Image blockImage;
    private static final int width = 80;     // width is 50 for all blocks (temp value)
    private static final int height = 80;    // height is 50 for all blocks (temp value)

    /**
     * Constructor for initiate and create the block
     * @param posX
     * @param posY
     */
    protected Block(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    /**
     * This method return x position of the block
     * @return
     */
    public int getPosX() {
        return posX;
    }

    /**
     * This method return y position of the block
     * @return
     */
    public int getPosY() {
        return posY;
    }

    /**
     * This method return width of the block
     * @return
     */
    public static int getWidth() {
        return width;
    }

    /**
     * This method returns height of the block
     * @return
     */
    public static int getHeight() {
        return height;
    }

    /**
     * This method is for att assign image to the block
     * @param image
     */
    public void setBlockImage(Image image) {
        this.blockImage = image;
    }

    /**
     * This method returns image of the block.
     * @return
     */
    public Image getBlockImage() {
        return this.blockImage;
    }

}
