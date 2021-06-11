package com.prabhu.jackson2Example;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JavaObject2JSON {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		Car car = new Car("yellow", "renault");
		objectMapper.writeValue(new File("target/car.json"), car);
		String carAsString = objectMapper.writeValueAsString(car);
System.out.println("carAsString:"+carAsString);
System.out.println("car toString:"+car.toString());

	}

}
