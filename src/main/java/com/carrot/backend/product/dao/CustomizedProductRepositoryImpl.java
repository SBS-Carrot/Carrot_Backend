package com.carrot.backend.product.dao;

import com.carrot.backend.product.domain.Product;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomizedProductRepositoryImpl implements CustomizedProductRepository{
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Product getQslProduct(Integer id){
        return null;
    }

}
