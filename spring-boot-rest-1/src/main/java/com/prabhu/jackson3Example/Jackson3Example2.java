package com.prabhu.jackson3Example;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Jackson3Example2 {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {

		Staff s1 = CreateStaff();
		ObjectMapper om = new ObjectMapper();
		om.writeValue(new File("src/main/resources/staff.json"), s1);

		String s2 = om.writeValueAsString(s1);
		System.out.println("s2:"+s2);
		
		String s3 = om.writerWithDefaultPrettyPrinter().writeValueAsString(s1);
		System.out.println("s3:"+s3);
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
}
