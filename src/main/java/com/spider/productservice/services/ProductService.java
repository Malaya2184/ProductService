package com.spider.productservice.services;

import com.spider.productservice.dtos.FakeStoreProductDto;
import java.util.List;

public interface ProductService<T> {
    T getProductByid(Long id);
    List<T> getAllProducts();
    T createProduct(T product);
    T updateProduct(Long id, T product);
    T replaceProduct(Long id, T product);
    void deleteProduct(Long id);

}
