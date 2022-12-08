package com.carrot.backend.board.dao;

import com.carrot.backend.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer> , CustomizedBoardRepository{
    List<Board> findAllByBoardCategory(String boardCategory);
}
