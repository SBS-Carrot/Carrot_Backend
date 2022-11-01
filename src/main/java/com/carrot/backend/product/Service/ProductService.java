package com.carrot.backend.product.Service;

import com.carrot.backend.product.dao.ProductRepository;
import com.carrot.backend.product.domain.Product;
import com.carrot.backend.product.dto.ProductDto;
import com.carrot.backend.productImage.dao.ProductImageRepository;
import com.carrot.backend.util.DataNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;

    public Product getProduct(Integer productId) {
        return productRepository.findById(productId).orElseThrow(() -> new DataNotFoundException("question not found"));
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Integer createProduct(ProductDto productDto) {
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
