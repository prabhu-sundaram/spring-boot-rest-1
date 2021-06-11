package com.prabhu.jackson2Example;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSON2JacksonJsonNode {

	public static void main(String[] args) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		
		String json = "{ \"color\" : \"Black\", \"type\" : \"FIAT\" }";
		JsonNode jsonNode = objectMapper.readTree(json);
		String color = jsonNode.get("color").asText();
		System.out.println("color:"+color);
		
		// Output: color -> Black

		//---------------------
	    String jsonString = "{\"k1\":\"v1\",\"k2\":\"v2\"}";
	    
	    ObjectMapper mapper = new ObjectMapper();
	    JsonFactory factory = mapper.getFactory();
	    JsonParser parser = factory.createParser(jsonString);
	    JsonNode actualObj = mapper.readTree(parser);
		System.out.println("actualObj:"+actualObj);
		System.out.println("actualObj:"+actualObj.asText());	    
	    
		//---------------------
	    ObjectMapper mapper2 = new ObjectMapper();
	    JsonNode actualObj2 = mapper2.readTree(jsonString);
	    
	    JsonNode jsonNode1 = actualObj2.get("k1");
		System.out.println("jsonNode1:"+jsonNode1);
		System.out.println("jsonNode1:"+jsonNode1.asText());
	    
	}

}
