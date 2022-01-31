import javax.swing.*;

public class GameFrame extends JFrame {

    public GameFrame(){
        // Frame settings
        this.setSize(600, 600);
        this.setTitle("Crypto Defence");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);       // makes the frame appear around the center of the monitor

        // Adding the screen
        GameScreen gameScreen = new GameScreen();
        this.add(gameScreen);

        this.setVisible(true);
    }

    public static void main(String[] args) {    // only for testing delete after
        GameFrame gameframe = new GameFrame();

    }



}
