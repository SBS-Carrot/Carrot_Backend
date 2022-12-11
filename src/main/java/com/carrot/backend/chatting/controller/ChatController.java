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


    //nosql 몽고DB 사용해서 채팅구현할것,


    @MessageMapping("/chat")
    public Chatting sendMessage(Chatting chatting, SimpMessageHeaderAccessor accessor){
        String roomNum = chatting.getRoomId();
        Chatting chats = chattingService.saveChat(chatting);
        simpMessagingTemplate.convertAndSend("/sub/chat/" +roomNum, chats);
        return chats;
    }

    //채팅방 생성
    @PostMapping("/chat")
    public ChattingRoom createRoom(@RequestBody ChattingRoom chattingRoom){

        String myname = chattingRoom.getMyName();
        String yourName = chattingRoom.getYourName();
        String roomId = chattingRoom.getRoomId();
        return chattingService.createRoom(roomId,myname,yourName);

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

    @GetMapping("/getChattingRoom")
    public ChattingRoom findRoom(@RequestParam String myName, @RequestParam String yourName){
        ChattingRoom room = chattingService.findByUser(myName,yourName);
        return room;

    }

    @GetMapping("/getMessage")
    public List<Chatting> getMessages(@RequestParam String roomId){
        List<Chatting> messages = chattingService.getMessage(roomId);
        return messages;
    }




}
