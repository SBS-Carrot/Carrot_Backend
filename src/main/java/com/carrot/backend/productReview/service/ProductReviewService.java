package com.carrot.backend.productReview.service;

import com.carrot.backend.product.dao.ProductRepository;
import com.carrot.backend.product.domain.Product;
import com.carrot.backend.productReview.dao.ProductReviewRepository;
import com.carrot.backend.productReview.domain.ProductReview;
import com.carrot.backend.productReview.dto.ProductReviewDto;
import com.carrot.backend.user.dao.UserRepository;
import com.carrot.backend.user.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class ProductReviewService {
    private final ProductReviewRepository productReviewRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public ProductReview addReview(ProductReviewDto productReviewDto) {
        ProductReview productReview = new ProductReview();

        String userid = productReviewDto.getSellUserId();
        User sellUser = userRepository.findByUserid(userid).get();
        productReview.setSellUser(sellUser);
        User buyUser = userRepository.findByUserid(productReviewDto.getBuyUserId()).get();
        productReview.setBuyUser(buyUser);

        productReview.setProductReview(productReviewDto.getProductReview());
        Product product = productRepository.findByProductId(productReviewDto.getProductId()).get();
        product.setProductBuyUserid(productReviewDto.getBuyUserId());
        productReview.setProduct(product);
        product.setProductDeal("거래 완료");

        productReview.setResReview(buyUser);
        productReview.setReqReview(sellUser);

        productRepository.save(product);
        if(productReview.getProductReview().equals("별로예요")){
            buyUser.setTemp(buyUser.getTemp() - 0.5);

        }else if(productReview.getProductReview().equals("좋아요")){
            buyUser.setTemp(buyUser.getTemp() + 0.5);

        }else if(productReview.getProductReview().equals("최고예요")){
            buyUser.setTemp(buyUser.getTemp() + 1);

        }
        userRepository.save(buyUser);

        return productReviewRepository.save(productReview);
    }

    public ProductReview addBuyReview(ProductReviewDto productReviewDto) {
        ProductReview productReview = new ProductReview();

        String userid = productReviewDto.getSellUserId();
        User sellUser = userRepository.findByUserid(userid).get();
        productReview.setSellUser(sellUser);
        User buyUser = userRepository.findByUserid(productReviewDto.getBuyUserId()).get();
        productReview.setBuyUser(buyUser);

        productReview.setProductReview(productReviewDto.getProductReview());
        Product product = productRepository.findByProductId(productReviewDto.getProductId()).get();
        productReview.setProduct(product);

        product.setReviewFinished(true);
        productReview.setReqReview(buyUser);
        productReview.setResReview(sellUser);

        if(productReview.getProductReview().equals("별로예요")){
            buyUser.setTemp(buyUser.getTemp() - 0.5);

        }else if(productReview.getProductReview().equals("좋아요")){
            buyUser.setTemp(buyUser.getTemp() + 0.5);

        }else if(productReview.getProductReview().equals("최고예요")){
            buyUser.setTemp(buyUser.getTemp() + 1);

        }
        userRepository.save(buyUser);

        return productReviewRepository.save(productReview);
    }
}
