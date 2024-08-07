package com.spider.productservice.services;

import com.spider.productservice.dtos.ProductCategoryDto;
import com.spider.productservice.exceptions.ProductNotFoundException;
import com.spider.productservice.models.SelfCategory;
import com.spider.productservice.models.SelfProduct;
import com.spider.productservice.repositories.CategoryRepository;
import com.spider.productservice.repositories.ProductRepository;
import com.spider.productservice.repositories.ProductRepositoryCustomQuery;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service("selfProductService")
@Primary
public class SelfProductService implements ProductService<SelfProduct>{
    private final ProductRepository productRepository;
    private final CategoryRepository categoryrepository;

    private final ProductRepositoryCustomQuery productRepositoryCustomQuery;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryrepository, ProductRepositoryCustomQuery productRepositoryCustomQuery) {
        this.productRepository = productRepository;
        this.categoryrepository = categoryrepository;
        this.productRepositoryCustomQuery = productRepositoryCustomQuery;
    }

    //    search product by id
    @Override
    public SelfProduct getProductByid(Long id) {
        Optional<SelfProduct> response = productRepository.findById(id);
        if(response.isEmpty()){
            throw new ProductNotFoundException("This product is not available", id);
        }

        return response.get();
    }
//    get all the products
    @Override
    public List<SelfProduct> getAllProducts() {
        List<SelfProduct> response = productRepository.findAll();
        if(response.isEmpty()){
            return  null;
        }
        return response;
    }
//    create product
    @Override
    public SelfProduct createProduct(SelfProduct selfProduct) {
        SelfCategory selfCategory = selfProduct.getCategory();
//        use this if ther is no cascading
//        if(selfCategory.getId() == null){
//            SelfCategory savedSelfCategory = categoryrepository.save(selfCategory);
//            selfProduct.setCategory(savedSelfCategory);
//        }
//        if we passed alreay existed category for a new product
        if(selfCategory.getId() != null){
            Optional<SelfCategory> existeCategory = categoryrepository.findById(selfCategory.getId());
            selfProduct.setCategory(existeCategory.get());
        }
        return productRepository.save(selfProduct);
    }
//    update product using patch method
    @Override
    public SelfProduct updateProduct(Long id, SelfProduct selfProduct) {
        return null;
    }
//    replace product with put method
    @Override
    public SelfProduct replaceProduct(Long id, SelfProduct selfProduct) {
        return null;
    }
//    delete product with delete method
    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
//    non interface methods = search product by like query
    public List<SelfProduct> getProductByTitleLike(String phrase) {

    return productRepository.findByTitleContaining(phrase);
    }
//    update product using post method
    public ResponseEntity<SelfProduct> updateProductPost(Long id, SelfProduct product){
        Optional<SelfProduct> response = productRepository.findById(id);
        if(response.isEmpty()){
            throw new ProductNotFoundException("Product not found for exception", id);
        }
        SelfProduct responseProduct = response.get();
//        update with input product
        responseProduct.setTitle(product.getTitle());
        responseProduct.setPrice(product.getPrice());
        responseProduct.setImage(product.getImage());
        responseProduct.setDescription(product.getDescription());
        responseProduct.setUpdatedAt(new Date());
        SelfProduct updatedResponse = productRepository.save(responseProduct);
        return ResponseEntity.ok(updatedResponse);
    }

//    find product category from custom and native query
    public ResponseEntity<List<ProductCategoryDto>> findProductCategory(){
        List<ProductCategoryDto> response = productRepositoryCustomQuery.findProductCategory();
        return ResponseEntity.ok(response);
    }

//    pagination implemented service
public Page<SelfProduct> findPaginatedProducts(Pageable pageable){
    return productRepository.findAll(pageable);
}

}
