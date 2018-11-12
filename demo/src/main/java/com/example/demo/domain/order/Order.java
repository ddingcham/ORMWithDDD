package com.example.demo.domain.order;

import java.util.HashSet;
import java.util.Set;

import com.example.demo.common.EntryPoint;
import com.example.demo.domain.customer.Customer;
import com.example.demo.domain.customer.Money;

public class Order extends EntryPoint{
	private Set<OrderLineItem> lineItems = new HashSet<OrderLineItem>();
	private Customer customer;

	public static Order order(String orderId, Customer customer) {
		// TODO Auto-generated method stub
		return new Order(orderId, customer);
	}
	
	Order(String orderId, Customer customer) {
		super(orderId);
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

}
