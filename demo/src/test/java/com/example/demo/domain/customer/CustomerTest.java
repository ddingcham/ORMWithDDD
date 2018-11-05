package com.example.demo.domain.customer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

import com.example.demo.common.Registrar;

public class CustomerTest {
	
	@Before
	public void setUp() {
		Registrar.init();
	}
	
	@Test
	public void testCustomerIdentical() {
		Customer customer =
				new Customer("CUST-01", "홍길동", "경기도 안양시").persist();
		Customer anotherCustomer = Customer.find("CUST-01");
		assertSame(customer, anotherCustomer);
	}
		
//	@Test
	@Deprecated
	public void testAliasing(){
		Customer customer = new Customer("CUST-01", "홍길동", "경기도 안양시");
		Customer anotherCustomer = customer;
		
		long price = 1000;
		customer.purchase(price);
		
		assertEquals(price*0.01, anotherCustomer.getMileage(), 0.1);
		assertEquals(0, anotherCustomer.getMileage());
	}
}
