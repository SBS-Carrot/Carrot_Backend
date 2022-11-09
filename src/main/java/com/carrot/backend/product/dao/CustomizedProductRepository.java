package com.carrot.backend.product.dao;

import com.carrot.backend.product.domain.Product;
import com.querydsl.core.Tuple;

import java.util.List;


public interface CustomizedProductRepository {


    Product getQslProduct(Integer id);

    List<Tuple> getQslProductsAndImagesByProductId(Integer productId);
}

