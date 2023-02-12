package com.example.manageproduct.service;

import com.example.manageproduct.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
}
