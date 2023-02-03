package com.example.bt1.service.impl;

import com.example.bt1.model.User;
import com.example.bt1.repository.IUserRepository;
import com.example.bt1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Page<User> findAllByUserNameLike(Pageable pageable, String userName) {
        return userRepository.findAllByUserNameLike(pageable,userName);
    }

    @Override
    public Page<User> findAllByEmailLike(Pageable pageable, String email) {
        return userRepository.findUserByEmailLike(pageable,email);
    }

    @Override
    public User findUserByNumberPhone(String numberPhone) {
        return userRepository.findByNumberPhone(numberPhone);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
