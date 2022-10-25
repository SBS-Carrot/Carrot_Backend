package com.carrot.backend.productImage.Service;

import com.carrot.backend.product.dao.ProductRepository;
import com.carrot.backend.product.domain.Product;
import com.carrot.backend.productImage.dao.ProductImageRepository;
import com.carrot.backend.productImage.domain.ProductImages;
import com.carrot.backend.productImage.dto.ProductImageDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductImageService {
    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;


    public void createProductImage(long id, String path){
        ProductImages newImages = new ProductImages();
        newImages.setProductId(id);
        newImages.setPath(path);
//        productImageRepository.save(newImages);
    }
}
