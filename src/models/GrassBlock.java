package models;

import javax.swing.*;

public class GrassBlock extends Block {
    /**
     * This method is for drawing blocks
     * @param posX
     * @param posY
     */
    protected GrassBlock(int posX, int posY) {
        super(posX, posY);
        setName("grass");
    }
}
