package models;

/**
 * This class is for creating the Grass block
 *  @author Basem ALi
 *  @version 2022-03-06
 */
public class GrassBlock extends Block {
    /**
     * This method is for drawing blocks
     * @param posX the x-coordinate
     * @param posY the y-coordinate
     */
    protected GrassBlock(int posX, int posY) {
        super(posX, posY);
        setName("grass");
    }
}
