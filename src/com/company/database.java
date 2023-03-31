package com.company;

public class database {
	//filename should be data
	private static String FILENAME = "data" ;
	
	public static void append(String data){
		fileHandler.appendLine(FILENAME , data);
	}
	
	public static String getDataFromSpecificLine(int lineNumber){
		String data = fileHandler.getDataFromSpecificLine(FILENAME,lineNumber);
		System.out.println(data);
		return data;
	
	}
	
}
