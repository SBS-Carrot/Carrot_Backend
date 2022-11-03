package com.carrot.backend.product.dao;

import com.carrot.backend.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository <Product, Integer>, CustomizedProductRepository {

//    @Query("select p from Product p join p.image i where p.id = :id")
//    public Product getP(Integer id);


}
