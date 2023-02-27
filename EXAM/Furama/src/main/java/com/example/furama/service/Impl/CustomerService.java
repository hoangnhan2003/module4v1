package com.example.furama.service.Impl;

import com.example.furama.model.Customer;
import com.example.furama.repository.CustomerRepository;
import com.example.furama.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer findById(Integer customerId) {
        return customerRepository.findById(customerId).get();
    }

    @Override
    public void save(Customer newCustomer) {
        customerRepository.save(newCustomer);
    }

    @Override
    public void deleteById(Integer customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public Page<Customer> findAllByCustomerNameLike(String customerName, Pageable pageable) {
        return customerRepository.findAllByCustomerNameLike("%"+customerName+"%",pageable);
    }

    @Override
    public Page<Customer> findAllByAddressLike(String address, Pageable pageable) {
        return customerRepository.findAllByAddressLike("%"+address+"%",pageable);
    }
}
