package com.example.productmanagerment.service;

import com.example.productmanagerment.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Product findById(Long id);
    Page<Product> findAll(Pageable pageable);
    void save(Product product);
    Page<Product> findAllProductNameLike(Pageable pageable, String productName);
    void deleteProductById(Long id);


}
