package com.prabhu.jackson2Example;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONArrayString2JavaList {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		
		String jsonCarArray = 
				  "[{ \"color\" : \"Black\", \"type\" : \"BMW\" }, { \"color\" : \"Red\", \"type\" : \"FIAT\" }]";
				List<Car> listCar = objectMapper.readValue(jsonCarArray, new TypeReference<List<Car>>(){});

	}

}
