package com.spider.productservice.services;

import com.spider.productservice.exceptions.ProductNotFoundException;
import com.spider.productservice.models.Category;
import com.spider.productservice.models.Product;
import com.spider.productservice.repositories.Categoryrepository;
import com.spider.productservice.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SelfProductService implements ProductService{
    private final ProductRepository productRepository;
    private final Categoryrepository categoryrepository;

    public SelfProductService(ProductRepository productRepository, Categoryrepository categoryrepository) {
        this.productRepository = productRepository;
        this.categoryrepository = categoryrepository;
    }

    @Override
    public Product getProductByid(Long id) {
        Optional<Product> response = productRepository.findById(id);
        if(response.isEmpty()){
            throw new ProductNotFoundException("This product is not available", id);
        }

        return response.get();
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> response = productRepository.findAll();
        if(response.isEmpty()){
            return  null;
        }
        return response;
    }

    @Override
    public Product createProduct(Product product) {
        Category category = product.getCategory();
        if(category.getId() == null){
            Category savedCategory = categoryrepository.save(category);
            product.setCategory(savedCategory);
        }
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }

//    non interface methods
    public List<Product> getProductByTitleLike(String phrase) {

    return productRepository.findByTitleContaining(phrase);
    }

}
