package com.carrot.backend.realty.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RealtyDto {
    Integer realtyId;

    String realtyUserid;

    LocalDateTime createDate;

    String realtyWho;

    String realtyDealing;

    String realtyDeposit;

    String realtyMonthly;

    String realtyShortTerm;

    String realtyChangePrice;

    String realtyDepositChange;

    String realtyCost;

    String realtyCostContent;

    String realtySalePrice;

    String realtyCategory;

    String realtySpace;

    String realtyArea;

    String realtyWhole;

    String realtyFloor;

    String realtyRoom;

    String realtyBath;

    String realtyAddress;

    String realtyLoan;

    String realtyMove;

    String realtyMoveDate;

    String realtyPet;

    String realtyParking;

    String realtyElevator;

    String[] realtyInside;

    String realtyShortDeal;

    String realtyMonthlyDeal;

    String realtyDepositDeal;

    String realtyDeal;

    String realtyContent;

    Integer realtyChatting;

    Integer realtyLike;

    Integer realtyCheck;

    String profileImage;

    List<String> images;


}
