package com.carrot.backend.product.dto;

import com.carrot.backend.product.domain.Product;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductDto {
    private String productId;
    private String productName;
    private int productPrice;
    private int productStock;

    public Product toEntity(){
        return Product.builder()
                .productId(productId)
                .productName(productName)
                .productPrice(productPrice)
                .productStock(productStock)
                .build();
    }
}
