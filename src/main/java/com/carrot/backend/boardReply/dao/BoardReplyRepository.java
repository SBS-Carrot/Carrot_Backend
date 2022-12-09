package com.carrot.backend.boardReply.dao;

import com.carrot.backend.boardReply.domain.BoardReply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardReplyRepository extends JpaRepository<BoardReply, Integer>,CustomizedBoardReplyRepository {
}
