package com.jdbc.readingfromfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.bov.dto.User;
import com.jdbcwork.DataBaseOperater;

public class ReadFromFile {
	
	
	public static void main(String args[]) { 
		
		
		String filename ="/Users/junaidpasha/Documents/userdata.txt";
		
		String line = null;
		BufferedReader fileBufferReader  = null;
		
		
		try { 
			
			FileReader fileReader = new FileReader(filename);

			fileBufferReader = new BufferedReader(fileReader);

			while ((line = fileBufferReader.readLine()) != null) {

				User user = new User();
				System.out.println(line);
				
				String values[]  =line.split(","); // OR StringTokenizer
				user.setId(Integer.parseInt(values[0]));
				user.setUserName(values[1]);
				user.setPassword(values[2]);
				
				DataBaseOperater.saveUserObject(user);
				

			}

			fileBufferReader.close();
		}

		catch (Exception ex) {

			ex.printStackTrace();

		}
		
	}
	
	

}
