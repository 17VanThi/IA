package com.company;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class menu {
	
	public static void start(){
		Scanner sc = new Scanner(System.in);
		String FILENAME = "data";
		
		System.out.println("Options: \n [1] Book a room \n [2] View \n [3] Exit");
		System.out.print("Option: ");
		
		int option = sc.nextInt();
		
		while (option != 3){
			if (option == 1 ){
				// get name
				System.out.println("Who are you?");
				String name = sc.next();
				
				//get room
				
				System.out.println("What room?");
				String room = sc.next();
				
				System.out.print("What day? \n");
				System.out.println("Day (input number): ");
				int day = sc.nextInt();
				while (day > 33 || day < 0){
					System.out.println("Invalid day, day must be over 0 and less than 33");
					System.out.println("day (input number): ");
					day = sc.nextInt();
				}
				
				//extend a date by adding a 0, so it fills two slots always, e.g. 6 --> 06
				boolean exDay = false;
				String extendedDay = null;
				if (day < 10){
					String dayStr = Integer.toString(day);
					extendedDay = "0"+ dayStr;
					exDay = true;
				}
				
				System.out.println("What month? (1-12)");
				System.out.println("Month (input number): ");
				int month = sc.nextInt();
				while (month > 12 || month < 0){
					System.out.println("Invalid month, month must be over 0 and less than 12");
					System.out.println("Month (input number): ");
					month = sc.nextInt();
				}
				
				// same thing here
				boolean exMon = false;
				String extendedMonth = null;
				if (month < 10){
					String monthStr = Integer.toString(month);
					extendedMonth = "0"+ monthStr;
					exMon = true;
				}
				
			
				System.out.println("What year?");
				System.out.println("Year (input number): ");
				String year = sc.next();
				int intYear = Integer.parseInt(year);
				while (intYear < 2022){
					System.out.println("Invalid year, year must be over 2022");
					System.out.println("Year (input number): ");
					year = sc.next();
					intYear = Integer.parseInt(year);
				}
				
				//TODO Clash checking here
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
					finalDate = day + month + year ;
				}
				Booking newBooking = new Booking(name,room,finalDate);

				System.out.println("Your booking is:" );
				newBooking.display();

				fileHandler.appendLine(FILENAME, finalDate +","+ room +","+ name);
				
				System.out.println("Options \n 1 - Book a room \n 2 - TBA \n 3 - Exit");
				System.out.print("Option: ");
				
				option = sc.nextInt();
				
			}

			// view + sort
			if (option == 2){

				BookingList newList = new BookingList("data");
				//TODO view the timetable
				System.out.println("How would you like to view the timetable?");
				System.out.println(" [1] - By date \n [2] - By Person \n [3] - By room \n [4] - Return");
				System.out.print("Option:");

				int sortOption = sc.nextInt();

				if (sortOption == 1){
					newList.sortByDate();
					newList.displayList();
				}
				if (sortOption == 4){

					System.out.println("Options: \n [1] Book a room \n [2] View \n [3] Exit");
					System.out.print("Option: ");
					option = sc.nextInt();
				}
			}
		}
		
		
		
	}
}
