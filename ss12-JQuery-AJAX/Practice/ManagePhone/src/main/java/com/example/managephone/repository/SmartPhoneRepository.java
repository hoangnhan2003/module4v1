package com.example.managephone.repository;

import com.example.managephone.model.SmartPhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface SmartPhoneRepository extends JpaRepository<SmartPhone,Long> {
    List<SmartPhone> findAllByModelLike(String model);
}
