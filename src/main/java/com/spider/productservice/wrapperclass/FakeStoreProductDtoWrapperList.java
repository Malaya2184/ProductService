package com.spider.productservice.wrapperclass;

import com.spider.productservice.dtos.FakeStoreProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class FakeStoreProductDtoWrapperList {
    private List<FakeStoreProductDto> fakeStoreProductDtoList;
    public FakeStoreProductDtoWrapperList(){
        fakeStoreProductDtoList = new ArrayList<>();
    }
}
