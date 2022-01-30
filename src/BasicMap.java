import java.awt.*;

public class BasicMap {
    String x;
    public BasicMap(){}

    public void drawRoom(Graphics g){
        g.setColor(Color.black);
        g.drawRect(50, 50, 50, 50);
    }
}
