import java.awt.*;

public class BasicMap {
    BottomBarFrame bottomBarFrame = new BottomBarFrame(0,800,800,200 ); // create the bottom bar


    private static final int width = 10;     // width in blocks (temp value)
    private static final int height = 10;    // height in blocks (temp value)
    private static final int[][] blockTypeArray = {
            {1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 1, 2, 2, 0, 0, 0},
            {0, 0, 1, 2, 2, 2, 2, 1, 1, 1},
            {0, 0, 1, 2, 2, 2, 2, 1, 0, 0},
            {0, 0, 1, 2, 2, 2, 2, 1, 0, 0},
            {0, 0, 1, 1, 1, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };

    Block[][] blockArray = new Block[width][height];

    public BasicMap() {
        for (int i = 0; i < width; i++) {        // loops through the block array
            for (int j = 0; j < height; j++) {
                if (blockTypeArray[i][j] == 0) {
                    blockArray[i][j] = new GrassBlock(j * Block.getWidth(), i * Block.getHeight());
                } else if (blockTypeArray[i][j] == 1) {
                    blockArray[i][j] = new StoneBlock(j * Block.getWidth(), i * Block.getHeight());
                } else if (blockTypeArray[i][j] == 2) {
                    blockArray[i][j] = new WaterBlock(j * Block.getWidth(), i * Block.getHeight());
                }
            }
        }
    }

    public void drawMap(Graphics2D g) {
        bottomBarFrame.draw(g); //adding the bottom bar
        //g.setColor(Color.black);
        for (int i = 0; i < width; i++) {        // loops through the block array
            for (int j = 0; j < height; j++) {
                Block currentBlock = this.blockArray[i][j];
                if (currentBlock != null) {
                    currentBlock.drawBlock(g);
                }
            }
        }
    }

    public static int BlocktypeArrays(){
        return blockTypeArray.length;
    }

    public static int getWidth(){
        return width;
    }

    public static int getHeight(){
        return height;
    }
}
