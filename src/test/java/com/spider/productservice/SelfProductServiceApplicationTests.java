package com.spider.productservice;

import com.spider.productservice.models.SelfProduct;
import com.spider.productservice.repositories.CategoryRepository;
import com.spider.productservice.repositories.ProductRepository;
import com.spider.productservice.repositories.ProductRepositoryCustomQuery;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class SelfProductServiceApplicationTests {
    @Autowired
    private ProductRepositoryCustomQuery productRepositoryCustomQuery;
    @Autowired
    private CategoryRepository categoryrepository;
    @Autowired
    private ProductRepository productRepository;
    @Test
    void contextLoads() {
    }

    @Test
    public void testQueries(){
//        //native sql query to gt product details
//        List<SelfProduct> allProducts = productRepositoryCustomQuery.findAllTheProducts();
//        // some random query run from productRepositoryCustomQuery
//        List<SelfProduct> products = productRepositoryCustomQuery.someRandomeQuery();
//        System.out.println(products);
//
//        //  getting productsWithIdAndTitle from productRepositoryCustomQuery
//        List<ProductWithIdAndTitle> productsWithIdAndTitle = productRepositoryCustomQuery.getProductWithIdAndTitle();
//
//        // getting productWithProductNameAndCategoryNameList from productRepositoryCustomQuery using projection interface
//        List<ProductWithProductNameAndCategoryName> productWithProductNameAndCategoryNameList1 = productRepositoryCustomQuery.getProductCategory1();
//        for (ProductWithProductNameAndCategoryName p : productWithProductNameAndCategoryNameList1){
//            System.out.println(p.getProductName() + "  " + p.getCategoryName());
//        }
//
//        //getting productWithProductNameAndCategoryNameList from productRepositoryCustomQuery using a DTO class which is impl of projection interface
//        List<ProductCategoryProjectionImpl> productWithProductNameAndCategoryNameList2 = productRepositoryCustomQuery.getProductCategory2();

//        List<SelfProduct> productsByCatId = productRepositoryCustomQuery.findByCategory_Id(1L);
//
//        System.out.println("debug");
    }
    @Test
    @Transactional
    public void testCategoryRepoQueries(){
////        to check cascad relation of forign key of category id with products
//        categoryrepository.deleteById(1L);

//        -------------------------------------------------------------------------------------
//        it will have no product list inside it but when we will cal get product then it will load product
//        Optional<SelfProduct> optioanlProduct = productRepositoryCustomQuery.findById(2L);
//        Optional<SelfCategory> optionalCategory = categoryrepository.findById(2L);
//        Optional<SelfProduct> prod = productRepositoryCustomQuery.findById(1L);
        Optional<SelfProduct> byId = productRepository.findById(4L);
//        SelfCategory c = optionalResponse.get();
//        List<SelfProduct> p = c.getProducts();

        System.out.println("debug 1");


//        System.out.println(p);
        System.out.println("debug 2");


    }
}
