package com.spider.productservice.services;

import com.spider.productservice.dtos.ProductDto;
import com.spider.productservice.models.Category;
import com.spider.productservice.models.Product;
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

    private Product convertFakeStoreProductDtoToProduct(ProductDto productDto){

        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setImage(productDto.getImage());

        Category category = new Category();
        category.setTitle(productDto.getTitle());
        product.setCategory(category);
        return product;
    }
    @Override
    public Product getProductByid(Long id) {
        //        call the FakeStore API here to get the product with given ID here.
        ProductDto productDto = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, ProductDto.class);
//        convert DTO to actual Product
        if (productDto != null) {
            return convertFakeStoreProductDtoToProduct(productDto);
        }
        return null;
    }


    @Override
    public List<Product> getAllProducts() {
        // To get the response in the form of array
        ProductDto[] productDtos = restTemplate.getForObject("https://fakestoreapi.com/products", ProductDto[].class);
        List<Product> productList = new ArrayList<>();
        if (productDtos != null) {
            for (ProductDto productDto : productDtos) {
                productList.add(convertFakeStoreProductDtoToProduct(productDto));
            }
        }
        return productList;

    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long id, ProductDto productDto) {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, ProductDto productDto) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }
}
