package com.carrot.backend.product.controller;

import com.carrot.backend.product.Service.ProductService;
import com.carrot.backend.product.domain.Product;
import com.carrot.backend.product.dto.ProductDto;
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
    public Optional<Product> getProduct(@PathVariable String productId){
        return productService.getProduct(productId);
    }

    @PostMapping("/createProduct")
    public List<Product> createProduct(@RequestBody ProductDto productDto){

        productService.createProduct(productDto);
        return productService.getProducts();
    }
}
