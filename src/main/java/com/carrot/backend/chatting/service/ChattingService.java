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

    //채팅방 최근 생성순으로 반환
    public List<ChattingRoom> findAllRoom(){
        List<ChattingRoom> result = new ArrayList<>(chattingRoom.values());
        Collections.reverse(result);
        return result;
    }

    //채팅방 하나 반환
    public ChattingRoom findById(String roomId){
        return chattingRoom.get(roomId);
    }

    //채팅방 생성
    public ChattingRoom createRoom(String name){
        ChattingRoom room = ChattingRoom.create(name);
        chattingRoom.put(room.getRoomId(), room);

        return room;
    }

    public <T> void sendChatting(WebSocketSession session, T message){
        try{
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(message)));
        }catch(IOException e){
            log.error(e.getMessage(),e);
        }
    }
}
