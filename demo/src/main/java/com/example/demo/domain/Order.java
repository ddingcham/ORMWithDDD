package com.example.demo.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.common.EntryPoint;

@Entity
@Table(name="DemoOrder")
public class Order {
	@Id
	@GeneratedValue
	private Long id;
	private String orderId;
	@OneToMany
	private Set<OrderLineItem> lineItems = new HashSet<OrderLineItem>();
	@ManyToOne
	private Customer customer;

	public static Order order(String orderId, Customer customer) {
		// TODO Auto-generated method stub
		return new Order(orderId, customer);
	}
	
	public Order(){}
	
	Order(String orderId, Customer customer) {
		this.orderId = orderId;
		this.customer = customer;
	}
	
	public Order with(String productName, int quantity)
		throws OrderLimitExceededException {
		return with(new OrderLineItem(productName, quantity));
	}
	
	private Order with(OrderLineItem lineItem)
		throws OrderLimitExceededException{
		if(isExceedLimit(customer, lineItem)) {
			throw new OrderLimitExceededException();
		}
		
		lineItems.add(lineItem);
		return this;
	}
	
	private boolean isExceedLimit(Customer customer, OrderLineItem lineItem) {
		return customer.isExceedLimitPrice(getPrice().add(lineItem.getPrice()));
	}
	
	public Money getPrice() {
		Money result = new Money(0);
		
		for(OrderLineItem item : lineItems) {
			result = result.add(item.getPrice());
		}
		
		return result;
	}

	public boolean isOrderedBy(Customer customer) {
		// Repository에 의한 유일성과 추적성 보장
		return this.customer == customer;
	}

	public Long getId() {
		return id;
	}
	
	String getOrderId() {
		return orderId;
	}
	
	public boolean equals(Object object) {
		if (object == this) {
			return true;
		}
		
		if(!(object instanceof Order)) {
			return false;
		}
		
		final Order other = (Order)object;
		return this.orderId.equals(other.getOrderId());
	}
	
	public int hashCode() {
		return this.orderId.hashCode();
	}

}
