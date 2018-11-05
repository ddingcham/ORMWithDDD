package com.example.demo.domain.customer;

import java.math.BigDecimal;

public class Money {
	private BigDecimal amount;
	
	public Money(BigDecimal amount) {
		this.amount = amount;
	}
	
	public Money(long amount) {
		this(new BigDecimal(amount));
	}
	
	public Money add(Money added){
		this.amount = this.amount.add(added.amount);
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Money [amount=" + amount + "]";
	}
	
	

}
