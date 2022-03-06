package models;

import java.io.Serializable;

/**
 * This class represents a block
 */
public abstract class Block implements Serializable {
    private int posX;
    private int posY;
    private static final int width = 80;     // width is 50 for all blocks (temp value)
    private static final int height = 80;    // height is 50 for all blocks (temp value)
    private String name;

    /**
     * Constructor for initiate and create the block
     * @param posX the x-coordinate
     * @param posY the y-coordinate
     */
    protected Block(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    /**
     * This method return x-coordinate of the block
     * @return the x-coordinate of the block
     */
    public int getPosX() {
        return posX;
    }

    /**
     * This method return y-coordinate of the block
     * @return the y-coordinate of the block
     */
    public int getPosY() {
        return posY;
    }

    /**
     * This method return width of the block
     * @return the width of the block
     */
    public static int getWidth() {
        return width;
    }

    /**
     * This method returns height of the block
     * @return the height of the block
     */
    public static int getHeight() {
        return height;
    }

    /**
     * This method returns the name of the block
     * @return the name of the block
     */
    public String getName(){
        return name;
    }

    /**
     * This method sets the name of the block
     * @param name the name of the block
     */
    public void setName(String name){
        this.name = name;
    }

}
