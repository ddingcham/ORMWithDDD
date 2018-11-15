package com.example.demo.domain.customer;

import com.example.demo.common.Registrar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectionCustomerRepository implements CustomerRepository{
	@Autowired
	private Registrar registrar;
	
	
	@Override
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		registrar.add(Customer.class, customer);
	}

	@Override
	public Customer find(String identity) {
		// TODO Auto-generated method stub
		return (Customer)registrar.get(Customer.class, identity);
	}

	public void setRegistrar(Registrar registrar) {
		this.registrar = registrar;
	}

	
	
}
