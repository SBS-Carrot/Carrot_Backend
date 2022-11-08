package com.carrot.backend;

import com.carrot.backend.product.dao.ProductRepository;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

@SpringBootTest
class BackendApplicationTests {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	EntityManager entityManager;

	@Test
	@DisplayName("Test")
	void t1(){
//		password("{noop}1234") 암호화 안했다는 관례적 표시

//		productRepository.saveAll(Arrays.asList(p1,p2));
	}
}
