package com.carrot.backend.product.domain;

import com.carrot.backend.product.dto.ProductDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="product")
public class Product {
    @Id
    String productId;
    String productName;
    Integer productPrice;
    Integer productStock;


}
