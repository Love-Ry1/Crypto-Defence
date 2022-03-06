package models;

import javax.swing.*;

/**
 * This class is for creating the Grass block
 */
public class GrassBlock extends Block {
    /**
     * This method is for drawing blocks
     * @param posX the x-coordinate
     * @param posY the y-coordinate
     */
    protected GrassBlock(int posX, int posY) {
        super(posX, posY);
        setName("grass");
    }
}
