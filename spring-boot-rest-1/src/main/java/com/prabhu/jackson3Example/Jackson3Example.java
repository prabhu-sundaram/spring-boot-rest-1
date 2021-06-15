package com.prabhu.jackson3Example;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prabhu.jackson2Example.Car;

public class Jackson3Example {

	public static void main(String[] args) throws IOException {
		
		ObjectMapper om = new ObjectMapper();
	
		Car car1 = om.readValue("{\"color\":\"yellow\",\"type\":\"renault\"}", Car.class);
		System.out.println("car1:"+car1.toString());

		Car car2 = om.readValue(new File("src/main/resources/car.json"), Car.class);
		System.out.println("car2:"+car2.toString());
		
		Car car3 = new Car("Green","Audi");
		ObjectMapper om3 = new ObjectMapper();
		String jsonString = om3.writeValueAsString(car3);
		System.out.println("jsonString:"+jsonString);
		
		System.out.println("--------------------------");
		
		Staff s3 = new Staff();
		s3 = om.readValue(new File("src/main/resources/staff.json"), Staff.class);
		System.out.println("s3:"+s3);

		String jsonString2 = om.writerWithDefaultPrettyPrinter().writeValueAsString(s3);
		System.out.println("jsonString2:"+jsonString2);
		System.out.println("--------------------------");

		
	}

}
