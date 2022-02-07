import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;


public class Buttons extends JPanel { // Prob not gonna use
    JButton addBasic   = new JButton();


    public Buttons() {
        this.add(addBasic);
    }

    public void addActionListener(ActionListener thisListener) {
        addBasic.addActionListener(thisListener);
    }
}
