package com.example.demo.domain.order;

import org.junit.Test;

import com.example.demo.common.Registrar;
import com.example.demo.domain.customer.Customer;
import com.example.demo.domain.customer.Money;
import com.example.demo.domain.product.Product;
import com.example.demo.domain.product.ProductRepository;

import junit.framework.TestCase;

public class OrderTest extends TestCase{
	private Customer customer;
	private OrderRepository orderRepository;
	private ProductRepository productRepository;
	
	@Override
	protected void setUp() throws Exception {
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
	
}
