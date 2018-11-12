package com.example.demo.domain.order;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.example.demo.common.Registrar;
import com.example.demo.domain.customer.Customer;
import com.example.demo.domain.customer.Money;
import com.example.demo.domain.product.Product;
import com.example.demo.domain.product.ProductRepository;

public class OrderTest {
	private Customer customer;
	private OrderRepository orderRepository;
	private ProductRepository productRepository;
	
	@Before
	public void setUp() throws Exception {
		// TODO Auto-generated method stub
		Registrar.init();
		orderRepository = new OrderRepository();
		productRepository = new ProductRepository();
		productRepository.save(new Product("상품1", 1000));
		productRepository.save(new Product("상품2", 5000));
		
		customer = new Customer("CUST-01", "홍길동", "경기도 안양시", 200000);
	}
	
	@Test
	public void testOrderPrice() throws Exception {
		Order order = customer.newOrder("CUST-01-ORDER-01")
						.with("상품1", 10)
						.with("상품2", 20);
		orderRepository.save(order);
		assertEquals(new Money(110000), order.getPrice());
	}
	
	@Test
	public void testOrderIdentical() throws Exception {
		Order order = customer.newOrder("CUST-01-ORDER-01")
							.with("상품1", 10)
							.with("상품2", 20);
		orderRepository.save(order);
		
		Order anotherOrder = orderRepository.find("CUST-01-ORDER-01");
		assertEquals(order, anotherOrder);
	}
	
	@Test
	public void testDeleteOrder() throws Exception {
		orderRepository.save(customer.newOrder("CUST-01-ORDER-01")
								.with("상품1", 5)
								.with("상품2", 20));
		Order order = orderRepository.find("CUST-01-ORDER-01");
		
		orderRepository.delete("CUST-01-ORDER-01");
		
		assertNull(orderRepository.find("CUST-01-ORDER-01"));
		assertNotNull(order);
	}
}
