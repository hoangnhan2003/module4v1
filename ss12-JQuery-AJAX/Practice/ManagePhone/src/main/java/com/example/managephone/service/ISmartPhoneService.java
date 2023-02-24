package com.example.managephone.service;

import com.example.managephone.model.SmartPhone;
import java.util.*;

public interface ISmartPhoneService {
    List<SmartPhone> findAll();
    Optional<SmartPhone> findById(Long id);
    SmartPhone save(SmartPhone smartPhone);
    void remove(Long id);
    void remove(SmartPhone smartPhone);
    List<SmartPhone> findAllByModelLike(String model);

}
