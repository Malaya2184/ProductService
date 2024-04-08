package com.spider.productservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// using for custom query to find product with their category
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
public class ProductCategoryDto {
    String product;
    String category;

    public ProductCategoryDto(String product, String category) {
        this.product = product;
        this.category = category;
    }
}
