package com.example.demo.domain.customer;

import com.example.demo.common.EntryPoint;
import com.example.demo.common.Registrar;

public class Customer extends EntryPoint {
	private String customerNumber;
	private String name;
	private String address;
	private long mileage;

	public Customer(String customerNumber, String name, String address) {
		super(customerNumber);
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

	public static Customer find(String customerName) {
		// TODO Auto-generated method stub
		return (Customer)Registrar.get(Customer.class, customerName);
	}

	@Override
	public Customer persist() {
		// TODO Auto-generated method stub
		return (Customer)super.persist();
	}
	
	

}
