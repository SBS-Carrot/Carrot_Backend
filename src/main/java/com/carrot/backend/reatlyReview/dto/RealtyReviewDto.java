package com.carrot.backend.reatlyReview.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RealtyReviewDto {

    Integer id;

    String realtyReview;

    Integer realtyId;

    String buyUserId;

    String sellUserId;

    String reqReviewId;

    String resReviewId;
}
