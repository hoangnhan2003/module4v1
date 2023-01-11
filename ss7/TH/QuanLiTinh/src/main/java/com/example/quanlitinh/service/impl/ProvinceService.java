package com.example.quanlitinh.service.impl;

import com.example.quanlitinh.model.Province;
import com.example.quanlitinh.repository.IProvinceRepository;
import com.example.quanlitinh.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProvinceService implements IProvinceService {
    @Autowired
    IProvinceRepository provinceRepository;

    @Override
    public Iterable<Province> getAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Optional<Province> findById(Long id) {
        return provinceRepository.findById(id);
    }

    @Override
    public void save(Province province) {
        provinceRepository.save(province);
    }

    @Override
    public void remove(Long id) {
        provinceRepository.deleteById(id);
    }
}
