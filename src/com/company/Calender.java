package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Calender extends JFrame implements ActionListener {
    int month;
    int year;
    public Calender(){

        int x = 10;
        int y = 10;
        int w = 50;
        int h = 50;

        setLayout(null);

        ArrayList<JButton> buttonList = new ArrayList<JButton>();

        int num = 1; // button label


        this.setPreferredSize(new Dimension(450,240)); //size of window

        // the calender should have buttons that allow you to go back/forward a month
        for(int i = 0; i < 4; i++ ){ //columns or weeks
            x = 10 ;
            for(int j = 0; j < 7; j++){ //row or day

                //new button
                JButton button = new JButton(Integer.toString(num));
                //set its bounds
                button.setBounds(x,y,w,h);
                //Add an action listener
                button.addActionListener(this);
                //add the button to the parent GUI panel
                getContentPane().add(button);

                //add the button to an arraylist
                buttonList.add(button);

                x = x+w+10;
                num++;
            }
            y = y + 60;
        }
        /*
        System.out.println(buttonList.get(buttonList.size()-1).getText());
        buttonList.get(buttonList.size() - 1).setBounds(0,0,50,50);

         */

        pack();
        setVisible(true);
    }

    public Calender(int dayOfWeek, int daysInMonth){

        //dayOfWeek is the starting day, 1 -> monday, 7 -> sunday
        int week = 1;
        int width = 50;
        int height = 50;
        for(int day = 1; day <= daysInMonth; day++){
            JButton button = new JButton(Integer.toString(day));
            button.setBounds(0+((width+(width/5))*dayOfWeek),0+((height+(height/5))*week),width,height);
            button.addActionListener(this);
            getContentPane().add(button);
            if(dayOfWeek == 7){
                dayOfWeek = 0;
                week++;
            }
            dayOfWeek++;
        }
        setLayout(null);
        setBounds(0,0,550,450);
        setVisible(true);
    }


    @Override
    //when any button is clicked
    public void actionPerformed(ActionEvent e) {

    }
}
