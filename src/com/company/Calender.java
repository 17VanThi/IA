package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calender extends JFrame implements ActionListener {
    int month;
    int year;
    public Calender(){
        int x = 0;
        int y = 0;
        int w = 50;
        int h = 50;

        for(int i = 0; i < 7; i++ ){
            for(int j = 0; j < 6; j++){
                JButton button = new JButton(Integer.toString(i*j));
                button.setBounds(x,y,w,h);
                button.addActionListener(this);
                getContentPane().add(button);
                x = x+w;
            }
        }

        pack();
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
