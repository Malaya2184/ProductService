package com.spider.productservice.controllers.testController;

import com.spider.productservice.models.SelfProduct;
import com.spider.productservice.services.SelfProductService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TestControllerTestMocking {
//    we have mocked the bin that means spring will not insert bean here this is a fake bean
    @MockBean
    private SelfProductService selfProductService;
    @Autowired
    private TestController testController;

    @Test
    @DisplayName("mocking custom product to check error is from controller or not")
    @Disabled
    public void mockingCustomProductToCheckErrorIsFromControllerOrNot() {

//        creating custom product list
        List<SelfProduct> li = new ArrayList<>();
        SelfProduct selfProduct = new SelfProduct();
//        ac to database
        selfProduct.setPrice(1200);
        li.add(selfProduct);
// that means when the mock self product service will call the get product then we are returning the correct product so the error will be from controller
        when(selfProductService.getAllProducts()).thenReturn(li);
        List<SelfProduct> allProducts = testController.getAllProducts();
        double price = allProducts.get(0).getPrice();

        assert price == 1200L;
    }
}
