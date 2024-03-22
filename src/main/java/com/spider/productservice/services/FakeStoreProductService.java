package com.spider.productservice.services;

import com.spider.productservice.dtos.FakeStoreProductDto;
import com.spider.productservice.models.Category;
import com.spider.productservice.models.Product;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
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
        category.setTitle(fakeStoreProductDto.getTitle());
        product.setCategory(category);
        return product;
    }
    private List<Product> convertFakeStoreProductDtoListToProductList(FakeStoreProductDto[] fakeStoreProductDtoArr){
        List<Product> productList = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtoArr) {
            Product product = new Product();
            product.setId(fakeStoreProductDto.getId());
            product.setTitle(fakeStoreProductDto.getTitle());
            product.setPrice(fakeStoreProductDto.getPrice());
            // Assuming Category has a constructor that accepts id and title
            Category category = new Category();
            category.setTitle(fakeStoreProductDto.getTitle());
            product.setCategory(category);
            product.setDescription(fakeStoreProductDto.getDescription());
            product.setImage(fakeStoreProductDto.getImage());
            productList.add(product);
        }
        return productList;
    }
//    overloaded method of convertFakeStoreProductDtoListToProductList to receives arraylist as inpput
    private List<Product> convertFakeStoreProductDtoListToProductList(ArrayList<FakeStoreProductDto> fakeStoreProductDtoList){
        List<Product> productList = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtoList) {
            Product product = new Product();
            product.setId(fakeStoreProductDto.getId());
            product.setTitle(fakeStoreProductDto.getTitle());
            product.setPrice(fakeStoreProductDto.getPrice());
            // Assuming Category has a constructor that accepts id and title
            Category category = new Category();
            category.setTitle(fakeStoreProductDto.getCategory());
            product.setCategory(category);
            product.setDescription(fakeStoreProductDto.getDescription());
            product.setImage(fakeStoreProductDto.getImage());
            productList.add(product);
        }
        return productList;
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
        FakeStoreProductDto[] response = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreProductDto[].class
        );
//        to get product in formof list
/*        ResponseEntity<ArrayList<FakeStoreProductDto>> responseEntity =
                restTemplate.exchange(
                        "https://fakestoreapi.com/products",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<ArrayList<FakeStoreProductDto>>() {}
                );
        ArrayList<FakeStoreProductDto> response = responseEntity.getBody();
 */
        if(response != null){
            return convertFakeStoreProductDtoListToProductList(response);
        }
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }
}
