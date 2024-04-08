package com.spider.productservice;

import com.spider.productservice.models.SelfProduct;
import com.spider.productservice.repositories.ProductRepository;
import com.spider.productservice.repositories.ProductRepositoryCustomQuery;
import com.spider.productservice.repositories.projections.ProductCategoryProjectionImpl;
import com.spider.productservice.repositories.projections.ProductWithIdAndTitle;
import com.spider.productservice.repositories.projections.ProductWithProductNameAndCategoryName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SelfProductServiceApplicationTests {
    @Autowired
    private ProductRepositoryCustomQuery productRepositoryCustomQuery;
    @Test
    void contextLoads() {
    }

    @Test
    public void testQueries(){
        // some random query run from productRepositoryCustomQuery
        List<SelfProduct> products = productRepositoryCustomQuery.someRandomeQuery();
        System.out.println(products);

        //  getting productsWithIdAndTitle from productRepositoryCustomQuery
        List<ProductWithIdAndTitle> productsWithIdAndTitle = productRepositoryCustomQuery.getProductWithIdAndTitle();

        // getting productWithProductNameAndCategoryNameList from productRepositoryCustomQuery using projection interface
        List<ProductWithProductNameAndCategoryName> productWithProductNameAndCategoryNameList1 = productRepositoryCustomQuery.getProductCategory1();
        for (ProductWithProductNameAndCategoryName p : productWithProductNameAndCategoryNameList1){
            System.out.println(p.getProductName() + "  " + p.getCategoryName());
        }

        //getting productWithProductNameAndCategoryNameList from productRepositoryCustomQuery using a DTO class which is impl of projection interface
        List<ProductCategoryProjectionImpl> productWithProductNameAndCategoryNameList2 = productRepositoryCustomQuery.getProductCategory2();

        System.out.println("debug");
    }
}
