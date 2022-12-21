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

    String realtyBuyUserId;

<<<<<<< HEAD
    String sellUserId;

=======
    String realtySellUserId;
>>>>>>> c92f703329b836ff835addc0e7d6b95b0f3b7344
    String reqReviewId;

    String resReviewId;
}
