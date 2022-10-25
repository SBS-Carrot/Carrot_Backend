package com.carrot.backend.product.Service;

import com.carrot.backend.product.dao.ProductRepository;
import com.carrot.backend.product.domain.Product;
import com.carrot.backend.product.dto.ProductDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Optional<Product> getProduct(String productId) {
        return productRepository.findById(productId);
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        Product newProduct = new Product();

        product.setProductPrice(product.getProductPrice());
        product.setProductName(product.getProductName());
        product.setProductStock(product.getProductStock());
        productRepository.save(newProduct);

        return newProduct;
    }
}
