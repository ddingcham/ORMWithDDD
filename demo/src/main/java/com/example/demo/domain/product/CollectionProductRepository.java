package com.example.demo.domain.product;

import com.example.demo.common.Registrar;

public class CollectionProductRepository implements ProductRepository{

	@Override
	public void save(Product product) {
		// TODO Auto-generated method stub
		Registrar.add(Product.class, product);
	}

	@Override
	public Product find(String identity) {
		// TODO Auto-generated method stub
		return (Product)Registrar.get(Product.class, identity);
	}
}
