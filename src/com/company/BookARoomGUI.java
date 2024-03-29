package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookARoomGUI extends JFrame implements ActionListener {

    JTextField dayTextField;
    JTextField monthTextField;
    JTextField yearTextField;
    JTextField userTextField;
    JTextField roomTextField;
    JLabel errorLabel;

    public BookARoomGUI(){
        setLayout(null);
        this.setPreferredSize(new Dimension(500,240)); //size of window
        this.setResizable(false);

        errorLabel = new JLabel("");
        errorLabel.setBounds(100,170,300,30);

        add(errorLabel);

        userTextField = new JTextField();
        userTextField.setBounds(90,30,100,30);

        JLabel userTextLabel = new JLabel("Input Name:");
        userTextLabel.setBounds(90,0,100,30);

        add(userTextField);
        add(userTextLabel);

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


            //List of all existing Bookings to search through
            BookingList bookingList = new BookingList("data");
            bookingList.getBookingsFromData("data", bookingList.getBookingArrayList());
            System.out.println("Should be displaying something below...");
            bookingList.displayList();


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
            boolean valid = true;

            Booking booking = new Booking(person,room,finalDate);
            //if a booking already exists on the same day, tell the user and invalidate
            //also check for invalid date numbers
            if (fileHandler.find("dataDates", finalDate)){
                errorLabel.setText("Booking already exists!");
                valid = false;
            } else if (Integer.valueOf(day) > 32){
                errorLabel.setText("Day is too large!");
                valid = false;
            } else if (Integer.valueOf(month) > 12){
                errorLabel.setText("Month is too large!");
                valid = false;
            }  else if (Integer.valueOf(year) > 2050){
            errorLabel.setText("Year is too large!");
                valid = false;
            }  else if (Integer.valueOf(year) < 2022){
            errorLabel.setText("Year is too small!");
                valid = false;
            }

            if (valid){
                //add the booking
                fileHandler.appendLine("data", finalDate +","+ room +","+ person);
                errorLabel.setText("Booking Added! Your Booking is " + booking.toString());
                fileHandler.appendLine("dataDates",finalDate);
            }

        }

    }
}
