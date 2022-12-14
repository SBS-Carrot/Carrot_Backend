package com.carrot.backend.chatting.dao;

import com.carrot.backend.chatting.domain.ChattingRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChattingRoomRepository extends JpaRepository<ChattingRoom, String> {
    ChattingRoom findByMyNameAndYourName(String myName, String yourName);

    List<ChattingRoom> findByMyNameOrYourNameContaining(String myName,String yourName);

}
