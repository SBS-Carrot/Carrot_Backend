package com.carrot.backend.boardLike.dao;

import com.carrot.backend.boardLike.domain.BoardLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardLikeRepository extends JpaRepository<BoardLike, Integer> {
}
