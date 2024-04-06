package com.spider.productservice.controllers;

import com.spider.productservice.exceptions.ProductNotFoundException;
import com.spider.productservice.exceptions.specificexcrption.FakeStoreSpecificException;
import com.spider.productservice.models.SelfProduct;
import com.spider.productservice.services.SelfProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/self/products")
public class SelfProductController implements ProductController<SelfProduct>{
    private SelfProductService productService;

    public SelfProductController(@Qualifier("selfProductService") SelfProductService productService) {
        this.productService = productService;
    }

    @Override
    public ResponseEntity<SelfProduct> getProductById(Long id) throws ProductNotFoundException {
        return new ResponseEntity<>(productService.getProductByid(id),HttpStatus.OK);
    }

    @Override
    public List<SelfProduct> getAllProducts() {
        return productService.getAllProducts();
    }

    @Override
    public ResponseEntity<SelfProduct> createProduct(SelfProduct selfProduct) {
        SelfProduct response = productService.createProduct(selfProduct);
        if (response == null){
            return null;
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public SelfProduct updateProduct(Long id, SelfProduct selfProduct) {
        return null;
    }

    @Override
    public SelfProduct replaceProduct(Long id, SelfProduct selfProduct) throws FakeStoreSpecificException {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }

//    non interface methods
    @GetMapping("/titlelike/{phrase}")
    public List<SelfProduct> getProductByTitleLike(@PathVariable("phrase") String phrase) {
       return productService.getProductByTitleLike(phrase);
    }

}
