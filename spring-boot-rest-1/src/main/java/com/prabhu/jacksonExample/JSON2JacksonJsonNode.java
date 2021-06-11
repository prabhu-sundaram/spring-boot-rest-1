package com.prabhu.jacksonExample;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSON2JacksonJsonNode {

	public static void main(String[] args) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();		
		String json = "{ \"color\" : \"Black\", \"type\" : \"FIAT\" }";
		JsonNode jsonNode = objectMapper.readTree(json);
		String color = jsonNode.get("color").asText();
		// Output: color -> Black
		System.out.println("color:"+color);
	}

}
