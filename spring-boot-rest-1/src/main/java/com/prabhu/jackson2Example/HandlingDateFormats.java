package com.prabhu.jackson2Example;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HandlingDateFormats {

	public static void main(String[] args) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
		objectMapper.setDateFormat(df);
		
        Car car = new Car("yellow", "renault");
		Request request = new Request(car,new Date());

		String carAsString = objectMapper.writeValueAsString(request);
		System.out.println("carAsString:"+carAsString);
		
		// output: {"car":{"color":"yellow","type":"renault"},"datePurchased":"2016-07-03 11:43 AM CEST"}

	}

}
