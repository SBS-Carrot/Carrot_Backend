package com.carrot.backend.product.Service;

import com.carrot.backend.product.dao.CustomizedProductRepositoryImpl;
import com.carrot.backend.product.dao.ProductRepository;
import com.carrot.backend.product.domain.Product;
import com.carrot.backend.product.dto.ProductDto;
import com.carrot.backend.productImage.dao.ProductImageRepository;
import com.carrot.backend.user.dao.UserRepository;
import com.carrot.backend.util.DataNotFoundException;
import com.querydsl.core.Tuple;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final UserRepository userRepository;
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

    public List<Tuple> getProductWithImage(Integer productId){
        List<Tuple> product = customizedProductRepository.getQslProductsAndImagesByProductId(productId);
        System.out.println("product:"+product.get(0));
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
        LocalDateTime date = LocalDateTime.now();
        String dates = date.toString();
        String yymmdd = dates.substring(0,10);


        newProduct.setProductCreateTime(yymmdd);


        productRepository.save(newProduct);

        return newProduct.getProductId();
    }



}
