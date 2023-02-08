package com.example.managebook.service;

import com.example.managebook.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {
    Page<User> getAll(Pageable pageable);
    Page<User> findAllByUserName(Pageable pageable,String userName);
    Page<User> findAllByAddress(Pageable pageable,String address);
    void save(User user);
    void delete(User user);
    void deleteById(Long id);
    User findById(Long id);
    User findUserByUserNameAndPassword(String userName,String password);

}
