package com.prabhu.jackson2Example;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSON2JavaObject {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		
		String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
		ObjectMapper objectMapper = new ObjectMapper();
		//Car car = objectMapper.readValue(json, Car.class);
		Car car2 = objectMapper.readValue(new File("src/test/resources/json_car.json"), Car.class);
		//Car car3 = objectMapper.readValue(new URL("file:src/test/resources/json_car.json"), Car.class);
	}

}
