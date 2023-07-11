package com.company;


import javax.swing.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        JFrame frame = new JFrame("Room Booker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUI myGui = new GUI(400,300);
        frame.add(myGui);
        frame.pack();
        frame.setVisible(true);

        new Calender(1,30);
        menu.start();

    }
}
