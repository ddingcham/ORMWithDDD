package com.example.demo.domain;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long>{
	public Order findByOrderId(String identity);
	public Set<Order> findByCustomer(Customer customer);
	public Set<Order> findAll();
	public Order deleteByOrderId(String identity);
}
