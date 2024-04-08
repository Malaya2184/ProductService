package com.spider.productservice.repositories.projections;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ProductCategoryProjectionImpl implements ProductWithProductNameAndCategoryName{
//    this variable name should come from getProductName & getCategoryName from interface
    private String productName;
    private String categoryName;
}
