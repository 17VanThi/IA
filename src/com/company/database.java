package com.company;

public class database {
	//filename should be data
	private static String FILENAME = "data" ;
	
	public static void append(String data){
		fileHandler.appendLine(FILENAME , data);
	}
	
	public static String getDataFromSpecificLine(int lineNumber){
		String data = fileHandler.getDataFromSpecificLine(FILENAME,lineNumber);
		return data;
	}
	
	public static Booking getBookingFromData(String data){
		//data is "DDMMYY,ROOM,PERSON"
		//bookings are name,room,date
		
		//get an array in the form of "DDMMYY","ROOM","PERSON"
		String[] dataValues = data.split(",");
		
		Booking newBooking = new Booking(dataValues[2],dataValues[1],dataValues[0]);
		newBooking.display();
		return newBooking;
	}
}
