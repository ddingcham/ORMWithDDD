package com.example.demo.domain.order;

import java.util.Set;

import com.example.demo.domain.customer.Customer;

public interface OrderRepository {
	public void save(Order order);
	public Order find(String identity);
	public Set<Order> findByCustomer(Customer customer);
	public Set<Order> findAll();
	public Order delete(String identity);
}
