package com.company;
import javax.swing.*;
public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Room Booker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainMenuGUI myGui = new MainMenuGUI(400,300);
        frame.add(myGui);
        frame.pack();
        frame.setVisible(true);

    }
}
