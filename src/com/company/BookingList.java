package com.company;
import java.util.ArrayList;
import java.util.logging.FileHandler;

//this class will be used for keeping track of bookings and sorting them
public class BookingList {
	ArrayList<Booking> bookings;
	
	public BookingList() {
		bookings = new ArrayList<Booking>();
	}
	
	public void addBooking(Booking booking){
		bookings.add(booking);
	}
	
	//loop through the text file and add the bookings to the list
	
	//the file to get the data from , and the list to put them into
	private void getBookingsFromData(String filename,ArrayList<Booking> bookings){
		int lineCount = fileHandler.getLineCount(filename);
		String lineData;
		for(int i = 0; i < lineCount; i++){
			lineData = database.getDataFromSpecificLine(i);
			Booking newBooking = database.getBookingFromData(lineData);
			
		}
	}
	
	
	//TODO make functions that sort the bookings
	//Sort by date
	
	//Search by Person
	
	//Search by Room
	
	//TODO make function that reads the data and adds the bookings into the array
	//or just do it in database
	
}
