package com.carrot.backend.chatting.controller;

import com.carrot.backend.chatting.domain.Chatting;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MessageController {
    private final SimpMessageSendingOperations sendingOperations;

    @MessageMapping("/chat/message")
    public void enter(Chatting chatting){
        if(Chatting.MessageType.ENTER.equals(chatting.getMessageType())){
            chatting.setMessage(chatting.getSender() + "님이 입장하였습니다.");
        }
        sendingOperations.convertAndSend("/topic/chat/room/" + chatting.getRoomId(),chatting);
    }
}
