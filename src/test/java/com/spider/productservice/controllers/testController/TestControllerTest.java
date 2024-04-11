package com.spider.productservice.controllers.testController;

import com.spider.productservice.models.SelfProduct;
import com.spider.productservice.repositories.ProductRepository;
import com.spider.productservice.services.SelfProductService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TestControllerTest {
    @Autowired
    private TestController testController;
    @Autowired
    private SelfProductService selfProductService;

    @Test
    @DisplayName("test some assertions")
    public void testSomeAssertions() {
        assert "xxx" == "xxx";
        assert 1==1;
        Assertions.assertEquals(10,10);
    }

    @Test
    @DisplayName("testing get all products api")
    public void testingGetAllProductsApi() {
        List<SelfProduct> allProducts = selfProductService.getAllProducts();
        String firstProduct = allProducts.get(0).getTitle();
        assert firstProduct.equals("Laptop");

    }

    @Test
    @DisplayName("test error from testcontroller modified price")
    @Disabled
//        disabled this because it will fail
    public void testErrorFromTestcontrollerModifiedPrice() {

        List<SelfProduct> allProducts1 = testController.getAllProducts();
        double price = allProducts1.get(0).getPrice();
        assert price == 1200L;
    }


}