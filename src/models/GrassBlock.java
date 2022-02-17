package models;

import javax.swing.*;

public class GrassBlock extends Block {

    protected GrassBlock(int posX, int posY) {
        super(posX, posY);
        this.setBlockImage(new ImageIcon(getClass().getResource("/grass.png"), "models.GrassBlock").getImage());
    }
}
