package com.carrot.backend.productImage.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Data
@Table(name="product_image")
public class ProductImages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long imageId;

    long productId;

    String path;

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
