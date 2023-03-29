package com.company;
import java.util.ArrayList;
//this class will be used for keeping track of bookings and sorting them
public class BookingList {
	ArrayList<Booking> bookings;
	
	public BookingList() {
		bookings = new ArrayList<Booking>();
	}
	
	public void addBooking(Booking booking){
		bookings.add(booking);
	}
}
