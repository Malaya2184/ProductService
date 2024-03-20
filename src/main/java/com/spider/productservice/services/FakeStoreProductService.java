package com.spider.productservice.services;

import com.spider.productservice.dtos.FakeStoreProductDto;
import com.spider.productservice.models.Category;
import com.spider.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
