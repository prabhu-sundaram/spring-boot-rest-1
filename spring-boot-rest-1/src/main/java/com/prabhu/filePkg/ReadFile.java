package com.prabhu.filePkg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

	public static void main(String[] args) {
		String	fileLocation = "F:\\eclipse-ws\\quickstart2\\src\\test\\resources\\1234567890Payload.xml";
		  File file = new File(fileLocation ); 
		  String payload="";
	
		try 
		{
			
			  BufferedReader br = new BufferedReader(new FileReader(file)); 
			  String st; 
			  while ((st = br.readLine()) != null) 
			  {
				  payload=payload+st+"\n";
			    System.out.println(st); 
			  }
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
