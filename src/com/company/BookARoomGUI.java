package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class BookARoomGUI extends JFrame implements ActionListener {

    JTextField dayTextField;
    JTextField monthTextField;
    JTextField yearTextField;
    JTextField userTextField;
    JTextField roomTextField;
    JLabel errorLabel;
    BufferedImage emoji = null;



    public BookARoomGUI(){
        setLayout(null);
        this.setPreferredSize(new Dimension(500,240)); //size of window
        this.setResizable(false);

        //try to add an image
        try {
            emoji = ImageIO.read(getClass().getResource("/Resources/emoji.jfif"));
        } catch (IOException e) {
            System.out.println("no image");
        }



        errorLabel = new JLabel("X");
        errorLabel.setBounds(100,170,300,30);


        add(errorLabel);



        userTextField = new JTextField();
        userTextField.setBounds(90,30,100,30);

        JLabel userTextLabel = new JLabel("Input Name:");
        userTextLabel.setBounds(90,0,100,30);

        add(userTextField);
        add(userTextLabel);





        //todo : select from free rooms
        //check all the bookings with the same date and remove rooms that are occupied on that date
        roomTextField = new JTextField();
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
        searchButton.setBounds(0,160,90,40);
        add(searchButton);
        searchButton.addActionListener(this);

        pack();


    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Search")) {



            BookingList bookingList = new BookingList("data");
            bookingList.getBookingsFromData("data", bookingList.getBookingArrayList());


            String day = dayTextField.getText();
            String month = monthTextField.getText();
            String year = yearTextField.getText();
            String person = userTextField.getText();
            String room = roomTextField.getText();

            //extend a date by adding a 0, so it fills two slots always, e.g. 6 --> 06
            boolean exDay = false;
            String extendedDay = null;
            if (Integer.valueOf(day) < 10){
                String dayStr = day;
                extendedDay = "0"+ dayStr;
                exDay = true;
            }
            // same thing here
            boolean exMon = false;
            String extendedMonth = null;
            if (Integer.valueOf(month) < 10){
                String monthStr = month;
                extendedMonth = "0"+ monthStr;
                exMon = true;
            }
            String finalDate;

            // format the date
            if(exMon && !exDay){
                finalDate = day + extendedMonth + year;
            }
            else if(exMon && exDay){
                finalDate = extendedDay + extendedMonth + year;
            }
            else if(!exMon && exDay){
                finalDate = extendedDay + month + year;
            }
            else {
                finalDate = day + month + year;
            }



            //check in booking list
            boolean valid = false;

            Booking booking = new Booking(person,room,finalDate);
            //if the booking already exists, tell the user
            if (fileHandler.find("data",booking.toString()) == true){
                errorLabel.setText("Booking already exists!");
            } else{
                //add the booking
                fileHandler.appendLine("data", finalDate +","+ room +","+ person);
                errorLabel.setText("Booking Added! Your Booking is " + booking.toString());
            }

        }

    }
}
