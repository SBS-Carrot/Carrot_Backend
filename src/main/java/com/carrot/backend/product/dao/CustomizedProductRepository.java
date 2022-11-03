package com.carrot.backend.product.dao;

import com.carrot.backend.product.domain.Product;

public interface CustomizedProductRepository {

    Product getQslProduct(Integer id);
}
