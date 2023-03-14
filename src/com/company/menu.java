package com.company;
import java.io.IOException;
import java.util.Scanner;
public class menu {
	
	public static void start(){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Options \n 1 - Book a room \n 2 - TBA \n 3 - Exit");
		System.out.print("Option: ");
		
		int option = sc.nextInt();
		
		while (option != 3){
			if (option == 1 ){
				//TODO ; book a room
			}
			if (option == 2){
				//TODO do something
			}
		}
		
		
		
	}
}
