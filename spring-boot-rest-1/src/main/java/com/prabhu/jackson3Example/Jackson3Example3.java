package com.prabhu.jackson3Example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Jackson3Example3 {

	public static void main(String[] args) throws JsonProcessingException {

		ObjectMapper om = new ObjectMapper();
		Staff2 s2 = new Staff2("prabhu",34);
		String s2string = om.writeValueAsString(s2);
		System.out.println("s2string:"+s2string);
		
		Staff ss = new Staff();
		ss.setAge(34);
		ss.setName("prabhu");
		System.out.println("ss:"+ss);
		String ssstring = om.writeValueAsString(ss);
		System.out.println("ssstring:"+ssstring);
		

		Staff2 s22 = new Staff2();
		s22.setAge(23);
		String s22string = om.writeValueAsString(s22);
		System.out.println("s22string:"+s22string);
		
		Staff2 s23 = new Staff2();
		//s23.setAge(23);
		String s23string = om.writeValueAsString(s23);
		System.out.println("s23string:"+s23string);		
		
	}

}
