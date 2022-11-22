package com.carrot.backend.chatting.domain;

import com.carrot.backend.chatting.service.ChattingService;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class ChattingRoom {
    private String roomId;
    private String name;
    private Set<WebSocketSession> sessions = new HashSet<>();

    @Builder
    public ChattingRoom(String roomId, String name){
        this.roomId=roomId;
        this.name=name;
    }

    public void handleActions(WebSocketSession session, Chatting chatting, ChattingService chattingservice){
        if(chatting.getMessageType().equals(Chatting.MessageType.ENTER)){
            sessions.add(session);
            chatting.setMessage(chatting.getSender() + "님이 입장했습니다.");
        }
        sendChatting(chatting, chattingservice);
    }

    public <T> void sendChatting(T chatting, ChattingService chattingService){
        sessions.parallelStream().forEach(session -> chattingService.sendChatting(session,chatting));
    }
}
