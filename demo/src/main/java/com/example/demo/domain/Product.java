package com.example.demo.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue
	private Long id;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="amount", column=@Column(name="price"))
	})
	private Money price;
	private String name;
	
	public Product() {}
	
	public Product(String name, long price) {
		// TODO Auto-generated constructor stub
		this(name, new Money(price));
	}
	
	public Product(String name, Money price) {
		this.name = name;
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
