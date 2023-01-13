package com.example.bt1.repository;

import com.example.bt1.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,String> {
    Page<User> findAllByUserNameLike(Pageable pageable,String userName);
    Page<User> findAllByAge(Pageable pageable,Integer age);
    Page<User> findUserByEmailLike(Pageable pageable,String email);
    User findByNumberPhone(String numberPhone);

}
