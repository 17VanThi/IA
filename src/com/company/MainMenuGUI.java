package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// GUI skeleton,

public class MainMenuGUI extends JPanel {
    public MainMenuGUI(int width, int height){
        System.out.println("GUI is working");
        this.setPreferredSize(new Dimension(width,height));
        setLayout(null);


        BookARoomGUI bookaroomGUI = new BookARoomGUI();
        bookaroomGUI.setVisible(false);

        JButton bookARoom = new JButton("Book A Room");
        bookARoom.setBounds(10,10,width-20,(height/2 )-10);
        bookARoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // when clicked, display another gui that has input fields for day month, year, room and name
                bookaroomGUI.setVisible(true);
            }
        });
        add(bookARoom);

        Calender cal = new Calender();
        cal.setVisible(false);

        JButton viewButton = new JButton("View");
        viewButton.setBounds(10,(height/2 )+10,width-20,(height/2 )-20);
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // when view button is clicked, show sorting options and a window that displays the bookings
                // in the sorted format

                cal.setVisible(true);

            }
        });
        add(viewButton);
    }


    //add a button that outputs its label when clicked
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
