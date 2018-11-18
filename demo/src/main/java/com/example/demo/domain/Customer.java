package com.example.demo.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	@GeneratedValue
	private Long id;
	private String customerNumber;
	private String name;
	private String address;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="amount", column=@Column(name="mileage"))
	})
	private Money mileage;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="amount", column=@Column(name="limitPrice"))
	})
	private Money limitPrice;
	
	Customer(){}

	public Customer(String customerNumber, String name, String address, long limitPrice) {
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
