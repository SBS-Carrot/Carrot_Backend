package com.carrot.backend.board.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer boardId;

    @Column
    String boardUserid;

    @Column
    String boardContent;

    @Column
    String boardChatting;

    @Column
    String boardAgree;

    String createDate;
}


