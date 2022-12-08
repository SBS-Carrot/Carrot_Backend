package com.carrot.backend.boardLike.service;

import com.carrot.backend.board.dao.BoardRepository;
import com.carrot.backend.boardLike.dao.BoardLikeRepository;
import com.carrot.backend.user.dao.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class BoardLikeService {
    private final BoardRepository boardRepository;
    private final BoardLikeRepository boardLikeRepository;
    private final UserRepository userRepository;


}
