package com.carrot.backend.chatting.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Chatting {
//    public enum MessageType{
//        ENTER, TALK
//    }
    private String type;
    private String roomId;
    private String sender;
    private String receiver;
    private String message;

    public void setSender(String sender){
        this.sender = sender;
    }
    public void newConnect(){
        this.type="new";
    }
    public void closeConnect(){
        this.type = "close";
    }
}
