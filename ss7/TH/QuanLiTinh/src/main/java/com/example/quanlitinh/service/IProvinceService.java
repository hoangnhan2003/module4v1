package com.example.quanlitinh.service;

import com.example.quanlitinh.model.Province;
import java.util.List;
import java.util.Optional;

public interface IProvinceService {
    Iterable<Province> getAll();
    Optional<Province> findById(Long id);
    void save(Province province);
    void remove(Long id);

}
