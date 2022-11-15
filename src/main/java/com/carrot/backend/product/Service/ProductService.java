package com.carrot.backend.product.Service;

import com.carrot.backend.product.dao.CustomizedProductRepositoryImpl;
import com.carrot.backend.product.dao.ProductRepository;
import com.carrot.backend.product.domain.Product;
import com.carrot.backend.product.dto.ProductDto;
import com.carrot.backend.productImage.dao.ProductImageRepository;
import com.carrot.backend.util.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;

    private final CustomizedProductRepositoryImpl customizedProductRepository;
    public Product getProduct(Integer productId) {
        try {
            Optional<Product> product = this.productRepository.findByProductId(productId);
            if (product.isPresent()) {
                return product.get();
            }
        }catch(DataNotFoundException e){
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public ProductDto getProductWithImage(Integer productId){
        ProductDto product = customizedProductRepository.getQslProductsAndImagesByProductId(productId);
        return product;
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
        newProduct.setProductUserid(productDto.getProductUserid());
        LocalDateTime date = LocalDateTime.now();
        String dates = date.toString();
        String yymmdd = dates.substring(0,10);
        System.out.println(yymmdd);
        newProduct.setProductCreateTime(yymmdd);
        productRepository.save(newProduct);

        return newProduct.getProductId();
    }


    public void _productView(Integer productId) {
        Product product = productRepository.findByProductId(productId).orElseThrow(()-> new DataNotFoundException("product not found"));
        product.setProductView(product.getProductView()+1);
        productRepository.save(product);
    }
}
