package com.carrot.backend.productImage.domain;

import com.carrot.backend.product.domain.Product;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="product_image")
public class ProductImages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long imageId;



    String path;

    @ManyToOne
    private Product product;

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }



    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
