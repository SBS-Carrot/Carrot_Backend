package com.carrot.backend.product.dao;

import com.carrot.backend.product.domain.Product;
import com.carrot.backend.product.domain.QProduct;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomizedProductRepositoryImpl implements CustomizedProductRepository{
    private final JPAQueryFactory jpaQueryFactory;

    QProduct qProduct = new QProduct("p");

   @Override
    public Product getProduct(Integer id){
        return null;
   }
}
