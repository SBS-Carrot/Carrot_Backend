package com.carrot.backend.board.domain;

import com.carrot.backend.boardImage.domain.BoardImage;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

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
    String boardCategory;

    @Column
    Integer boardChattingNum;

    @Column
    Integer boardAgree;

    @Column
    String boardAddress;

    String createDate;

    @Column
    String profileImage;

    @Column
    Integer boardView;

    @OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<BoardImage> images;
}


