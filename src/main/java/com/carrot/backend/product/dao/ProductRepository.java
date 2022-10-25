package com.carrot.backend.product.dao;

import com.carrot.backend.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ProductRepository extends JpaRepository <Product, String> {

}
