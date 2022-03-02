package models;

import javax.swing.*;

/**
 * This class is for creating the stone block
 */
public class StoneBlock extends Block {
    /**
     * This method draws a stone block on the map
     * @param posX
     * @param posY
     */
    protected StoneBlock(int posX, int posY) {
        super(posX, posY);
        setName("stone");
    }

}
