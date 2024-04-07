package com.spider.productservice.services;

import com.spider.productservice.exceptions.ProductNotFoundException;
import com.spider.productservice.models.SelfCategory;
import com.spider.productservice.models.SelfProduct;
import com.spider.productservice.repositories.Categoryrepository;
import com.spider.productservice.repositories.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SelfProductService implements ProductService<SelfProduct>{
    private final ProductRepository productRepository;
    private final Categoryrepository categoryrepository;

    public SelfProductService(ProductRepository productRepository, Categoryrepository categoryrepository) {
        this.productRepository = productRepository;
        this.categoryrepository = categoryrepository;
    }

    @Override
    public SelfProduct getProductByid(Long id) {
        Optional<SelfProduct> response = productRepository.findById(id);
        if(response.isEmpty()){
            throw new ProductNotFoundException("This product is not available", id);
        }

        return response.get();
    }

    @Override
    public List<SelfProduct> getAllProducts() {
        List<SelfProduct> response = productRepository.findAll();
        if(response.isEmpty()){
            return  null;
        }
        return response;
    }

    @Override
    public SelfProduct createProduct(SelfProduct selfProduct) {
        SelfCategory selfCategory = selfProduct.getCategory();
        if(selfCategory.getId() == null){
            SelfCategory savedSelfCategory = categoryrepository.save(selfCategory);
            selfProduct.setCategory(savedSelfCategory);
        }
        return productRepository.save(selfProduct);
    }

    @Override
    public SelfProduct updateProduct(Long id, SelfProduct selfProduct) {
        return null;
    }

    @Override
    public SelfProduct replaceProduct(Long id, SelfProduct selfProduct) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }

//    non interface methods
    public List<SelfProduct> getProductByTitleLike(String phrase) {

    return productRepository.findByTitleContaining(phrase);
    }

    public ResponseEntity<SelfProduct> updateProductPost(Long id, SelfProduct product){
        Optional<SelfProduct> response = productRepository.findById(id);
        if(response.isEmpty()){
            throw new ProductNotFoundException("Product not found for exception", id);
        }
        SelfProduct responseProduct = response.get();
//        update with input product
//        responseProduct.setId(product.getId());
        responseProduct.setTitle(product.getTitle());
        responseProduct.setPrice(product.getPrice());
        responseProduct.setImage(product.getImage());
        responseProduct.setDescription(product.getDescription());
        responseProduct.setUpdatedAt(new Date());
        responseProduct.setCategory(product.getCategory());
        SelfProduct updatedResponse = productRepository.save(responseProduct);
        return ResponseEntity.ok(updatedResponse);
    }

}
