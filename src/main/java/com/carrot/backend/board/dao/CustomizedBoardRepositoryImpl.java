package com.carrot.backend.board.dao;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomizedBoardRepositoryImpl  implements CustomizedBoardRepository {
    private final JPAQueryFactory jpaQueryFactory;


}
