package com.carrot.backend.chatting.service;

import com.carrot.backend.chatting.dao.ChattingRepository;
import com.carrot.backend.chatting.dao.ChattingRoomRepository;
import com.carrot.backend.chatting.domain.Chatting;
import com.carrot.backend.chatting.domain.ChattingRoom;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChattingService {
    private final ObjectMapper objectMapper;
    private Map<String, ChattingRoom> chattingRoom;

    private final ChattingRepository chattingRepository;
    private final ChattingRoomRepository chattingRoomRepository;
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

        try {
            ChattingRoom room = chattingRoomRepository.findById(roomId).orElseThrow();
            if(room!=null){
                return room;
            }
            return null;
        }catch(Exception e){
            return null;
        }

    }

    //채팅방 생성
    public ChattingRoom createRoom(String roomId,String myname,String yourName){

        ChattingRoom room = ChattingRoom.builder()
                        .roomId(roomId)
                        .myName(myname)
                .yourName(yourName)
                        .build();
        chattingRoom.put(roomId, room);
        chattingRoomRepository.save(room);

        return room;
    }

    public Chatting saveChat(Chatting chatting){
        Chatting chat = new Chatting();
        chat.setMessage(chatting.getMessage());
        chat.setRoomId(chatting.getRoomId());
        chat.setType(chatting.getType());
        chat.setSender(chatting.getSender());
        chattingRepository.save(chat);
        return chat;
    }

    public ChattingRoom findByUser(String myName, String yourName) {
        ChattingRoom room = chattingRoomRepository.findByMyNameAndYourName(myName,yourName);
        return room;
    }

    public List<Chatting> getMessage(String roomId) {
       return chattingRepository.findByRoomId(roomId);
    }

//    public List<ChattingRoom> findAllRoomByUser(String userid) {
//        List<ChattingRoom> rooms = chattingRoomRepository.
//    }
}
