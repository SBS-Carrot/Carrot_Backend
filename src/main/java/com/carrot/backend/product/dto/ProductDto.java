package com.carrot.backend.product.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ProductDto {

    String productSubject;

    String productContent;

    String productPrice;

    String productCategory;


}
