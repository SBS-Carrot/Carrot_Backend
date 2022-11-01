package com.carrot.backend.product.dto;

import lombok.Data;

@Data
public class ProductDto {

    String productSubject;


    String productContent;

    public String getProductSubject() {
        return productSubject;
    }

    public void setProductSubject(String productSubject) {
        this.productSubject = productSubject;
    }

    public String getProductContent() {
        return productContent;
    }

    public void setProductContent(String productContent) {
        this.productContent = productContent;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    Integer productPrice;


    String productCategory;


}
