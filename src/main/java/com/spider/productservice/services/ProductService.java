package com.spider.productservice.services;

import com.spider.productservice.dtos.ProductDto;
import com.spider.productservice.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductByid(Long id);
    List<Product> getAllProducts();
    Product createProduct(Product product);
    Product updateProduct(Long id, ProductDto productDtoduct);
    Product replaceProduct(Long id, ProductDto productDto);
    void deleteProduct(Long id);

}
