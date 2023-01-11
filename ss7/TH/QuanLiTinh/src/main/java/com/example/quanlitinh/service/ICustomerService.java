package com.example.quanlitinh.service;

import com.example.quanlitinh.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    Page<Customer> getAll(Pageable pageable);
    Optional<Customer> findById(Long id);
    void save(Customer customer);
    void remove(Long id);
}
