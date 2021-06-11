package com.prabhu.jackson2Example;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HandlingCollections {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		String jsonCarArray = 
				  "[{ \"color\" : \"Black\", \"type\" : \"BMW\" }, { \"color\" : \"Red\", \"type\" : \"FIAT\" }]";
		
				ObjectMapper objectMapper = new ObjectMapper();
				objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
				Car[] cars = objectMapper.readValue(jsonCarArray, Car[].class);
				// print cars
				
				ObjectMapper objectMapper2 = new ObjectMapper();
				List<Car> listCar = objectMapper2.readValue(jsonCarArray, new TypeReference<List<Car>>(){});
				// print cars

	}

}
