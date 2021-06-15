package com.prabhu.jackson3Example;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Staff2 {
	@JsonProperty("staff_name")
    private String name;
	@JsonInclude(JsonInclude.Include.NON_NULL) 
    private int age;
    
    public Staff2(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Staff2() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;    
}
}
