package com.carrot.backend.product.dao;

import com.carrot.backend.product.domain.Product;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.carrot.backend.product.domain.QProduct.product;

@RequiredArgsConstructor
public class CustomizedProductRepositoryImpl implements CustomizedProductRepository{
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Product getQslProduct(Integer id) {
        return jpaQueryFactory.select(product)
                .from(product)
                .where(product.productId.eq(1))
                .fetchOne();
    }

    @Override
    public List<Tuple> getQslProductsAndImagesByProductId(Integer productId){

        return jpaQueryFactory
                .select(product,product.images)
                .from(product)
                .innerJoin(product.images)
                .on(product.productId.eq(productId))
                .fetch();

    }

}
