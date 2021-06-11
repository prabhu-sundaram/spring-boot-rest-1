package com.prabhu.jackson2Example;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONString2JavaMap {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		
		String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
		Map<String, Object> map = objectMapper.readValue(json, new TypeReference<Map<String,Object>>(){});

	}

}
