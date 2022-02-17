package controllers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;


public class Buttons extends JPanel { // Prob not gonna use
    JButton addBasic   = new JButton();


    public Buttons() {
        this.add(addBasic);
    }

    public void addActionListener(ActionListener thisListener) {
        addBasic.addActionListener(thisListener);
    }

    public void mouseEnter(MouseEvent evt){
    }

    public void mouseExited(MouseEvent evt){
        addBasic.setBackground(UIManager.getColor("Control"));
    }
}
