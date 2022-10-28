package com.carrot.backend.productImage.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductImageDto {
    Integer imageId;
    String path;

    Integer productId;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public ProductImageDto(Integer productId,String path) {
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
