package com.spider.productservice.repositories;

import com.spider.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
//    no need to add default methods only needed custom methods
//    default methods
    Optional<Product> findById(Long id);
    @Override
    List<Product> findAll();

    @Override
    Product save(Product entity);

    List<Product> findByTitleContaining(String phrase);
}
