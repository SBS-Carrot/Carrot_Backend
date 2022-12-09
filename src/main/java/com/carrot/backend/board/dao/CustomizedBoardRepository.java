package com.carrot.backend.board.dao;

import com.carrot.backend.board.dto.BoardDto;

public interface CustomizedBoardRepository {

    BoardDto getQslBoardAndImagesByBoardId(Integer boardId);

}
