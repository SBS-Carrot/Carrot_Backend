package com.carrot.backend.productImage.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ProductImageDto {
    Integer imageId;

    String path;

    Integer productId;

    public ProductImageDto(Integer productId, String path) {
        this.path = path;
        this.productId = productId;
    }
}
