package com.example.demo.domain.product;

import static org.junit.Assert.assertSame;

import javax.annotation.Resource;
import javax.annotation.Resources;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.common.Registrar;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTest {
	@Autowired
	private Registrar registrar;
	@Autowired
	private ProductRepository productRepository;
	
	public void setRegistrar(Registrar registrar) {
		this.registrar = registrar;
	}
	
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@Before
	public void setUp(){
		registrar.init();
	}
	
	@Test
	public void testProductSave() throws Exception {
		Product saveProduct = new Product("상품1", 1000);
		productRepository.save(saveProduct);
		
		assertSame(saveProduct, productRepository.find("상품1"));
	}
	
	
	
	
}
