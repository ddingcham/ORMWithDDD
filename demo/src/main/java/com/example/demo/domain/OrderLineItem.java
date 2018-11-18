package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

@Entity
@Configurable(autowire=Autowire.BY_NAME, preConstruction=true, value="orderLineItem")
public class OrderLineItem {
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	private Product product;
	private int quantity;
	
	@Autowired
	@Transient
	ProductRepository productRepository;

	public OrderLineItem(){}
	
	public OrderLineItem(String productName, int quantity) {
		// TODO Auto-generated constructor stub
		this.product = productRepository.findByName(productName);
		this.quantity = quantity;
	}
	
	public Money getPrice() {
		return product.getPrice().multiply(quantity);
	}
	
	public Product getProduct() {
		return product;
	}	
	
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	int getQuantity() {
		return quantity;
	}
	
	public boolean equals(Object object) {
		if (object == this) {
			return true;
		}
		if (!(object instanceof OrderLineItem)) {
			return false;
		}
		
		final OrderLineItem other = (OrderLineItem)object;
		return this.product.equals(other.getProduct())
				&& this.quantity == other.getQuantity();
	}

	public int hashCode() {
		int result = 17;
		result = 37*result + product.hashCode();
		result = 37*result + quantity;
		return result;
	}

	public Long getId() {
		return id;
	}
	
	
}
