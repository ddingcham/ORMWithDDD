package com.example.demo.domain.product;

public interface ProductRepository {
	public void save(Product product);
	public Product find(String productName);
}
