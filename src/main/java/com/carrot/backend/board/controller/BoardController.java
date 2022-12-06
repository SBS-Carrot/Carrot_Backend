package com.carrot.backend.board.controller;

import com.carrot.backend.board.domain.Board;
import com.carrot.backend.board.dto.BoardDto;
import com.carrot.backend.board.service.BoardService;
import com.carrot.backend.boardImage.service.BoardImageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final BoardImageService boardImageService;

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

    @PostMapping("/createBoardImages")
    public Board createBoardImages(@RequestPart(value = "boardDto") BoardDto boardDto, @RequestPart(value = "file") List<MultipartFile> multipartFile) throws IOException {
        Integer id = boardService.createBoard(boardDto);
        boardImageService.uploads(id,multipartFile, "board" );

        return boardService.getBoard(id);
    }
    @GetMapping("/getBoardWithImage/{boardId}")
    public BoardDto getBoardWithImage(@PathVariable Integer boardId) {
        return boardService.getBoardWithImage(boardId);
    }



}
