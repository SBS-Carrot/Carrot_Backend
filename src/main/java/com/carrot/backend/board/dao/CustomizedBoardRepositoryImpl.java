package com.carrot.backend.board.dao;

import com.carrot.backend.board.domain.Board;
import com.carrot.backend.board.domain.QBoard;
import com.carrot.backend.board.dto.BoardDto;
import com.carrot.backend.boardImage.domain.QBoardImage;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class CustomizedBoardRepositoryImpl  implements CustomizedBoardRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public BoardDto getQslBoardAndImagesByBoardId(Integer boardId) {
        Board board = jpaQueryFactory
                .select(QBoard.board)
                .from(QBoard.board)
                .innerJoin(QBoardImage.boardImage)
                .on(QBoard.board.boardId.eq(boardId))
                .fetchOne();

        List<String> imagePath = new ArrayList<>();
        board.getImages().stream().forEach(boardImage->imagePath.add(boardImage.getBoardPath()));

        BoardDto boardDto = BoardDto.builder()
                .boardAddress(board.getBoardAddress())
                .boardAgree(board.getBoardAgree())
                .boardCategory(board.getBoardCategory())
                .boardContent(board.getBoardContent())
                .boardUserid(board.getBoardUserid())
                .boardView(board.getBoardView())
                .boardId(board.getBoardId())
                .boardChattingNum(board.getBoardChattingNum())
                .createDate(board.getCreateDate())
                .profileImage(board.getProfileImage())
                .images(imagePath)
                .build();

        return boardDto;
    }


    @Override
    @Transactional
    public void deleteQslBoardAndImageByBoardId(Integer boardId) {
//        Long boards = jpaQueryFactory
//                .delete(QRealtyLike.realtyLike)
//                .where(QRealtyLike.realtyLike.realty.realtyId.eq(boardId))
//                .execute();
        Long board = jpaQueryFactory
                .delete(QBoard.board)
                .where(QBoard.board.boardId.eq(boardId))
                .execute();
    }
}
