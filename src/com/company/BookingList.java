package com.company;
import java.util.ArrayList;

//this class will be used for keeping track of bookings and sorting them
public class BookingList {
	ArrayList<Booking> bookings = new ArrayList<Booking>();

	//construct with existing datafile
	public BookingList(String filename){
		getBookingsFromData(filename,bookings);
	}

	public ArrayList<Booking> getBookingArrayList() {
		return bookings;
	}

	private void addBooking(Booking booking){
		bookings.add(booking);
	}
	
	//loop through the text file and add the bookings to the list
	
	//the file to get the data from , and the list to put them into
	public void getBookingsFromData(String filename,ArrayList<Booking> bookings){
		//delete everything in the list
		for (int i = 0; i< bookings.size(); i++){
			bookings.remove(i);
		}
		
		int lineCount = fileHandler.getLineCount(filename);
		System.out.println("total lines in:"+ filename +" is: "+ lineCount);
		String lineData;
		for(int i = 0; i < lineCount; i++){

			lineData = database.getDataFromSpecificLine(i);
			Booking newBooking = database.getBookingFromData(lineData);

			bookings.add(newBooking);
		}
	}
	
	public ArrayList<Booking> getArrayList() {
		return bookings;
	}
	
	public void displayList(){
		for( int i = 0 ; i< bookings.size();i++){
			bookings.get(i).display();
		}
	}

	public void sortByDate(){
		bookings = getBookingArrayList();
		//this arraylist will hold all the months of the bookings
		// e.g 10,9,2,2,3,12
		// Sort this list whilst doing the same thing to bookingIndex
		ArrayList <Integer> sortedByMonth = new ArrayList<Integer>();

		//bookingIndex[i]'s month should be equal to sortedByMonth[i] so that you can then sort by day
		ArrayList <Booking> bookingIndex = new ArrayList<Booking>();

		// add everything to the lists
		for (int i = 0; i< bookings.size();i++)	{
			bookingIndex.add(bookings.get(i));
			sortedByMonth.add(bookings.get(i).getMonthFromDate());
		}

        //sort
		for(int i = 0; i<sortedByMonth.toArray().length;i++){
			for (int j = 0; j <sortedByMonth.toArray().length;j++){

				if (sortedByMonth.get(i) > sortedByMonth.get(j)){
					int temp = sortedByMonth.get(i);
					//set arr[i] to [arr[j]
					sortedByMonth.set(i,sortedByMonth.get(j));
					sortedByMonth.set(j,temp);


					//do same thing to bookingIndex
					Booking tempBooking = bookingIndex.get(i);
					bookingIndex.set(i,bookingIndex.get(j));
					bookingIndex.set(j,tempBooking);


				}

			}
		}
		bookings = bookingIndex;


	}
	//Search by Person


	
	//Search by Room
	public void sortByRoom(){

		//turn to string,sort it that way

		//this arraylist will hold all the months of the bookings
		// e.g 10,9,2,2,3,12
		bookings = getBookingArrayList();

		// Sort this list whilst doing the same thing to bookingIndex
		ArrayList <Character> sortedByRoom = new ArrayList<Character>();

		//bookingIndex[i]'s room letter should be equal to sortedByRoom[i] so that you can then sort by day
		ArrayList <Booking> bookingIndex = new ArrayList<Booking>();

		// add everything to the lists
		for (int i = 0; i< bookings.size();i++)	{
			bookingIndex.add(bookings.get(i));
			sortedByRoom.add(bookings.get(i).getFirstLetterFromRoom());
		}

		//sort it
		for(int i = 0; i<sortedByRoom.toArray().length;i++){
			for (int j = 0; j <sortedByRoom.toArray().length;j++){

				if (sortedByRoom.get(i) > sortedByRoom.get(j)){
					char temp = sortedByRoom.get(i);
					//set arr[i] to [arr[j]
					sortedByRoom.set(i,sortedByRoom.get(j));
					sortedByRoom.set(j,temp);


					//do same thing to bookingIndex
					Booking tempBooking = bookingIndex.get(i);
					bookingIndex.set(i,bookingIndex.get(j));
					bookingIndex.set(j,tempBooking);


				}

			}
		}
		bookings = bookingIndex;



	}



}
