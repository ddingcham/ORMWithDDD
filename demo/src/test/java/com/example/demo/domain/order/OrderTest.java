package com.example.demo.domain.order;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.common.Registrar;
import com.example.demo.domain.Customer;
import com.example.demo.domain.Money;
import com.example.demo.domain.Order;
import com.example.demo.domain.OrderRepository;
import com.example.demo.domain.Product;
import com.example.demo.domain.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTest {
	
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private ProductRepository productRepository;
	private Customer customer;
	
	@Before
	public void setUp() throws Exception {
		// TODO Auto-generated method stub
		
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
		
		Order anotherOrder = orderRepository.findByOrderId("CUST-01-ORDER-01");
		assertEquals(order, anotherOrder);
	}
	
	@Test
	public void testDeleteOrder() throws Exception {
		orderRepository.save(customer.newOrder("CUST-01-ORDER-01")
								.with("상품1", 5)
								.with("상품2", 20));
		Order order = orderRepository.findByOrderId("CUST-01-ORDER-01");
		
		orderRepository.deleteByOrderId("CUST-01-ORDER-01");
		
		assertNull(orderRepository.findByOrderId("CUST-01-ORDER-01"));
		assertNotNull(order);
	}
}
