package com.company;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class menu {
	
	public static void start(){
		Scanner sc = new Scanner(System.in);
		String FILENAME = "data";
		
		System.out.println("Options \n 1 - Book a room \n 2 - TBA \n 3 - Exit");
		System.out.print("Option: ");
		
		int option = sc.nextInt();
		
		while (option != 3){
			if (option == 1 ){
				//TODO book a room (take on a day, e.g. 23 of march instead of just a day in the week)
				System.out.println("What day? \n");
				System.out.println("Day (input number): ");
				int day = sc.nextInt();
				
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
				
				// same thing here
				boolean exMon = false;
				String extendedMonth = null;
				if (month < 10){
					String monthStr = Integer.toString(month);
					extendedMonth = "0"+ monthStr;
					exMon = true;
				}
				
				//TODO make date have a lower bound of 2023?
				System.out.println("What year?");
				System.out.println("Year (input number): ");
				String year = sc.next();
				
				String finalDate;
				
				if(exMon && !exDay){
					finalDate = day + extendedMonth + year + "|" + day + "," + extendedMonth + "," + year;;
				}
				else if(exMon && exDay){
					finalDate = extendedDay + extendedMonth + year + "|" + extendedDay + "," + extendedMonth + "," + year;
				}
				else if(!exMon && exDay){
					finalDate = extendedDay + month + year + "|" + extendedDay + "," + month + "," + year;
				}
				else {
					finalDate = day + month + year + "|" + day + "," + month + "," + year;
				}
				
				fileHandler.appendLine(FILENAME, finalDate);
				
				System.out.println("Options \n 1 - Book a room \n 2 - TBA \n 3 - Exit");
				System.out.print("Option: ");
				
				option = sc.nextInt();
				
			}
			if (option == 2){
				//TODO view the timetable
			}
		}
		
		
		
	}
}
