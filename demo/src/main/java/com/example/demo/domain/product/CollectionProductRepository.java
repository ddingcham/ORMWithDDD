package com.example.demo.domain.product;

import com.example.demo.common.Registrar;

public class CollectionProductRepository implements ProductRepository{
	private Registrar registrar;
	
	@Override
	public void save(Product product) {
		// TODO Auto-generated method stub
		registrar.add(Product.class, product);
	}

	@Override
	public Product find(String identity) {
		// TODO Auto-generated method stub
		return (Product)registrar.get(Product.class, identity);
	}

	public void setRegistrar(Registrar registrar) {
		this.registrar = registrar;
	}
		
}
