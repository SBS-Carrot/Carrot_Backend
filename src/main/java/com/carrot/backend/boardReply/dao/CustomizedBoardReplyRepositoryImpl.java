package com.carrot.backend.boardReply.dao;

import com.carrot.backend.board.domain.QBoard;
import com.carrot.backend.boardReply.domain.BoardReply;
import com.carrot.backend.boardReply.domain.QBoardReply;
import com.carrot.backend.boardReply.dto.BoardReplyDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomizedBoardReplyRepositoryImpl implements CustomizedBoardReplyRepository {
    private final JPAQueryFactory jpaQueryFactory;
    @Override
    public BoardReplyDto getQslBoardAndReplyByBoardId(Integer boardId) {

        BoardReply boardReply = jpaQueryFactory
                .select(QBoardReply.boardReply1)
                .from(QBoardReply.boardReply1)
                .innerJoin(QBoard.board)
                .on(QBoardReply.boardReply1.id.eq(boardId))
                .fetchOne();

return  null;


    }
}
