import java.awt.*;

public class DrawBasicMap {
    private Block[][] blockArray;
    BasicMap basicMap;

    public DrawBasicMap(){
        basicMap = new BasicMap();
    }

    public void draw(Graphics2D g){
        blockArray = basicMap.getBlockArray();
        int width = BasicMap.getWidth();
        int height = BasicMap.getHeight();

        for (int i = 0; i < width; i++) {        // loops through the block array
            for (int j = 0; j < height; j++) {
                Block currentBlock = this.blockArray[i][j];
                if (currentBlock != null) {
                    currentBlock.drawBlock(g);
                }
            }
        }
    }

}
