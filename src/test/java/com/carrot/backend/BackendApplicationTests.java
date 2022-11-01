package com.carrot.backend;

import com.carrot.backend.product.dao.ProductRepository;
import com.carrot.backend.product.domain.Product;
import com.carrot.backend.product.domain.QProduct;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
class BackendApplicationTests {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	EntityManager entityManager;

	@Test
	void test(){
		Product product = new Product();
		entityManager.persist(product);

		JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
		QProduct qProduct = new QProduct("p");
		Product found = queryFactory.selectFrom(qProduct).fetchOne();

		assertEquals(found, product);
	}

}
