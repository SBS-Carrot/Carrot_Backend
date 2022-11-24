package com.carrot.backend.chatting.Dto;

import lombok.Data;

@Data
public class ChattingDto {


    private String roomId;
    private String sender;
    private String message;
}
