package com.example.bt1.model;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Size(min = 5,max = 45,message = "user name must have min length 5 character and max 45 character")
    private String userName;
    @Pattern(regexp = "(84|0)[0-9]{9,10}",message = "number phone must have 9 or 10 number")
    private String numberPhone;
    @Min(value = 18,message = "min age is 18")
    private int age;
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Z|a-z]{2,}$",message = "invalid email!!")
    private String email;

    public User() {
    }

    public User(String userName, String numberPhone, int age, String email) {
        this.userName = userName;
        this.numberPhone = numberPhone;
        this.age = age;
        this.email = email;
    }

    public User(Integer id, String userName, String numberPhone, int age, String email) {
        this.id = id;
        this.userName = userName;
        this.numberPhone = numberPhone;
        this.age = age;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
