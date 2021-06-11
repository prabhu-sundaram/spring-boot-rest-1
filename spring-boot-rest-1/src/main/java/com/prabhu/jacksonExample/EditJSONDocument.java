package com.prabhu.jacksonExample;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class EditJSONDocument {

	public static void main(String[] args) throws IOException {

byte[] jsonData = Files.readAllBytes(Paths.get("employee.txt"));

ObjectMapper objectMapper = new ObjectMapper();

//create JsonNode
JsonNode rootNode = objectMapper.readTree(jsonData);

//update JSON data
((ObjectNode) rootNode).put("id", 500);
//add new key value
((ObjectNode) rootNode).put("test", "test value");
//remove existing key
((ObjectNode) rootNode).remove("role");
((ObjectNode) rootNode).remove("properties");
objectMapper.writeValue(new File("updated_emp.txt"), rootNode);


	}

}
