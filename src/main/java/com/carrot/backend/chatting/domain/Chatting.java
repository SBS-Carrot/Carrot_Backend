package com.carrot.backend.chatting.domain;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Chatting {
    public enum MessageType{
        ENTER, TALK
    }
    private MessageType type;
    private String roomId;
    private String sender;
    private String message;


}
