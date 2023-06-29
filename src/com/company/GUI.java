package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// GUI skeleton,

public class GUI extends JPanel {
    public GUI(int width, int height){
        System.out.println("GUI is working");
        this.setPreferredSize(new Dimension(width,height));
        setLayout(null);

        JButton viewButton = new JButton("View");
        viewButton.setBounds(10,100,150,60);
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("");
            }
        });
        add(viewButton);
    }



    public void addButton(String text,int x , int y, int width, int height){
        JButton newButton = new JButton(text);
        newButton.setBounds(x,y,width,height);
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(text);
            }
        });
        add(newButton);
    }







}
