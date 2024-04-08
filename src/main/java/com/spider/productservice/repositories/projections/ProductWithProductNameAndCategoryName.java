package com.spider.productservice.repositories.projections;

public interface ProductWithProductNameAndCategoryName {

//    here the productName and categoryName will be used in custom HQL
    String getProductName();
    String getCategoryName();
}
