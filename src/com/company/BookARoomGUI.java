package com.company;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class BookARoomGUI extends JFrame implements ActionListener {

    JTextField dayTextField;
    JTextField monthTextField;
    JTextField yearTextField;
    JTextField userTextField;
    JTextField roomTextField;

    public BookARoomGUI(){
        setLayout(null);
        this.setPreferredSize(new Dimension(500,240)); //size of window


        JTextField userTextField = new JTextField();
        userTextField.setBounds(90,30,100,30);

        JLabel userTextLabel = new JLabel("Input Name:");
        userTextLabel.setBounds(90,0,100,30);

        add(userTextField);
        add(userTextLabel);





        //todo : select from free rooms
        //check all the bookings with the same date and remove rooms that are occupied on that date
        JTextField roomTextField = new JTextField();
        roomTextField.setBounds(200,30,100,30);

        JLabel roomTextLabel = new JLabel("Input Room:");
        roomTextLabel.setBounds(200,0,100,30);

        add(roomTextField);
        add(roomTextLabel);


        dayTextField = new JTextField();
        dayTextField.setBounds(90,90,100,30);

        JLabel dayLabel = new JLabel("Input Day:");
        dayLabel.setBounds(90,60,100,30);



        monthTextField = new JTextField();
        monthTextField.setBounds(200,90,100,30);

        JLabel monthLabel = new JLabel("Input Month:");
        monthLabel.setBounds(200,60,100,30);


        yearTextField = new JTextField();
        yearTextField.setBounds(310,90,100,30);

        JLabel yearLabel = new JLabel("Input year:");
        yearLabel.setBounds(310,60,100,30);

        add(dayLabel);
        add(dayTextField);

        add(monthLabel);
        add(monthTextField);

        add(yearLabel);
        add(yearTextField);


        JButton searchButton = new JButton("Search");
        searchButton.setBounds(0,0,40,40);
        add(searchButton);
        searchButton.addActionListener(this);

        pack();


    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Search")) {

            ArrayList<Booking> bookings;

            BookingList bookingList = new BookingList("data");
            bookingList.getBookingsFromData("data", bookings);

            String day = dayTextField.getText();
            String month = monthTextField.getText();
            String year = yearTextField.getText();
            String person = userTextField.getText();
            String room = roomTextField.getText();

            boolean exDay = false;
            String extendedDay = null;
            if (Integer.valueOf(day) < 10){
                String dayStr = day;
                extendedDay = "0"+ dayStr;
                exDay = true;
            }




            //check in booking list

            Booking booking = new Booking()
            if ()

        }

    }
}
