package com.example.demo.domain.customer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.demo.domain.Money;

public class MoneyTest {

	@Test
	public void testMethodAliasing() {
		Money money = new Money(2000);
		doSomethingWithMoney(money);
		assertEquals(new Money(2000), money);
	}
	
	private void doSomethingWithMoney(final Money money) {
		money.add(new Money(2000));
	}
	
}
