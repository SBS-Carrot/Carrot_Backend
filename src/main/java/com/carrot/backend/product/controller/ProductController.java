package com.carrot.backend.product.controller;

import com.carrot.backend.product.Service.ProductService;
import com.carrot.backend.product.domain.Product;
import com.carrot.backend.product.dto.ProductDto;
import com.carrot.backend.productImage.Service.ProductImageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;


    @GetMapping("")
    public List<Product> getProducts(){
        return productService.getProducts();
    }
    @GetMapping("/product/{productId}")
    public Optional<Product> getProduct(@PathVariable Long productId){
        return productService.getProduct(productId);
    }

    @PostMapping("/createProduct")
    public Optional<Product> createProduct(@RequestBody ProductDto productDto){
        Long id = productService.createProduct(productDto);
        return productService.getProduct(id);
    }



}
