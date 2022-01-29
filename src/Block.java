public abstract class Block {
    private int posX, posY, width, height;

    protected Block(int posX, int posY, int width, int height){
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
    }

    public int getPosX(){
        return posX;
    }

    public void setPosX(int posX){
        this.posX = posX;
    }

    public int getPosY(){
        return posY;
    }

    public void setPosY(int posY){
        this.posY = posY;
    }

    public int getWidth(){
        return this.width;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public int getHeight(){
        return height;
    }

    public void setHeight(int height){
        this.height = height;
    }
}
