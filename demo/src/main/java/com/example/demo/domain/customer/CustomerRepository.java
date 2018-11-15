package com.example.demo.domain.customer;

public interface CustomerRepository {

	public void save(Customer customer);
	public Customer find(String identity);

}
