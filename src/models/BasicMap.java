package models;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URL;

/**
 * This class creates a game map
 *  @author Love Rymo
 *  @version 2022-03-06
 */
public class BasicMap implements Serializable {

    private String MAPNAME = "map1.txt";
    public enum direction{NORTH, EAST, SOUTH, WEST}
    private direction [][] pathArray = new direction[width][height];
    private static final int width = 10;     // width in blocks (temp value)
    private static final int height = 10;    // height in blocks (temp value)
    private int endRow;
    private int endColumn;
    private int[][] blockTypeArray = new int[height][width];
    private Block[][] blockArray = new Block[width][height];

    /**
     * This method is for changing the map, but player need to change it at the beginning of the game
     */
    public void changeMap(){
        switch (MAPNAME){
            case "map1.txt":
                this.MAPNAME = "map2.txt";
                break;

            case "map2.txt":
                this.MAPNAME = "map3.txt";
                break;

            default:
                this.MAPNAME = "map1.txt";
        }
        System.out.println(MAPNAME);
        loadMap();
        mapInit();
    }

    /**
     * this method is for initialising the map
     */
    public void mapInit(){
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

    /**
     * this method loads and initials the map
     */
    public BasicMap() {
        loadMap();
        mapInit();
    }

    /**
     * This method reads a map from a text file which is configurable
     */
    public void loadMap(){
        URL url;
        BufferedReader bf;
        try {
            String urlString = "http://142.93.106.21:5000/d3/" + MAPNAME;
            url = new URL(urlString);
            bf = new BufferedReader(new InputStreamReader(url.openStream()));
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
                        if(index > 400){
                            break;
                        }
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * This method returns the width of the map
     * @return the width of the map
     */
    public static int getWidth(){
        return width;
    }

    /**
     * This method returns the height of the map
     * @return the height of the map
     */
    public static int getHeight(){
        return height;
    }

    /**
     * This method returns a block array
     * @return the array for Block
     */
    public Block[][] getBlockArray(){
        return blockArray;
    }

    /**
     * This method returns the integer value for the endRow
     * @return the integer value of the row for the last block
     */
    public int getEndRow(){
        return endRow;
    }

    /**
     * This method returns the integer value for the endColumn
     * @return the integer value of the column for the last block
     */
    public int getEndColumn(){
        return endColumn;
    }

    /**
     * This method returns the direction for a position on the map on where it should go to be able to arrive at the finish line
     * @param posX the x-coordinate
     * @param posY the y-coordinate
     * @return the direction
     */
    public direction nextDirection(int posX, int posY){
        int row = posY / 80;
        int column = posX / 80;
        return pathArray[row][column];
    }

}
