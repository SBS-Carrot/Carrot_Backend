package com.carrot.backend.boardReply.service;

import com.carrot.backend.board.dao.BoardRepository;
import com.carrot.backend.board.domain.Board;
import com.carrot.backend.boardReply.dao.BoardReplyRepository;
import com.carrot.backend.boardReply.dao.CustomizedBoardReplyRepositoryImpl;
import com.carrot.backend.boardReply.domain.BoardReply;
import com.carrot.backend.boardReply.dto.BoardReplyDto;
import com.carrot.backend.user.dao.UserRepository;
import com.carrot.backend.user.domain.User;
import com.carrot.backend.util.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BoardReplyService {
    private final BoardReplyRepository boardReplyRepository;
    private final CustomizedBoardReplyRepositoryImpl customizedBoardReplyRepository;
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    public BoardReply getReply(Integer boardId) {
        return boardReplyRepository.findById(boardId).orElseThrow(() -> new DataNotFoundException("boardReply not found"));
    }

    public boolean createReply(BoardReplyDto boardReplyDto, Integer boardId) {
      try   {
        BoardReply boardReply = new BoardReply();
        Board board = boardRepository.findByBoardId(boardId).get();
        String userid = boardReplyDto.getReplyUserid();
        User user = userRepository.findByUserid(userid).get();
        LocalDateTime date = LocalDateTime.now();
        String dates = date.toString();
        String yymmdd = dates.substring(0,10);
        boardReply.setUser(user);
        boardReply.setReplyUserAddress(user.getAddress());
        boardReply.setProfileImage(user.getProfileImage());
        boardReply.setBoard(board);
        boardReply.setBoardReply(boardReplyDto.getBoardReply());
        boardReply.setCreateDate(yymmdd);
        boardReplyRepository.save(boardReply);
      }catch (Exception e){
          return false;
      }
        return true;
    }

    public BoardReplyDto getBoardAndReply(Integer boardId) {
        BoardReplyDto boardReplyDto = customizedBoardReplyRepository.getQslBoardAndReplyByBoardId(boardId);
        return boardReplyDto;
    }
}
