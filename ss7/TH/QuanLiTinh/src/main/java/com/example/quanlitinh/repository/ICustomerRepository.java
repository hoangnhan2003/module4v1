package com.example.quanlitinh.repository;

import com.example.quanlitinh.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.transaction.Transactional;

@Transactional
public interface ICustomerRepository extends JpaRepository<Customer,Long> {

}
