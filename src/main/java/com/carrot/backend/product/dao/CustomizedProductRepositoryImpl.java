package com.carrot.backend.product.dao;

import com.carrot.backend.product.domain.QProduct;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomizedProductRepositoryImpl implements CustomizedProductRepository{
    private final JPAQueryFactory jpaQueryFactory;

    QProduct qProduct = new QProduct("p");


}
