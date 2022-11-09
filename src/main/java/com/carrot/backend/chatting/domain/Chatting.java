package com.carrot.backend.chatting.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Chatting {
    public enum MessageType{
        ENTER, COMM
    }
    private MessageType messageType;
    private String roomId;
    private String sender;
    private String message;
}
