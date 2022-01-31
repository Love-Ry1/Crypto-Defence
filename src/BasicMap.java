import java.awt.*;
import java.awt.image.BufferedImage;

public class BasicMap {
    private int width = 10;     // width in blocks (temp value)
    private int height = 10;    // height in blocks (temp value)
    private int[][] blockTypeArray = {
            {1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 1, 1, 1},
            {0, 0, 1, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 1, 1, 1, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };

    Block[][] blockArray = new Block[width][height];

    public BasicMap(){
        for(int i = 0; i < this.height; i++){        // loops through the block array
            for(int j = 0; j < this.width; j++){
                if (blockTypeArray[i][j] == 0) {
                    blockArray[i][j] = new GrassBlock(j * Block.getWidth(), i * Block.getHeight());
                }
                else if(blockTypeArray[i][j] == 1){
                    blockArray[i][j] = new StoneBlock(j * Block.getWidth(), i * Block.getHeight());
                }
            }
        }
    }

    public void drawMap(Graphics g){
        g.setColor(Color.black);

        for(int i = 0; i < this.width; i++){        // loops through the block array
            for(int j = 0; j < this.height; j++){
                Block currentBlock = this.blockArray[i][j];
                if (currentBlock != null) {
                    currentBlock.drawBlock(g);
                }
            }
        }
    }

}
