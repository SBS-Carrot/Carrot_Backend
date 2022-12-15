package com.carrot.backend.chatting.dao;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomizedChattingRoomRepositoryImpl implements CustomizedChattingRoomRepository {
    private final JPAQueryFactory jpaQueryFactory;

}
