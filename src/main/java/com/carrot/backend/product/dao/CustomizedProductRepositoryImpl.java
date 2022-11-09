package com.carrot.backend.product.dao;

import com.carrot.backend.product.domain.Product;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import static com.carrot.backend.product.domain.QProduct.product;

@RequiredArgsConstructor
public class CustomizedProductRepositoryImpl implements CustomizedProductRepository{
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Product getQslProduct(Integer id) {
        return jpaQueryFactory.select(product)
                .from(product)
                .where(product.productId.eq(1))
                .fetchOne();
    }

//    @Override
//    public List<Product> getQslProductsAndImagesByProductId(Integer productId){
//        return jpaQueryFactory
//                .selectFrom(product)
//                .innerJoin(QProductImages.productImages)
//                .on(QProductImages.productImages.product.eq(product))
//                .where(product.productId.eq(productId));
//    }

}
