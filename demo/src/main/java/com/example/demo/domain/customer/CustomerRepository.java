package com.example.demo.domain.customer;

import com.example.demo.common.Registrar;

public class CustomerRepository {

	public void save(Customer customer) {
		// TODO Auto-generated method stub
		Registrar.add(Customer.class, customer);
	}

	public Customer find(String identity) {
		// TODO Auto-generated method stub
		return (Customer)Registrar.get(Customer.class, identity);
	}

}
