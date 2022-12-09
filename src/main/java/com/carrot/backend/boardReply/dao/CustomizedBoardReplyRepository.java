package com.carrot.backend.boardReply.dao;

import com.carrot.backend.boardReply.dto.BoardReplyDto;

public interface CustomizedBoardReplyRepository {
    BoardReplyDto getQslBoardAndReplyByBoardId(Integer boardId);
}
