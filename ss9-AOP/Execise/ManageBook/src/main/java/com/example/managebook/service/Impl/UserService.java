package com.example.managebook.service.Impl;

import com.example.managebook.model.User;
import com.example.managebook.repository.UserRepository;
import com.example.managebook.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<User> getAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Page<User> findAllByUserName(Pageable pageable, String userName) {
        return userRepository.findAllByUserNameLike(pageable,userName);
    }

    @Override
    public Page<User> findAllByAddress(Pageable pageable, String address) {
        return userRepository.findUserByAddressLike(pageable,address);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public User findUserByUserNameAndPassword(String userName, String password) {
        return userRepository.findUserByUserNameAndPassword(userName, password);
    }
}
