package com.example.quanlitinh.repository;

import com.example.quanlitinh.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface IProvinceRepository extends JpaRepository<Province,Long> {
}
