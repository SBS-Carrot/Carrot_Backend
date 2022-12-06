package com.carrot.backend.boardImage.dao;

import com.carrot.backend.boardImage.domain.BoardImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardImageRepository extends JpaRepository<BoardImage, Long> {
}
