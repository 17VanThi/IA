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
				//TODO book a room
				System.out.println("What day? \n 1 - Monday | 2 - Tuesday | 3 - Wednesday | 4 - Thursday | 5 - Friday");
				System.out.println("Day (input number): ");
				String day = sc.next();
				
				System.out.println("What month? (1-12)");
				System.out.println("Month (input number): ");
				int month = sc.nextInt();
				if (month < 10){
					String monthStr = Integer.toString(month);
					String extendedMonth = "0"+ monthStr;
				}
				System.out.println("What year?");
				System.out.println("Year (input number): ");
				String year = sc.next();
				
				String finalDate = day + month + year;
				
				fileHandler.appendLine(FILENAME, finalDate);
				
				//TODO make it stop looping
			}
			if (option == 2){
				//TODO view the timetable
			}
		}
		
		
		
	}
}
