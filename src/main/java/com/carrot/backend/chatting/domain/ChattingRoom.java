package com.carrot.backend.chatting.domain;

import com.carrot.backend.chatting.service.ChattingService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class ChattingRoom {
    private String roomId;
    private String roomName;
    private Set<WebSocketSession> sessions = new HashSet<>();


    public static ChattingRoom create(String name){
      ChattingRoom room = new ChattingRoom();
      room.roomId = UUID.randomUUID().toString();
      room.roomName= name;
      return room;
    }

//    public void handleActions(WebSocketSession session, Chatting chatting, ChattingService chattingservice){
//        if(chatting.getMessageType().equals(Chatting.MessageType.ENTER)){
//            sessions.add(session);
//            chatting.setMessage(chatting.getSender() + "님이 입장했습니다.");
//        }
//        sendChatting(chatting, chattingservice);
//    }

    public <T> void sendChatting(T chatting, ChattingService chattingService){
        sessions.parallelStream().forEach(session -> chattingService.sendChatting(session,chatting));
    }
}
