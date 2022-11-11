package com.carrot.backend.chatting.controller;

import com.carrot.backend.chatting.domain.ChattingRoom;
import com.carrot.backend.chatting.service.ChattingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatController {
    private final ChattingService chattingService;
//https://ws-pace.tistory.com/105
    //https://velog.io/@ehdrms2034/Spring-boot-React%EB%A1%9C-%EA%B0%84%EB%8B%A8%ED%95%9C-%EC%B1%84%ED%8C%85%EB%B0%A9-%EC%A0%9C%EC%9E%91%ED%95%98%EA%B8%B0
    //스프링부트 +리액트 채팅기능 검색

    //nosql 몽고DB 사용해서 채팅구현할것,
    @PostMapping
    public ChattingRoom createRoom(@RequestParam String name){
        return chattingService.createRoom(name);
    }

    @GetMapping
    public List<ChattingRoom> findAllRoom(){
        return chattingService.findAllRoom();
    }
}
