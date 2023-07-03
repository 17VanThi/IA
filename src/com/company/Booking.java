package com.company;

public class Booking {
	String name;
	String room;
	String date;
	
	public Booking(String name, String room, String date) {
		this.name = name;
		this.room = room;
		this.date = date;
	}
	
	//todo check clashing
	//loop through all the rooms in BookingList, check if Room and Date is the same as this booking,
	// if it is the same then notify the user that it clashes and then delete it(?) or recommend another date for the same room
	// e.g. same day next week

	
	public char getFirstLetterFromRoom(){
		return 'a' ;
	}
	
	public int getDayFromDate(){
		// date is DDMMYYYY
		//read the first 2 chars of the date
		char char1 = date.charAt(0);
		char char2 = date.charAt(1);
		String combinedDay = ("" + char1 + char2);
		/*
		int day = Integer.parseInt(combinedDay);
		return day;
		 */
		return Integer.parseInt(combinedDay);
	}
	
	public int getMonthFromDate(){
		//read the 3rd and 4th chars
		char char1 = date.charAt(2);
		char char2 = date.charAt(3);
		String combinedMonth = ("" + char1 + char2);
		int month = Integer.parseInt(combinedMonth);
		return month;
		
	}
	public int getYearFromDate(){
		//read the 5th to 8th chars
		char char1 = date.charAt(4);
		char char2 = date.charAt(5);
		char char3 = date.charAt(6);
		char char4 = date.charAt(7);
		
		String combinedYear = ("" + char1 + char2 + char3 + char4);
		int year = Integer.parseInt(combinedYear);
		return year;
	}
	
	public void display(){
		System.out.println(toString());
	}

	public String toString(){
		return name+","+room+","+date;
	}

	
}
