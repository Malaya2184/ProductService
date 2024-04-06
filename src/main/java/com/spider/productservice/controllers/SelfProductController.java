package com.spider.productservice.controllers;

import com.spider.productservice.exceptions.ProductNotFoundException;
import com.spider.productservice.exceptions.specificexcrption.FakeStoreSpecificException;
import com.spider.productservice.models.Product;
import com.spider.productservice.services.ProductService;
import com.spider.productservice.services.SelfProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/self/products")
public class SelfProductController implements ProductController<Product>{
    private SelfProductService productService;

    public SelfProductController(@Qualifier("selfProductService") SelfProductService productService) {
        this.productService = productService;
    }

    @Override
    public ResponseEntity<Product> getProductById(Long id) throws ProductNotFoundException {
        return new ResponseEntity<>(productService.getProductByid(id),HttpStatus.OK);
    }

    @Override
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @Override
    public ResponseEntity<Product> createProduct(Product product) {
        Product response = productService.createProduct(product);
        if (response == null){
            return null;
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) throws FakeStoreSpecificException {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }

//    non interface methods
    @GetMapping("/titlelike/{phrase}")
    public List<Product> getProductByTitleLike(@PathVariable("phrase") String phrase) {
       return productService.getProductByTitleLike(phrase);
    }

}
