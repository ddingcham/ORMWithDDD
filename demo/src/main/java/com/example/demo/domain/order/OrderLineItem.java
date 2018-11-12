package com.example.demo.domain.order;

import com.example.demo.domain.customer.Money;
import com.example.demo.domain.product.CollectionProductRepository;
import com.example.demo.domain.product.Product;
import com.example.demo.domain.product.ProductRepository;

public class OrderLineItem {
	
	private Product product;
	private int quantity;
	
	private ProductRepository productRepository = new CollectionProductRepository();

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

}
