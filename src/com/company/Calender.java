package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Calender extends JFrame implements ActionListener {
    int month;
    int year;
    int dayOfWeek;

    public Calender(int startingDay, int month, int year){

        dayOfWeek = startingDay;

        int week = 1;
        int width = 50;
        int height = 50;
        int daysInMonth = getDaysInMonth(month);

        JLabel monthDisplayLabel = new JLabel(monthToString(month)+ " "+ Integer.toString(year));
        monthDisplayLabel.setBounds(225,30,1000,30);
        getContentPane().add(monthDisplayLabel);


        for(int day = 1; day <= daysInMonth; day++){
            JButton button = new JButton(Integer.toString(day));
            button.setBounds(0+((width+(width/5))*startingDay),0+((height+(height/5))*week),width,height);
            button.addActionListener(this);
            getContentPane().add(button);
            if(startingDay == 7){
                startingDay = 0;
                week++;
            }
            startingDay++;
        }
        setLayout(null);
        setBounds(0,0,550,450);
        setVisible(true);

        // add << buttons and >> buttons, make them make a new calender and close the old one
        JButton goBackOneMonth = new JButton("<<");
        goBackOneMonth.setBounds(0,350,60,45);
        getContentPane().add(goBackOneMonth);
        goBackOneMonth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                int daysInLastMonth = getDaysInMonth(getLastMonth(month));
                int newDayOfWeek = getDayOfWeek();
                int newYear = year;


                int newMonth = getLastMonth(month);
                if (month == 1){
                    newYear = year - 1;
                }

//                //checks if leap year, but does not make febuary have 29 days
//                int remainder = newYear % 4;
//                if (remainder == 0 || newMonth == 2){
//                    daysInLastMonth++;
//                }

                while (daysInLastMonth != 0){
                    if (newDayOfWeek == 0){
                        newDayOfWeek = 7;
                    }
                    daysInLastMonth--;
                    newDayOfWeek--;
                }

                Calender newCalender = new Calender(newDayOfWeek,newMonth,newYear);
                dispose();
            }

        });

        JButton goForwardOneMonth = new JButton(">>");
        goForwardOneMonth.setBounds(480,350,60,45);
        getContentPane().add(goForwardOneMonth);
        goForwardOneMonth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                int daysInNextMonth = getDaysInMonth(getNextMonth(month));
                int newDayOfWeek = getDayOfWeek();
                int newYear = year;


                int newMonth = getNextMonth(month);
                if (month == 12){
                    newYear = year + 1;
                }

//                //checks if leap year, but does not make febuary have 29 days
//                int remainder = newYear % 4;
//                if (remainder == 0 || newMonth == 2){
//                    daysInNextMonth++;
//                }

                //get the ending day of the main month
                int originalEndingDay = getDayOfWeek();
                int daysInMonth = getDaysInMonth(month);

                while (daysInMonth != 0){
                    if (originalEndingDay == 7){
                        originalEndingDay = 0;
                    }
                    originalEndingDay++;
                    daysInMonth--;
                }
                System.out.println("OG: " + originalEndingDay);
                newDayOfWeek = originalEndingDay ;


                System.out.println("ndow: "+ newDayOfWeek+ "newM: "+ newMonth);

                Calender newCalender = new Calender(newDayOfWeek,newMonth,newYear);
                dispose();
            }

        });


    }



    @Override
    //when any button is clicked
    public void actionPerformed(ActionEvent e) {

    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    private int getDaysInMonth(int month){
        int daysInMonth = 0;
        //get the general amount of days from each month
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8|| month == 10 || month == 12){
            daysInMonth = 31;
        } else if ( month == 4 ||month == 6 ||month == 9 ||month == 11 ) {
            daysInMonth = 30;
        } else if (month == 2) { //does not account for leap years
            daysInMonth = 28;
        }

        return daysInMonth;
    }

    private int getLastMonth(int month){
        if (month == 1) {
            return 12;
        } else{
            return month - 1;
        }
    }
    private int getNextMonth(int month){
        if (month == 12){
            return 1;
        } else{
            return month+1;
        }
    }

    private String monthToString(int month){
        switch (month){
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
        }
        return "";
    }


}
