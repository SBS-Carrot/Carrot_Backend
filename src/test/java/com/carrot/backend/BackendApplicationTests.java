package com.carrot.backend;

import com.carrot.backend.product.dao.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
@SpringBootTest
class BackendApplicationTests {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	EntityManager entityManager;


}
