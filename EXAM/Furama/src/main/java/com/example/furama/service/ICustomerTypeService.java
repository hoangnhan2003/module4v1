package com.example.furama.service;

import com.example.furama.model.CustomerType;
import java.util.*;

public interface ICustomerTypeService {
    List<CustomerType> findAll();
    void save(CustomerType customerType);
    void delete(CustomerType customerType);

}
