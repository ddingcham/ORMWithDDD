package com.example.demo.domain.customer;

public class Customer {
	private String customerNumber;
	private String name;
	private String address;
	private long mileage;

	public Customer(String customerNumber, String name, String address) {
		this.customerNumber = customerNumber;
		this.name = name;
		this.address = address;
	}

	public void purchase(long price) {
		// TODO Auto-generated method stub
		mileage += price * 0.01;
	}

	public boolean isPossibleToPayWithMileage(long price) {
		// TODO Auto-generated method stub
		return mileage > price;
	}

	public boolean payWithMileage(long price) {
		// TODO Auto-generated method stub
		if (!isPossibleToPayWithMileage(price)) {
			return false;
		}
		mileage -= price;
		return true;
	}

	public long getMileage() {
		return mileage;
	}

}
