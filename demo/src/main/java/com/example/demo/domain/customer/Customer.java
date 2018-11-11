package com.example.demo.domain.customer;

import com.example.demo.common.EntryPoint;
import com.example.demo.common.Registrar;
import com.example.demo.domain.order.Order;

public class Customer extends EntryPoint {
	private String customerNumber;
	private String name;
	private String address;
	private Money mileage;
	private Money limitPrice;

	public Customer(String customerNumber, String name, String address, long limitPrice) {
		super(customerNumber);
		this.customerNumber = customerNumber;
		this.name = name;
		this.address = address;
		this.limitPrice = new Money(limitPrice);
	}
	
	public Customer(String customerNumber, String name, String address) {
		// TODO Auto-generated constructor stub
		this(customerNumber, name, address, 0);
	}

	public Order newOrder(String orderId) {
		return Order.order(orderId, this);
	}
	
	public boolean isExceedLimitPrice(Money money) {
		return money.isGreaterThan(limitPrice);
	}

	public void purchase(long price) {
		// TODO Auto-generated method stub
		mileage = mileage.add(new Money(price * 0.01));
	}

	public boolean isPossibleToPayWithMileage(long price) {
		// TODO Auto-generated method stub
		return mileage.isGreaterThan(new Money(price));
	}

	public boolean payWithMileage(long price) {
		// TODO Auto-generated method stub
		if (!isPossibleToPayWithMileage(price)) {
			return false;
		}
		mileage = mileage.subtract(new Money(price));
		return true;
	}

	public Money getMileage() {
		return mileage;
	}

}
