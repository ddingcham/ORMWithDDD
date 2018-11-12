package com.example.demo.domain.order;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.example.demo.common.Registrar;
import com.example.demo.domain.customer.Customer;
import com.example.demo.domain.product.Product;
import com.example.demo.domain.product.ProductRepository;

public class OrderRepositoryTest {
	private Customer customer;
	private OrderRepository orderRepository;
	private ProductRepository productRepository;
	
	@Before
	public void setUp() {
		Registrar.init();
		orderRepository = new OrderRepository();
		productRepository = new ProductRepository();
		productRepository.save(new Product("상품1", 1000));
		productRepository.save(new Product("상품2", 5000));
		
		customer = new Customer("CUST-01", "홍길동", "경기도 안양시", 200000);
	}
	
	@Test
	public void testOrderCount() throws Exception {
		orderRepository.save(customer.newOrder("CUST-01-ORDER-01")
									.with("상품1", 5)
									.with("상품2", 20)
									.with("상품1", 5));
		orderRepository.save(customer.newOrder("CUST-01-ORDER-02")
									.with("상품1", 20)
									.with("상품2", 5));
		
		assertEquals(2, orderRepository.findByCustomer(customer).size());		
	}
}
