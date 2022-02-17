package models;


import java.awt.*;

public class BasicMap {

    public enum direction{NORTH, EAST, SOUTH, WEST}
    private direction [][] pathArray = new direction[width][height];
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

        int i = 0;
        int j = 0;
        direction currentDirection = null;
        boolean loop = true;
        while(loop){
            if (blockTypeArray[i][j] == 1 && blockTypeArray[i][j + 1] == 1 && currentDirection != direction.WEST) {
                currentDirection = direction.EAST;
                pathArray[i][j] = currentDirection;
                j += 1;
            } else if (blockTypeArray[i][j] ==  1 && blockTypeArray[i + 1][j] == 1 && currentDirection != direction.NORTH) {
                currentDirection = direction.SOUTH;
                pathArray[i][j] = currentDirection;
                i += 1;
            } else if (blockTypeArray[i][j] == 1 && blockTypeArray[i][j - 1] == 1 && currentDirection != direction.EAST) {
                currentDirection = direction.WEST;
                pathArray[i][j] = currentDirection;
                j -= 1;
            } else if (blockTypeArray[i][j] == 1 && blockTypeArray[i - 1][j] == 1 && currentDirection != direction.SOUTH) {
                currentDirection = direction.NORTH;
                pathArray[i][j] = currentDirection;
                i -= 1;
            } else {
                currentDirection = null;
                pathArray[i][j] = currentDirection;
                if (j < width - 1){
                    j++;
                } else if(i < height - 1){
                    j = 0;
                    i++;
                }
            }

            if ((i == height - 1 && currentDirection == direction.SOUTH) || (j == width - 1 && currentDirection == direction.EAST) ||
                    (i == 0 && currentDirection == direction.NORTH) || (j == 0 && currentDirection == direction.WEST)){
                loop = false;
            }
        }
    }

    public static int getWidth(){
        return width;
    }

    public static int getHeight(){
        return height;
    }

    public Block[][] getBlockArray(){
        return blockArray;
    }

    public direction adjacent(int posX, int posY){
        int row = posX / 80;
        int column = posY / 80;
        return pathArray[row][column];
    }
}
