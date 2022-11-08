package com.carrot.backend.realty.domain;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "realty")
public class Realty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer realtyid;

    @Column
    String realtyUserid;

    LocalDateTime createDate;

    @Column
    String realtyWho;

    @Column
    String realtyDeal;

    @Column
    String realtyCategory;

    @Column
    Integer realtySpace;

    @Column
    Integer realtyArea;

    @Column
    Integer realtyWhole;

    @Column
    Integer realtyFloor;

    @Column
    Integer realtyRoom;

    @Column
    Integer realtyBath;

    @Column
    @NotEmpty
    String realtyAddress;

    @Column
    String realtyLoan;

    @Column
    String realtyMove;

    @Column
    String realtyMoveDate;

    @Column
    String realtyPet;

    @Column
    String realtyParking;

    @Column
    String realtyElevator;

    @Column
    String realtyInside;

    @Column(length = 200)
    @NotEmpty
    String realtyContent;

    @Column
    Integer realtyChatting;

    @Column
    Integer realtyLike;

    @Column
    Integer realtyCheck;


}
