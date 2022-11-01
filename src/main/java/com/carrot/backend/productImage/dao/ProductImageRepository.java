package com.carrot.backend.productImage.dao;

import com.carrot.backend.productImage.domain.ProductImages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImageRepository extends JpaRepository <ProductImages,Long> {

}
