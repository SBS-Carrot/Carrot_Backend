package com.carrot.backend.board.controller;

import com.carrot.backend.board.domain.Board;
import com.carrot.backend.board.dto.BoardDto;
import com.carrot.backend.board.service.BoardService;
import com.carrot.backend.boardImage.service.BoardImageService;
import com.carrot.backend.boardReply.dto.BoardReplyDto;
import com.carrot.backend.boardReply.service.BoardReplyService;
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

    private final BoardReplyService boardReplyService;

    @GetMapping("/board")
    public List<Board> getBoards(){
        return boardService.getBoards();
    }
    @GetMapping("/boards")
    public List<Board> getCateBoards(@RequestParam(value = "num") Integer num){
        System.out.println("num" + num);
        return boardService.getBoardCate(num);
    }

    @GetMapping("/Qboards")
    public List<Board> getQueBoards(@RequestParam(value = "qnum") Integer qnum){
        System.out.println("Qnum" + qnum);
        return boardService.getQueBoard(qnum);
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

//  BoardReply
    @GetMapping("/getBoardReply/{boardId}")
    public List<BoardReplyDto> getBoardAndReply(@PathVariable Integer boardId){
        return boardReplyService.getBoardAndReply(boardId);
    }
    @PostMapping("/boardCreateReply/{boardId}")
    public boolean boardReply(@PathVariable Integer boardId, @RequestBody BoardReplyDto boardReplyDto ) {
        boolean id = boardReplyService.createReply(boardReplyDto, boardId);
        return  id;
    }

    @PostMapping("/boardView/{boardId}")
    public void boardView(@PathVariable Integer boardId){boardService.boardView(boardId);
    }


}
