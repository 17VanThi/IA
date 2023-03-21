package com.company;

import java.io.*;

// do file stuff in here only
public class fileHandler {
	
	public static void FileWriteLine(String Filename, String Text, Boolean append){
		
		try(
			FileWriter write = new FileWriter(Filename , append);
			PrintWriter writer= new PrintWriter(write);
		){
			writer.println(Text);
		}// try
		catch(IOException e){
			e.printStackTrace();
		}// exception
		
	}// filewrite
	
	public static void appendLine(String fileName, String data) {
		// write text to end of the file
		boolean append = true;
		try (PrintWriter pr = new PrintWriter(new FileWriter(fileName, append))) {
			pr.println(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String readLineAt(String fileName, int start) {
		// grab the line from position "start" in the file
		
		try (RandomAccessFile rf = new RandomAccessFile(fileName, "rws")) {
			rf.seek(start);
			String line = rf.readLine();
			return line;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static int getLineCount(String fileName){
		//read the whole line and increment count if line != null
		int count = 0;
		try{
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			
			while (line != null) {
				count++;
				line = br.readLine();
			}
			return count;
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static boolean find(String filename, String data){
		// loops through the whole file looking for the data, very inefficient
		try{
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			//return true if inputted data is the same as the line
			//loop through file
			while (line != null) {
				line = br.readLine();
				//make sure you dont compare string to null (avoid the error)
				if (line == null){
					//break the loop
					return false;
				}
				if (line.equals(data)){
					return true;
				}
			}
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// doesnt work
	public static void delete(String fileName, int start) {
		// grab the line from position "start" in the file
		try (RandomAccessFile rf = new RandomAccessFile(fileName, "rws")) {
			rf.seek(start);
			
			//TODO; make it write instead of read
			//read the line at this place
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			
			//set it to nothing
			line = "";
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
