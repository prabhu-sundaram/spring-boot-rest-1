package com.prabhu.jackson2Example;

import java.util.Date;

public class Request 
{
    private Car car;
    private Date datePurchased;
    
	public Request(Car car, Date datePurchased) {
		super();
		this.car = car;
		this.datePurchased = datePurchased;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public Date getDatePurchased() {
		return datePurchased;
	}
	public void setDatePurchased(Date datePurchased) {
		this.datePurchased = datePurchased;
	}
    
}
