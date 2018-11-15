package com.example.demo.domain.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.example.demo.domain.customer.Money;
import com.example.demo.domain.product.Product;
import com.example.demo.domain.product.ProductRepository;

@Configurable(value="orderLineItem", preConstruction=true)
public class OrderLineItem {
	
	private Product product;
	private int quantity;
	
	@Autowired
	private ProductRepository productRepository;

	public OrderLineItem(){};
	
	public OrderLineItem(String productName, int quantity) {
		// TODO Auto-generated constructor stub
		this.product = productRepository.find(productName);
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

	
}
