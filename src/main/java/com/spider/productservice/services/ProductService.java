package com.spider.productservice.services;

import com.spider.productservice.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductByid(Long id);
    List<Product> getAllProducts();
    Product createProduct(Product product);
    Product updateProduct(Long id, Product product);
    Product replaceProduct(Long id, Product product);
    void deleteProduct(Long id);

}
