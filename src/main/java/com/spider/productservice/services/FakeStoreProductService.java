package com.spider.productservice.services;

import com.spider.productservice.dtos.FakeStoreProductDto;
import com.spider.productservice.models.FakeStoreCategory;
import com.spider.productservice.models.FakeStoreProduct;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
// explicitly named this bin so that can get this exact bean using @Qualifier anotation
public class FakeStoreProductService implements ProductService<FakeStoreProduct> {
    private final RestTemplate restTemplate;
    private final RedisTemplate redisTemplate;

    public FakeStoreProductService(RestTemplate restTemplate, RedisTemplate redisTemplate) {
        this.restTemplate = restTemplate;
        this.redisTemplate = redisTemplate;
    }

    private FakeStoreProduct convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {

        FakeStoreProduct product = new FakeStoreProduct();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());

        FakeStoreCategory category = new FakeStoreCategory();
        category.setTitle(fakeStoreProductDto.getCategory());
        product.setFakeStoreCategory(category);
        return product;
    }

    private FakeStoreProductDto convertProductToFakeStoreDto(FakeStoreProduct product) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setId(product.getId());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setImage(product.getImage());
        fakeStoreProductDto.setCategory(product.getFakeStoreCategory().getTitle());
        fakeStoreProductDto.setDescription(product.getDescription());
        return fakeStoreProductDto;
    }

    @Override
    public FakeStoreProduct getProductByid(Long id) {

//        First search in the redis if cachehit then return the object or if cache miss stor thatt obj in  redis
        FakeStoreProduct fakeStoreProduct = (FakeStoreProduct) redisTemplate.opsForHash().get("FAKE_STORE_PRODUCT", "FAKE_STORE_PRODUCT_" + id);
        if (fakeStoreProduct != null) {
//            cache hit
            return fakeStoreProduct;
        }
//        FakeStoreProduct fakeStoreProduct = redisTemplate.opsForHash().get();
        //        call the FakeStore API here to get the product with given ID here.
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
//        convert DTO to actual FakeStoreProduct
        if (fakeStoreProductDto != null) {
            FakeStoreProduct product = convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
            redisTemplate.opsForHash().put("FAKE_STORE_PRODUCT", "FAKE_STORE_PRODUCT_" + id, product);
            return product;
        }
        return null;
    }


    @Override
    public List<FakeStoreProduct> getAllProducts() {
        // To get the response in the form of array
        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);
        List<FakeStoreProduct> productList = new ArrayList<>();
        if (fakeStoreProductDtos != null) {
            for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
                productList.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
            }
        }
        return productList;

    }

    @Override
    public FakeStoreProduct createProduct(FakeStoreProduct product) {
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
    public FakeStoreProduct updateProduct(Long id, FakeStoreProduct product) {
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
    public FakeStoreProduct replaceProduct(Long id, FakeStoreProduct product) {
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
