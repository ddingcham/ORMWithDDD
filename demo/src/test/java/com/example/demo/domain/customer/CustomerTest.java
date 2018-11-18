package com.example.demo.domain.customer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.common.Registrar;
import com.example.demo.domain.Customer;
import com.example.demo.domain.CustomerRepository;
import com.example.demo.domain.Money;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerTest {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Test
	public void testCustomerIdentical() {
		Customer customer = new Customer("CUST-01", "홍길동", "경기도 안양시");
		customerRepository.save(customer);
		Customer anotherCustomer = customerRepository.findByCustomerNumber("CUST-01");
		assertSame(customer, anotherCustomer);
		assertThat(customer == anotherCustomer);
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

}
