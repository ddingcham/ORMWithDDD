package com.example.demo.domain.order;

import com.example.demo.common.Registrar;

public class OrderRepository {

	public void save(Order order) {
		// TODO Auto-generated method stub
		Registrar.add(Order.class, order);
	}

}
