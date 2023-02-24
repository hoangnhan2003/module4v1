package com.example.managephone.service.impl;

import com.example.managephone.model.SmartPhone;
import com.example.managephone.repository.SmartPhoneRepository;
import com.example.managephone.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SmartPhoneService implements ISmartPhoneService {
    @Autowired
    private SmartPhoneRepository smartPhoneRepository;

    @Override
    public List<SmartPhone> findAll() {
        return smartPhoneRepository.findAll();
    }

    @Override
    public Optional<SmartPhone> findById(Long id) {
        return smartPhoneRepository.findById(id);
    }

    @Override
    public SmartPhone save(SmartPhone smartPhone) {
        return smartPhoneRepository.save(smartPhone);
    }

    @Override
    public void remove(Long id) {
        smartPhoneRepository.deleteById(id);
    }

    @Override
    public void remove(SmartPhone smartPhone) {
        smartPhoneRepository.delete(smartPhone);
    }

    @Override
    public List<SmartPhone> findAllByModelLike(String model) {
        return smartPhoneRepository.findAllByModelLike("%"+model+"%");
    }
}
