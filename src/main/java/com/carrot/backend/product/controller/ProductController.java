package com.carrot.backend.product.controller;

import com.carrot.backend.product.Service.ProductService;
import com.carrot.backend.product.domain.Product;
import com.carrot.backend.product.dto.ProductDto;
import com.carrot.backend.productImage.Service.ProductImageService;
import com.carrot.backend.productImage.dto.ProductImageDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductImageService productImageService;

    @GetMapping("")
    public List<Product> getProducts(){
        return productService.getProducts();
    }
    @GetMapping("/product/{productId}")
    public Product getProduct(@PathVariable Integer productId){
        return productService.getProduct(productId);
    }

    @PostMapping("/createProduct")
    public Product createProduct(@RequestBody ProductDto productDto){
        Integer id = productService.createProduct(productDto);

        return productService.getProduct(id);
    }
    @PostMapping("/createProductImages")
    public List<ProductImageDto> createProductWithImages(@RequestBody ProductDto productDto, @RequestParam("file") List<MultipartFile> multipartFile) throws IOException {
        System.out.println(productDto.getProductContent());
        System.out.println("multipartFile  : "+multipartFile);

        Integer id = productService.createProduct(productDto);
        List<ProductImageDto> product = productImageService.uploads(id, multipartFile, "images");

        return product;
    }


}
