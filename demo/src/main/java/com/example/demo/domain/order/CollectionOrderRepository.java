package com.example.demo.domain.order;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.common.Registrar;
import com.example.demo.domain.customer.Customer;

@Service
public class CollectionOrderRepository implements OrderRepository {
	@Autowired
	private Registrar registrar;

	@Override
	public void save(Order order) {
		// TODO Auto-generated method stub
		registrar.add(Order.class, order);
	}

	@Override
	public Order find(String identity) {
		return (Order)registrar.get(Order.class, identity);
	}

	@Override
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

	@Override
	@SuppressWarnings("unchecked")
	public Set<Order> findAll() {
		return new HashSet<Order>((Collection<Order>)registrar.getAll(Order.class));
	}

	@Override
	public Order delete(String identity) {
		// TODO Auto-generated method stub
		return (Order)registrar.delete(Order.class, identity);
	}

	public void setRegistrar(Registrar registrar) {
		this.registrar = registrar;
	}
	
	
}
