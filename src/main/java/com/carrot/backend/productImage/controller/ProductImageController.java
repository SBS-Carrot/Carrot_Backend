package com.carrot.backend.productImage.controller;

import com.carrot.backend.product.Service.ProductService;
import com.carrot.backend.productImage.Service.ProductImageService;
import com.carrot.backend.productImage.dto.ProductImageDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@AllArgsConstructor
public class ProductImageController {
    private final ProductService productService;
    private final ProductImageService productImageService;

    @PostMapping("/createProductImages/{productId}")

    public ProductImageDto uploadProfilePhoto(@PathVariable ("productId") long productId, @RequestParam("files") MultipartFile multipartFile) throws IOException {

        return productImageService.upload(productId, multipartFile, "images");

    }


}
