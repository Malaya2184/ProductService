package com.spider.productservice.services;

import com.spider.productservice.dtos.FakeStoreProductDto;
import com.spider.productservice.models.Category;
import com.spider.productservice.models.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService") // explicitly named this bin so that can get this exact bean using @Qualifier anotation
public class FakeStoreProductService implements ProductService{
    private final RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto){

        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());

        Category category = new Category();
        category.setTitle(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }
    private FakeStoreProductDto convertProductToFakeStoreDto(Product product) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setId(product.getId());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setImage(product.getImage());
        fakeStoreProductDto.setCategory(product.getCategory().getTitle());
        fakeStoreProductDto.setDescription(product.getDescription());
        return fakeStoreProductDto;
    }
    @Override
    public Product getProductByid(Long id) {
        //        call the FakeStore API here to get the product with given ID here.
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDto.class);
//        convert DTO to actual Product
        if (fakeStoreProductDto != null) {
            return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
        }
        return null;
    }


    @Override
    public List<Product> getAllProducts() {
        // To get the response in the form of array
        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);
        List<Product> productList = new ArrayList<>();
        if (fakeStoreProductDtos != null) {
            for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
                productList.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
            }
        }
        return productList;

    }

    @Override
    public Product createProduct(Product product) {
        FakeStoreProductDto fakeStoreProductDto = convertProductToFakeStoreDto(product);

        FakeStoreProductDto responseDto = restTemplate.postForObject(
                "https://fakestoreapi.com/products", // url
                fakeStoreProductDto, // request body
                FakeStoreProductDto.class // data type of response
        );
        if (responseDto != null) {
            return convertFakeStoreProductDtoToProduct(responseDto);
        }
        return null;
    }


    @Override
    public Product updateProduct(Long id, Product product) {
        FakeStoreProductDto fakeStoreProductDto = convertProductToFakeStoreDto(product);
        HttpEntity<FakeStoreProductDto> request = new HttpEntity<>(fakeStoreProductDto);
        ResponseEntity<FakeStoreProductDto> response = restTemplate.exchange(
                "https://fakestoreapi.com/products/" + id,
                HttpMethod.PATCH,
                request,
                FakeStoreProductDto.class
        );
        FakeStoreProductDto responseDto = response.getBody();
        return convertFakeStoreProductDtoToProduct(responseDto);
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        FakeStoreProductDto fakeStoreProductDto = convertProductToFakeStoreDto(product);
        HttpEntity<FakeStoreProductDto> request = new HttpEntity<>(fakeStoreProductDto);
        ResponseEntity<FakeStoreProductDto> response = restTemplate.exchange(
                "https://fakestoreapi.com/products/" + id,
                HttpMethod.PUT,
                request,
                FakeStoreProductDto.class
        );
        FakeStoreProductDto responseDto = response.getBody();
        return convertFakeStoreProductDtoToProduct(responseDto);
    }

    @Override
    public void deleteProduct(Long id) {
        restTemplate.delete("https://fakestoreapi.com/products/" + id);
    }
}
