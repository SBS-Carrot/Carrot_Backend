package com.carrot.backend.chatting.controller;

import com.carrot.backend.chatting.domain.Chatting;
import com.carrot.backend.chatting.domain.ChattingRoom;
import com.carrot.backend.chatting.service.ChattingService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class ChatController {
    private final SimpMessagingTemplate simpMessagingTemplate;
    private final ChattingService chattingService;

    private static final Set<String> SESSION_IDS = new HashSet<>();
//https://ws-pace.tistory.com/105
    //https://velog.io/@ehdrms2034/Spring-boot-React%EB%A1%9C-%EA%B0%84%EB%8B%A8%ED%95%9C-%EC%B1%84%ED%8C%85%EB%B0%A9-%EC%A0%9C%EC%9E%91%ED%95%98%EA%B8%B0
    //스프링부트 +리액트 채팅기능 검색

    //nosql 몽고DB 사용해서 채팅구현할것,


    @MessageMapping("/chat")

    public Chatting sendMessage(Chatting chatting, SimpMessageHeaderAccessor accessor){
        System.out.println(chatting.getRoomId());


        simpMessagingTemplate.convertAndSend("/sub/chat/1"
//                +chatting.getRoomId()
                ,chatting);
        return chatting;
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

//    @EventListener(SessionConnectEvent.class)
//    public void onConnect(SessionConnectEvent event){
//        String sessionId = event.getMessage().getHeaders().get("simSessionId").toString();
//        SESSION_IDS.add(sessionId);
//        System.out.println("[connect] connections : {}" + SESSION_IDS.size());
//    }
//
//    @EventListener(SessionConnectEvent.class)
//    public void onDisConnect(SessionConnectEvent event){
//        String sessionId = event.getMessage().getHeaders().get("simSessionId").toString();
//        SESSION_IDS.remove(sessionId);
//        System.out.println("[disconnect] connections : {}" + SESSION_IDS.size());
//    }
    //특정 채팅방 조회
    @GetMapping("/room/{roomId}")
    public ChattingRoom roomInfo(@PathVariable String roomId){
        return chattingService.findById(roomId);
    }
}
