package controllers;

import models.Block;

import javax.swing.*;
import java.awt.*;

/**
 * This class will draw a block into the BasicMap
 */
public class DrawBlock {
    private final Block block;
    private Image currentImage = null;
    private final Image grassImage = new ImageIcon(getClass().getResource("/grass.png"), "GrassBlock").getImage();
    private final Image waterImage = new ImageIcon(getClass().getResource("/water.png"), "WaterBlock").getImage();
    private final Image stoneImage = new ImageIcon(getClass().getResource("/stone.png"), "StoneBlock").getImage();

    /**
     * ?????????????????????????
     * @param block
     */
    public DrawBlock(Block block){
        this.block = block;
        chooseImage();
    }

    /**
     * This method chooses the correct image for the block based on the name of the block
     */
    public void chooseImage(){
        String name = block.getName();
        switch (name){
            case "grass":
                currentImage = grassImage;
                break;

            case "water":
                currentImage = waterImage;
                break;

            case "stone":
                currentImage = stoneImage;
                break;

            default:
                currentImage = null;    // maybe add a white picture here to avoid errors?
                System.out.println("No image was found");
        }
    }

    /**
     * This method draws the correct block image in the designated x- and y-coordinates
     * @param g
     */
    public void draw(Graphics2D g){
        g.drawImage(currentImage, block.getPosX(), block.getPosY(), null);
    }

}
