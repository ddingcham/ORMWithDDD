package com.example.demo.domain.order;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.example.demo.common.Registrar;
import com.example.demo.domain.customer.Customer;

public class OrderRepository {

	public void save(Order order) {
		// TODO Auto-generated method stub
		Registrar.add(Order.class, order);
	}

	public Set<Order> findByCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Set<Order> results = new HashSet<Order>();
		
		for(Order order : findAll()) {
			if(order.isOrderedBy(customer)) {
				results.add(order);
			}
		}
		
		return results;
	}

	@SuppressWarnings("unchecked")
	public Set<Order> findAll() {
		return new HashSet<Order>((Collection<Order>)Registrar.getAll(Order.class));
	}
}
