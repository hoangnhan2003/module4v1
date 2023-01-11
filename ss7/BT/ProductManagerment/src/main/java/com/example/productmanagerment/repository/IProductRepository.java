package com.example.productmanagerment.repository;

import com.example.productmanagerment.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface IProductRepository extends JpaRepository<Product,Long> {
    Page<Product> findAllByProductNameLike(Pageable pageable, String productName);
    Product findByProductCode(Long id);

}
