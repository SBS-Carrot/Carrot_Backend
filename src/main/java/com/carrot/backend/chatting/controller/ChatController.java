package com.carrot.backend.chatting.controller;

import com.carrot.backend.chatting.Dto.ChattingDto;
import com.carrot.backend.chatting.domain.ChattingRoom;
import com.carrot.backend.chatting.service.ChattingService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChatController {
    private final SimpMessagingTemplate simpMessagingTemplate;
    private final ChattingService chattingService;
//https://ws-pace.tistory.com/105
    //https://velog.io/@ehdrms2034/Spring-boot-React%EB%A1%9C-%EA%B0%84%EB%8B%A8%ED%95%9C-%EC%B1%84%ED%8C%85%EB%B0%A9-%EC%A0%9C%EC%9E%91%ED%95%98%EA%B8%B0
    //스프링부트 +리액트 채팅기능 검색

    //nosql 몽고DB 사용해서 채팅구현할것,


    @MessageMapping("/chat")
    public void sendMessage(ChattingDto chattingDto, SimpMessageHeaderAccessor accessor){
        System.out.println(chattingDto.getRoomId());


        simpMessagingTemplate.convertAndSend("/sub/ws/"+chattingDto.getRoomId(),chattingDto);
    }

    //채팅방 생성
    @PostMapping("/chat")
    public ChattingRoom createRoom(@RequestBody String name){
        String[] names = name.split(":");
        return chattingService.createRoom(names[1].substring(1,names[1].length()-2));
    }

    //모든 채팅방 목록 반환
    @GetMapping("/chat")
    public List<ChattingRoom> findAllRoom(){
        return chattingService.findAllRoom();
    }

    //채팅 리스트 화면
    public String rooms(Model model){
        return "";
    }

    //채팅방 입장 화면
    @GetMapping("/room/enter/{roomId}")
    public String roomDetail (Model model, @PathVariable String roomId){
        model.addAttribute("roomId",roomId);
        return "";
    }

    //특정 채팅방 조회
    @GetMapping("/room/{roomId}")
    public ChattingRoom roomInfo(@PathVariable String roomId){
        return chattingService.findById(roomId);
    }
}
