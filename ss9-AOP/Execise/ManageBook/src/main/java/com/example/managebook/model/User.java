package com.example.managebook.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @NotBlank(message = "user name can't be left blank")
    @UniqueElements(message = "duplicate user name")
    private String userName;
    @NotBlank(message = "password can't be left blank")
    private String password;
    private Boolean sex;
    @NotBlank(message = "Address can't be left blank")
    private String address;

    public User(){

    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }



    public User(Long id, String userName, Boolean sex, String address) {
        this.id = id;
        this.userName = userName;
        this.sex = sex;
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public User(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
