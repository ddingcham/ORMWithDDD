package com.example.demo.domain.customer;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
	
	Customer customer;
	
	@Before
	public void setUp(){
		customer = new Customer("", "", "");
	}
	
	@Test
	public void testAliasing(){
		Customer customer = new Customer("CUST-01", "홍길동", "경기도 안양시");
		Customer anotherCustomer = customer;
		
		long price = 1000;
		customer.purchase(price);
		
		assertEquals(price*0.01, anotherCustomer.getMileage(), 0.1);
		assertEquals(0, anotherCustomer.getMileage());
	}
	
	@Test
	public void purchase(){
		long price = 0L;
		customer.purchase(price);		
	}
	
	@Test
	public void isPossibleToPayWithMileage(){
		long price = 0L;
		boolean possibleToPayWithMileage = customer.isPossibleToPayWithMileage(price);
	}
	
	@Test
	public void payWithMileage(){
		long price = 0L;
		boolean result = customer.payWithMileage(price);
	}
}
