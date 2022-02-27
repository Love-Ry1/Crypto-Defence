package models;


import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;

public class BasicMap implements Serializable {

    private final String MAPNAME = "map1.txt";
    public enum direction{NORTH, EAST, SOUTH, WEST}
    private direction [][] pathArray = new direction[width][height];
    private static final int width = 10;     // width in blocks (temp value)
    private static final int height = 10;    // height in blocks (temp value)
    private int endRow;
    private int endColumn;
    private int[][] blockTypeArray = new int[height][width];

    Block[][] blockArray = new Block[width][height];

    public BasicMap() {
        loadMap();

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
                    (i == 0 && currentDirection == direction.NORTH) || (j == 0 && currentDirection == direction.WEST || currentDirection == null)){
                endRow = i;
                endColumn = j;
                loop = false;
            }
        }
    }

    public void loadMap(){
        InputStream is;
        BufferedReader bf;
        try {
            is = getClass().getClassLoader().getResourceAsStream(MAPNAME);
            bf = new BufferedReader(new InputStreamReader(is));
            for (int j = 0; j < height; j++){
                String line = bf.readLine();
                int index = 0;
                for(int k = 0; k < width; k++) {
                    char currentChar = 'a';
                    while(!Character.isDigit(currentChar)) {
                        currentChar = line.charAt(index);
                        if (Character.isDigit(currentChar)) {
                            int number = Character.getNumericValue(currentChar);
                            blockTypeArray[j][k] = number;
                        }
                        index++;
                        if(index > 100){
                            break;
                        }
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
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

    public int getEndRow(){
        return endRow;
    }

    public int getEndColumn(){
        return endColumn;
    }

    public direction nextDirection(int posX, int posY){
        int row = posY / 80;
        int column = posX / 80;
        return pathArray[row][column];
    }
}
