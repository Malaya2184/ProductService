package com.spider.productservice.repositories;

import com.spider.productservice.dtos.ProductCategoryDto;
import com.spider.productservice.models.SelfProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<SelfProduct,Long> {
//    no need to add default methods only needed custom methods
//    default methods
    Optional<SelfProduct> findById(Long id);
    @Override
    List<SelfProduct> findAll();

    @Override
    SelfProduct save(SelfProduct entity);

    List<SelfProduct> findByTitleContaining(String phrase);

//    using native sql query
//    here products = name of the selfProduct entity
//    category = category inside the Self product class
//    no need on condition it follows the same rule defined
//    passing value to the constructor
    @Query(value ="SELECT new com.spider.productservice.dtos.ProductCategoryDto(p.title,c.title) " +
            "FROM products p JOIN p.category c")
    List<ProductCategoryDto> findProductCategory();
}
