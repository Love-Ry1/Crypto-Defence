package models;

import javax.swing.*;

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
