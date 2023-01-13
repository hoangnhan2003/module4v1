package com.example.bt1.service;

import com.example.bt1.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {
    Page<User> findAll(Pageable pageable);
    Page<User> findAllByUserNameLike(Pageable pageable,String userName);
    Page<User> findAllByEmailLike(Pageable pageable,String email);
    User findUserByNumberPhone(String numberPhone);
    void save(User user);
}
