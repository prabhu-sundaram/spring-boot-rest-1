package com.prabhu.jacksonExample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadSpecificJSONKey {

	public static void main(String[] args) throws IOException {

		//read json file data to String
		byte[] jsonData = Files.readAllBytes(Paths.get("src/main/resources/employee.txt"));

		//create ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();

		//read JSON like DOM Parser
		JsonNode rootNode = objectMapper.readTree(jsonData);
		JsonNode idNode = rootNode.path("id");
		System.out.println("id = "+idNode.asInt());

		JsonNode phoneNosNode = rootNode.path("phoneNumbers");
		Iterator<JsonNode> elements = phoneNosNode.elements();
		while(elements.hasNext()){
			JsonNode phone = elements.next();
			System.out.println("Phone No = "+phone.asLong());
		}


	}

}
