package com.carrot.backend.board.controller;

import com.carrot.backend.board.domain.Board;
import com.carrot.backend.board.dto.BoardDto;
import com.carrot.backend.board.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board")
    public List<Board> getBoards(){
        return boardService.getBoards();
    }
    @GetMapping("/board/{boardId}")
    public Board getBoard(@PathVariable Integer boardId){
        return boardService.getBoard(boardId);
    }

    @PostMapping("/createBoard")
    public Board createBoard(@RequestBody BoardDto boardDto){
        Integer id = boardService.createBoard(boardDto);

        return boardService.getBoard(id);
    }

//    @PostMapping("/createBoardImages")
//    public Board createBoardImages(){
//
//    }

}
