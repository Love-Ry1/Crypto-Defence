package models;

/**
 * This class is for creating the stone block
 *  @author Fadi Abunaj
 *  @version 2022-03-06
 */
public class StoneBlock extends Block {
    /**
     * This method draws a stone block on the map
     * @param posX the x-coordinate
     * @param posY the y-coordinate
     */
    protected StoneBlock(int posX, int posY) {
        super(posX, posY);
        setName("stone");
    }

}
