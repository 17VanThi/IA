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

        int num = 1; // button label

        this.setPreferredSize(new Dimension(370,350)); //size of window

        for(int i = 0; i < 5; i++ ){ //column
            x = 0 ;
            for(int j = 0; j < 7; j++){ //row
                JButton button = new JButton(Integer.toString(num));
                button.setBounds(x,y,w,h);
                button.addActionListener(this);
                getContentPane().add(button);
                x = x+w;
                num++;
            }
            y = y + 50;
        }
        pack();
        setVisible(true);
    }


    @Override
    //when any button is clicked
    public void actionPerformed(ActionEvent e) {

    }
}
