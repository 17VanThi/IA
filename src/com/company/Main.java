package com.company;


public class Main {

    public static void main(String[] args) {
	// write your code here
       
        BookingList newBookingList = new BookingList();
        newBookingList.getBookingsFromData("data",newBookingList.getArrayList());
        newBookingList.displayList();

    }
}
