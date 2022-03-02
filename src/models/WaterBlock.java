package models;

import models.Block;

import javax.swing.*;

/**
 * This class is for creating water block
 */
public class WaterBlock extends Block {

    protected WaterBlock(int posX, int posY) {
        super(posX, posY);
        setName("water");
    }

}

