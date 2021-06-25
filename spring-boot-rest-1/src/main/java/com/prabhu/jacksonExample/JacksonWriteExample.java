package com.prabhu.jacksonExample;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.prabhu.beans.Address;
import com.prabhu.beans.Car;
import com.prabhu.beans.Car2;
import com.prabhu.beans.Emp;
import com.prabhu.beans.Request;
import com.prabhu.beans.Staff;
import com.prabhu.beans.Staff2;

public class JacksonWriteExample {

	public static void main(String[] args) throws IOException {
		ObjectMapper om = new ObjectMapper();
		
		
		
		System.out.println("--------------Java Object to JSON String-------writeValueAsString-----");	

		Car car3 = new Car("Green","Audi");
		String jsonString = om.writeValueAsString(car3);
		System.out.println("jsonString:"+jsonString);
		
		Staff s11 = CreateStaff();
		String s2 = om.writeValueAsString(s11);
		System.out.println("s2:"+s2);
		
		Staff2 s23 = new Staff2("prabhu",34);
		String s23string = om.writeValueAsString(s23);
		System.out.println("Staff2 s23string:"+s23string);
		
		Staff ss = new Staff();
		ss.setAge(34);
		ss.setName("prabhu");
		System.out.println("ss:"+ss);
		String ssstring = om.writeValueAsString(ss);
		System.out.println("ss string:"+ssstring);
		
		Staff2 s22 = new Staff2();
		s22.setAge(23);
		String s22string = om.writeValueAsString(s22);
		System.out.println("Staff2 s22string:"+s22string);
		
		Staff2 s233 = new Staff2();
		//s23.setAge(23);
		String s233string = om.writeValueAsString(s233);
		System.out.println("Staff2 s233 string:"+s233string);		
		
		String s233stringPretty = om.writerWithDefaultPrettyPrinter().writeValueAsString(s233);
		System.out.println("Staff2 s233string Pretty:"+s233stringPretty);	

	
		
		System.out.println("--------------------------");	
		System.out.println("-------------HandlingDateFormats-------------");		
		
		ObjectMapper objectMapper = new ObjectMapper();
		
        Car car = new Car("yellow", "renault");
		Request request = new Request(car,new Date());
		
		String carAsString = objectMapper.writeValueAsString(request);
		System.out.println("carAsString:"+carAsString);
		
	
		//Car2 car22 = new Car2("Toyato", 4, "Green", "Toyato", 1920, new Date(), true);
		Car2 car22 = new Car2();
		car22.setBrand("Toyato");
		car22.setDoors(4);
		car22.setColor("Green");
		car22.setType("Toyato");
		car22.setYear(2000);
		car22.setDate(new Date());
		car22.setStatus(true);
		String car22AsString = objectMapper.writeValueAsString(car22);
		System.out.println("car22AsString:"+car22AsString);
		
		
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
		objectMapper.setDateFormat(df);

		String carAsString2 = objectMapper.writeValueAsString(request);
		System.out.println("carAsString2:"+carAsString2);
		// output: {"car":{"color":"yellow","type":"renault"},"datePurchased":"2016-07-03 11:43 AM CEST"}

		DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
		objectMapper.setDateFormat(df2);		
		String car22AsString2 = objectMapper.writeValueAsString(car22);
		System.out.println("car22AsString2:"+car22AsString2);
		
		
		System.out.println("--------------------------");	
		
		System.out.println("--------------Java Object to JSON String------writeValue------");	
		
		Staff s1 = new Staff();
		System.out.println("s1:"+s1.toString());
		om.writeValue(new File("src/main/resources/staff.json"), s1);
		
		Car car11 = new Car("yellow", "renault");
		om.writeValue(new File("src/main/resources/car11.json"), car11);
		String carAsString11 = om.writeValueAsString(car11);
		System.out.println("carAsString11:"+carAsString11);
		System.out.println("car toString11:"+car11.toString());
		
		om.writeValue(new FileOutputStream("src/main/resources/car11-2.json"), car11);
		
		ObjectMapper om2 = new ObjectMapper();

		//convert Object to json string
		Emp emp1 = createEmployee();
		//configure Object mapper for pretty print
		om2.configure(SerializationFeature.INDENT_OUTPUT, true);
		
		//writing to console, can write to any output stream such as file
		StringWriter stringEmp = new StringWriter();
		om2.writeValue(stringEmp, emp1);
		System.out.println("INDENT_OUTPUT Employee JSON is\n"+stringEmp);
		System.out.println("--------------------------");	
		
		System.out.println("--------------Java Object to JSON String------writeValueAsBytes------");	
		
		
		
		System.out.println("--------------------------");	
		System.out.println("------------EditJSONDocument--------------");	
		
		byte[] jsonData = Files.readAllBytes(Paths.get("src/main/resources/employee.txt"));

		//create JsonNode
		JsonNode rootNode = om.readTree(jsonData);

		//update JSON data
		((ObjectNode) rootNode).put("id", 500);
		//add new key value
		((ObjectNode) rootNode).put("test", "test value");
		//remove existing key
		((ObjectNode) rootNode).remove("role");
		((ObjectNode) rootNode).remove("properties");
		objectMapper.writeValue(new File("src/main/resources/updated_emp.txt"), rootNode);		
		objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/resources/updated_emp_pretty.txt"), rootNode);	

		
		System.out.println("--------------------------");	

	}
	private static Staff CreateStaff()
	{
		Staff s0 = new Staff();
		s0.setAge(34);
		s0.setName("prabhu");
		s0.setPosition(new String[]{"Founder", "CTO", "Writer"});
		s0.setSkills(Arrays.asList("java", "python", "node", "kotlin"));
		Map <String, BigDecimal> map = new HashMap<String, BigDecimal>();
		map.put("2010", new BigDecimal(100000));
		map.put("2015", new BigDecimal(150000));
		map.put("2020", new BigDecimal(200000));
		s0.setSalary(map);
		return s0;
		
		}
	
	public static Emp createEmployee() {

		Emp emp = new Emp();
		emp.setId(100);
		emp.setName("David");
		emp.setPermanent(false);
		emp.setPhoneNumbers(new long[] { 123456, 987654 });
		emp.setRole("Manager");

		Address add = new Address();
		add.setCity("Bangalore");
		add.setStreet("BTM 1st Stage");
		add.setZipcode(560100);
		emp.setAddress(add);

		List<String> cities = new ArrayList<String>();
		cities.add("Los Angeles");
		cities.add("New York");
		emp.setCities(cities);

		Map<String, String> props = new HashMap<String, String>();
		props.put("salary", "1000 Rs");
		props.put("age", "28 years");
		emp.setProperties(props);

		return emp;
	}	
}
