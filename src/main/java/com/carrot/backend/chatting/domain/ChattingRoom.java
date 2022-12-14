package com.carrot.backend.chatting.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ChattingRoom {
    @Id
    private String roomId;
    private String myName;

    private String yourName;



    @Builder
    public ChattingRoom(String roomId,String myName, String yourName){
        this.myName=myName;
        this.yourName=yourName;
        this.roomId=roomId;

    }


}
