package com.carrot.backend.realty.dao;

import com.carrot.backend.realty.domain.Realty;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomizedRealtyRepositoryImpl implements CustomizedRealtyRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Realty getQslRealty(Integer id) {
        return null;
    }
}
