package com.carrot.backend.board.dao;

import com.carrot.backend.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Integer> , CustomizedBoardRepository{
}
