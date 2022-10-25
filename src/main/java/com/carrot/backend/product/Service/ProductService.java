package com.carrot.backend.product.Service;

import com.carrot.backend.product.dao.ProductRepository;
import com.carrot.backend.product.domain.Product;
import com.carrot.backend.product.dto.ProductDto;
import com.carrot.backend.productImage.Service.ProductImageService;
import com.carrot.backend.productImage.dao.ProductImageRepository;
import com.carrot.backend.productImage.domain.ProductImages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;
    private final ProductImageService productImageService;
    public Optional<Product> getProduct(Long productId) {
        return productRepository.findById(productId);
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Long createProduct(ProductDto productDto) {
        Product newProduct = new Product();

        newProduct.setProductPrice(productDto.getProductPrice());
        newProduct.setProductSubject(productDto.getProductSubject());
        newProduct.setProductContent(productDto.getProductContent());
        newProduct.setProductCategory(productDto.getProductCategory());
        newProduct.setProductChatting(0);
        newProduct.setProductLike(0);
        newProduct.setProductView(0);
        productRepository.save(newProduct);


        return newProduct.getProductId();
    }
}
