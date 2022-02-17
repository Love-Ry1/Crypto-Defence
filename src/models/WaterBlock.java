package models;

import models.Block;

import javax.swing.*;

public class WaterBlock extends Block {

    protected WaterBlock(int posX, int posY) {
        super(posX, posY);
        this.setBlockImage(new ImageIcon(getClass().getResource("/water.png"), "models.WaterBlock").getImage());
    }

}

