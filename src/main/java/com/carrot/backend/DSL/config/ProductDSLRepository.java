package com.carrot.backend.DSL.config;

import com.carrot.backend.product.domain.Product;

import java.util.List;

public interface ProductDSLRepository {
    public List<Product> search(Product product);
}
