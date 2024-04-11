package com.spider.productservice.controllers.testController;

import com.spider.productservice.controllers.ProductController;
import com.spider.productservice.dtos.ProductCategoryDto;
import com.spider.productservice.exceptions.ProductNotFoundException;
import com.spider.productservice.exceptions.specificexcrption.FakeStoreSpecificException;
import com.spider.productservice.models.SelfProduct;
import com.spider.productservice.services.SelfProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//this controller is made to learn all the testing stuffs - Junit and mockito
//Rquest mapping and mapping stuffs are not needed here you can ignore them
@RestController
@RequestMapping("/testController/products")
public class TestController implements ProductController<SelfProduct> {
    private SelfProductService productService;

    public TestController(@Qualifier("selfProductService") SelfProductService productService) {
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
        productService.deleteProduct(id);
    }

//    non interface methods
    @GetMapping("/titlelike/{phrase}")
    public List<SelfProduct> getProductByTitleLike(@PathVariable("phrase") String phrase) {
       return productService.getProductByTitleLike(phrase);
    }
// upadte product through postmapping
    @PostMapping("/upadteProductpost/{id}")
    public ResponseEntity<SelfProduct> updateProductPost(@PathVariable("id") Long id, @RequestBody SelfProduct product){
            return productService.updateProductPost(id,product);
    }
//
    @GetMapping("/findproductcategory")
    public ResponseEntity<List<ProductCategoryDto>> findProductCategory(){
        return productService.findProductCategory();
    }
}
