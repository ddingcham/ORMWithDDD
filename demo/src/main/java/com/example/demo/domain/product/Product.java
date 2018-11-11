package com.example.demo.domain.product;

import com.example.demo.common.EntryPoint;
import com.example.demo.domain.customer.Money;

public class Product extends EntryPoint{

	private Money price;
	private String name;
	
	public Product(String name, long price) {
		// TODO Auto-generated constructor stub
		this(name, new Money(price));
	}
	
	public Product(String name, Money price) {
		super(name);
		this.price = price;
	}

	public Money getPrice() {
		// TODO Auto-generated method stub
		return price;
	}
	
	public String getName() {
		return name;
	}

}
