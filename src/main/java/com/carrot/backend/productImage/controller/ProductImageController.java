package com.carrot.backend.productImage.controller;

import com.carrot.backend.product.Service.ProductService;
import com.carrot.backend.product.domain.Product;
import com.carrot.backend.productImage.Service.ProductImageService;
import com.carrot.backend.productImage.dto.ProductImageDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@AllArgsConstructor
public class ProductImageController {
    private final ProductService productService;
    private final ProductImageService productImageService;

    @PostMapping("/createProductImages")
    public Optional<Product> createImages(@RequestParam long id, @RequestBody ProductImageDto productImageDto){
        System.out.println("id:"+ id);
        System.out.println("path:"+ productImageDto.getPath());
        productImageService.createProductImage(id,productImageDto.getPath());
        return productService.getProduct(productImageDto.getProductId());
    }
}
