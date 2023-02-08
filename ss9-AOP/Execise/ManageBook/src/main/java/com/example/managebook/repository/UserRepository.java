package com.example.managebook.repository;

import com.example.managebook.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    Page<User> findAllByUserNameLike(Pageable pageable,String userName);
    User findUserById(Long userId);
    Page<User> findUserByAddressLike(Pageable pageable,String address);
    void deleteById(Long userId);
    User findUserByUserNameAndPassword(String userName,String password);
}
