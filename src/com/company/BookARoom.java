package com.company;

import javax.swing.*;
import java.awt.*;

public class BookARoom extends JFrame {

    public BookARoom(){
        setLayout(null);
        this.setPreferredSize(new Dimension(450,240)); //size of window
        JTextField dayTextField = new JTextField();
        JTextField monthTextField = new JTextField();
        JTextField yearTextField = new JTextField();
        pack();


    }
}
