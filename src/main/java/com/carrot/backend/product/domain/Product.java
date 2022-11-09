package com.carrot.backend.product.domain;

import com.carrot.backend.productImage.domain.ProductImages;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer productId;
    @Column(length = 40)
    @NotEmpty
    String productSubject;
    @Column(length = 200)
    @NotEmpty
    String productContent;
    @Column
    @NotEmpty
    String productPrice;
    @Column
    Integer productChatting;
    @Column
    Integer productView;
    @Column
    Integer productLike;

    String productCreateTime;
    @Column
    @NotEmpty
    String productCategory;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<ProductImages> images;

}
