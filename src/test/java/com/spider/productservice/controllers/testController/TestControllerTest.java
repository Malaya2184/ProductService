package com.spider.productservice.controllers.testController;

import com.spider.productservice.services.SelfProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TestControllerTest {
    @Autowired
    private TestController testController;
    @Autowired
    private SelfProductService selfProductService;
    @MockBean
    private SelfProductService mockSelfProductservice;

    @Test
    @DisplayName("test some assertions")
    public void testSomeAssertions() {
        assert "xxx" == "xxx";
        assert 1==1;
        Assertions.assertEquals(10,10);
    }

}