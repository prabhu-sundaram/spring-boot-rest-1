package com.prabhu.jackson2Example;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConfigureSerDeser {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		String jsonString 
		  = "{ \"color\" : \"Black\", \"type\" : \"Fiat\", \"year\" : \"1970\" }";
		ObjectMapper objectMapper = new ObjectMapper();
		
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Car car = objectMapper.readValue(jsonString, Car.class);
		System.out.println("car:"+car);
		
		JsonNode jsonNodeRoot = objectMapper.readTree(jsonString);
		JsonNode jsonNodeYear = jsonNodeRoot.get("year");
		String year = jsonNodeYear.asText();
		System.out.println("year:"+year);

		objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
		objectMapper.configure(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS, false);

		
		
	}

}
