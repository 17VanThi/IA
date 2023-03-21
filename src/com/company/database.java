package com.company;

public class database {
	//filename should be data
	private static String fileName = "data" ;
	
	public static void append(String data){
		fileHandler.appendLine(fileName , data);
	}
	
	public static String getData(int position){
		//TODO add an offset of 2 for every 10 position
		// 20 -> 2 -> 4
		// 12 -> 1 -> 2
		// 19 -> 1 -> 2
		double offset = Math.floor(position/10)*2;
		String data = fileHandler.readLineAt(fileName , position + (int)offset);
		return data;
	}
	
}
