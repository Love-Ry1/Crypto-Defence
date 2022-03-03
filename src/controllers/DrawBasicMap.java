package controllers;

import models.BasicMap;
import models.Block;

import java.awt.*;

/**
 * This class will take a map and draw it
 */
public class DrawBasicMap {
    private Block[][] blockArray;
    private BasicMap basicMap;

    public DrawBasicMap(){
        this.basicMap = new BasicMap();
    }

    public void setBasicMap(BasicMap basicMap){
        this.basicMap = basicMap;
    }

    public BasicMap getBasicMap(){
        return basicMap;
    }
    /**
     * This method draws a map
     * @param g
     */
    public void draw(Graphics2D g){
        blockArray = basicMap.getBlockArray();
        int width = BasicMap.getWidth();
        int height = BasicMap.getHeight();

        for (int i = 0; i < width; i++) {        // loops through the block array
            for (int j = 0; j < height; j++) {
                Block currentBlock = this.blockArray[i][j];
                if (currentBlock != null) {
                    DrawBlock drawBlock = new DrawBlock(currentBlock);
                    drawBlock.draw(g);
                    if(i == basicMap.getEndRow() && j == basicMap.getEndColumn()){
                        for (int k = 0; k < 80; k++){
                            for (int l = 0; l < 80; l++){
                                if(k % 2 == 0 && l % 2 == 1){
                                    g.setColor(Color.BLACK);
                                    g.fillRect(currentBlock.getPosX() + k, currentBlock.getPosY() + l, 10, 10);
                                }else{
                                    g.setColor(Color.WHITE);
                                    g.fillRect(currentBlock.getPosX() + k, currentBlock.getPosY() + l, 10, 10);
                                }
                            }
                        }


                    }
                }
            }
        }
    }

}