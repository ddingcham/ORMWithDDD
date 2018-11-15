package com.example.demo.domain.customer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.common.Registrar;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerTest {
	
	@Autowired
	private Registrar registrar;
	@Autowired
	private CustomerRepository customerRepository;
	
	@Before
	public void setUp() {
		registrar.init();
	}
	
	@Test
	public void testCustomerIdentical() {
		Customer customer = new Customer("CUST-01", "홍길동", "경기도 안양시");
		customerRepository.save(customer);
		Customer anotherCustomer = customerRepository.find("CUST-01");
		assertSame(customer, anotherCustomer);
	}
		
//	@Test
	@Deprecated
	public void testAliasing(){
		Customer customer = new Customer("CUST-01", "홍길동", "경기도 안양시");
		Customer anotherCustomer = customer;
		
		long price = 1000;
		customer.purchase(price);
		
		assertEquals(new Money(price*0.01), anotherCustomer.getMileage());
		assertEquals(0, anotherCustomer.getMileage());
	}

	public void setRegistrar(Registrar registrar) {
		this.registrar = registrar;
	}

}
