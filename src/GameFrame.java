import javax.swing.*;

public class GameFrame extends JFrame {
    public GameFrame(){
        this.setSize(600, 600);
        this.setTitle("Crypto Defence");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    public static void main(String[] args) {    // only for testing delete after
        new GameFrame();
    }
}
