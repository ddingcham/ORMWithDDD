package com.example.demo.domain.order;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.common.Registrar;
import com.example.demo.domain.customer.Customer;
import com.example.demo.domain.product.Product;
import com.example.demo.domain.product.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderRepositoryTest {
	@Autowired
	private Registrar registrar;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private ProductRepository productRepository;
	private Customer customer;
	
	@Before
	public void setUp() {
		registrar.init();
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
