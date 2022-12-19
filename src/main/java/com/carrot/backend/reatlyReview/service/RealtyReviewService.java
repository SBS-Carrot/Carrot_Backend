package com.carrot.backend.reatlyReview.service;

import com.carrot.backend.realty.dao.RealtyRepository;
import com.carrot.backend.realty.domain.Realty;
import com.carrot.backend.reatlyReview.dao.RealtyReviewRepository;
import com.carrot.backend.reatlyReview.domain.RealtyReview;
import com.carrot.backend.reatlyReview.dto.RealtyReviewDto;
import com.carrot.backend.user.dao.UserRepository;
import com.carrot.backend.user.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class RealtyReviewService {
    private final RealtyRepository realtyRepository;
    private  final RealtyReviewRepository realtyReviewRepository;
    private final UserRepository userRepository;
    public RealtyReview addRealtyReview(RealtyReviewDto realtyReviewDto) {
        RealtyReview review = new RealtyReview();

        review.setRealtyReview(realtyReviewDto.getRealtyReview());
        Realty realty = realtyRepository.findByRealtyId(realtyReviewDto.getRealtyId()).get();
        review.setRealty(realty);
        realty.setRealtyDeal("거래 완료");

        String userid = realtyReviewDto.getSellUserId();
        User sellUser = userRepository.findByUserid(userid).get();
        review.setSellUser(sellUser);
        User buyUser = userRepository.findByUserid(realtyReviewDto.getBuyUserId()).get();
        review.setBuyUser(buyUser);

        if(review.getRealtyReview().equals("별로예요")){
            buyUser.setTemp(buyUser.getTemp() - 0.5);
        }else if(review.getRealtyReview().equals("좋아요")){
            buyUser.setTemp(buyUser.getTemp() + 0.5);
        }else if(review.getRealtyReview().equals("최고예요")){
            buyUser.setTemp(buyUser.getTemp() + 1);
        }
        userRepository.save(buyUser);

        return realtyReviewRepository.save(review);
    }
}
