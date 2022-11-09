package com.carrot.backend.productLike.domain;

import com.carrot.backend.product.domain.Product;
import com.carrot.backend.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="product_like")
public class ProductLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch =FetchType.LAZY)
    private Product product;
    @ManyToOne(fetch =FetchType.LAZY)
    private User user;

    public ProductLike(Product product, User user){
        this.product = product;
        this.user = user;
    }
}
