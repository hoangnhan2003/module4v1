package com.example.productmanagerment.service.Impl;

import com.example.productmanagerment.model.Product;
import com.example.productmanagerment.repository.IProductRepository;
import com.example.productmanagerment.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository productRepository;

    @Override
    public Product findById(Long id) {
        return productRepository.findByProductCode(id);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Page<Product> findAllProductNameLike(Pageable pageable, String productName) {
        return productRepository.findAllByProductNameLike(pageable,productName);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
