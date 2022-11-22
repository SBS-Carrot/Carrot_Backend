package com.carrot.backend.chatting.service;

import com.carrot.backend.chatting.domain.ChattingRoom;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChattingService {
    private final ObjectMapper objectMapper;
    private Map<String, ChattingRoom> chattingRoom;
    @PostConstruct
    private void init(){
        chattingRoom = new LinkedHashMap<>();
    }

    public List<ChattingRoom> findAllRoom(){
        return new ArrayList<>(chattingRoom.values());
    }

    public ChattingRoom findById(String roomId){
        return chattingRoom.get(roomId);
    }

    public ChattingRoom createRoom(String name){
        String randomId = UUID.randomUUID().toString();

        ChattingRoom rooms = ChattingRoom.builder().roomId(randomId).name(name).build();
        chattingRoom.put(randomId,rooms);
        return rooms;
    }

    public <T> void sendChatting(WebSocketSession session, T message){
        try{
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(message)));
        }catch(IOException e){
            log.error(e.getMessage(),e);
        }
    }
}
