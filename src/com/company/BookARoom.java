package com.company;

import javax.swing.*;
import java.awt.*;

public class BookARoom extends JFrame {

    public BookARoom(){
        setLayout(null);
        this.setPreferredSize(new Dimension(500,240)); //size of window


        JTextField userTextField = new JTextField();
        userTextField.setBounds(90,30,100,30);

        JLabel userTextLabel = new JLabel("Input Name:");
        userTextLabel.setBounds(90,0,100,30);

        add(userTextField);
        add(userTextLabel);

        JTextField roomTextField = new JTextField();
        roomTextField.setBounds(200,30,100,30);

        JLabel roomTextLabel = new JLabel("Input Room:");
        roomTextLabel.setBounds(200,0,100,30);

        add(roomTextField);
        add(roomTextLabel);

        JTextField dayTextField = new JTextField();
        dayTextField.setBounds(90,90,100,30);

        JLabel dayLabel = new JLabel("Input Day:");
        dayLabel.setBounds(90,60,100,30);


        JTextField monthTextField = new JTextField();
        monthTextField.setBounds(200,90,100,30);

        JLabel monthLabel = new JLabel("Input Month:");
        monthLabel.setBounds(200,60,100,30);


        JTextField yearTextField = new JTextField();
        yearTextField.setBounds(310,90,100,30);

        JLabel yearLabel = new JLabel("Input year:");
        yearLabel.setBounds(310,60,100,30);

        add(dayLabel);
        add(dayTextField);

        add(monthLabel);
        add(monthTextField);

        add(yearLabel);
        add(yearTextField);

        pack();



    }
}
