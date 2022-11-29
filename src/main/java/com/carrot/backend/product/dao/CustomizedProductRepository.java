package com.carrot.backend.product.dao;

import com.carrot.backend.product.domain.Product;
import com.carrot.backend.product.dto.ProductDto;


public interface CustomizedProductRepository {


    Product getQslProduct(Integer id);

    ProductDto getQslProductsAndImagesByProductId(Integer productId);

    void deleteQslProductAndLikeByProductId(Integer productId);


}

