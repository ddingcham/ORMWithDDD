package com.example.demo.domain;

import java.math.BigDecimal;

import javax.persistence.Embeddable;

@Embeddable
public class Money {
	private BigDecimal amount;
	
	public Money(){}
	
	public Money(BigDecimal amount) {
		this.amount = amount;
	}
	
	public Money(long amount) {
		this(new BigDecimal(amount));
	}
	
	public Money(double amount) {
		this(new BigDecimal(amount));
	}
	
	public Money add(Money added){
		return new Money(this.amount.add(added.amount));
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

	public boolean isGreaterThan(Money limitPrice) {
		// TODO Auto-generated method stub
		return false;
	}

	public Money subtract(Money subtrahend) {
		// TODO Auto-generated method stub
		return new Money(this.amount.subtract(subtrahend.amount));
	}

	public Money multiply(int quantity) {
		// TODO Auto-generated method stub
		return new Money(this.amount.multiply(new BigDecimal(quantity)));
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	

}
