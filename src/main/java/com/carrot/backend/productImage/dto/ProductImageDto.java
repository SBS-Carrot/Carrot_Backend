package com.carrot.backend.productImage.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductImageDto {
    Long imageId;
    String path;

    Long productId;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public ProductImageDto(Long productId,String path) {
        this.path = path;
        this.productId = productId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
