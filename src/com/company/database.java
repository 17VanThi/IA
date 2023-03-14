package com.company;

public class database {
	//filename should be data
	private static String fileName = "data" ;
	
	public static void append(String data){
		fileHandler.appendLine(fileName , data);
	}
	
	public static String getData(int position){
		String data = fileHandler.readLineAt(fileName , position);
		return data;
	}
	
}
