package com.example.furama.service;

import com.example.furama.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);
    Customer findById(Integer customerId);
    void save(Customer newCustomer);
    void deleteById(Integer customerId);
    void delete(Customer customer);
    Page<Customer> findAllByCustomerNameLike(String customerName,Pageable pageable);
    Page<Customer> findAllByAddressLike(String address,Pageable pageable);
}
