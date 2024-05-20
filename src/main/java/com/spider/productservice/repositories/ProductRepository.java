package com.spider.productservice.repositories;

import com.spider.productservice.dtos.ProductCategoryDto;
import com.spider.productservice.models.SelfProduct;
import com.spider.productservice.repositories.projections.ProductCategoryProjectionImpl;
import com.spider.productservice.repositories.projections.ProductWithIdAndTitle;
import com.spider.productservice.repositories.projections.ProductWithProductNameAndCategoryName;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    Page<SelfProduct> findAll(Pageable pageable);

    @Override
    SelfProduct save(SelfProduct entity);

    List<SelfProduct> findByTitleContaining(String phrase);
}
