package com.prabhu.beans;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.prabhu.jacksonExample.CustomDateSerializer;

import lombok.Data;
import lombok.NoArgsConstructor;

public class Event2 {
private String name;
//@JsonFormat
//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
@JsonSerialize(using = CustomDateSerializer.class)

private Date eventDate;
public Event2(String name, Date eventDate) {
	super();
	this.name = name;
	this.eventDate = eventDate;
}
public Event2() {
	super();
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Date getEventDate() {
	return eventDate;
}
public void setEventDate(Date eventDate) {
	this.eventDate = eventDate;
}
@Override
public String toString() {
	return "Event2 [name=" + name + ", eventDate=" + eventDate + ", getName()=" + getName() + ", getEventDate()="
			+ getEventDate() + "]";
}
}
