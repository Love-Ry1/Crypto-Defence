package models;

/**
 * This class is for creating water block
 *  @author Love Rymo
 *  @version 2022-03-06
 */
public class WaterBlock extends Block {

    protected WaterBlock(int posX, int posY) {
        super(posX, posY);
        setName("water");
    }

}
